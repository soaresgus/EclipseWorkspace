package net.eduard.api.lib.score

import net.eduard.api.lib.abstraction.PlayerScore
import net.eduard.api.lib.kotlin.copy
import net.eduard.api.lib.kotlin.cut
import net.eduard.api.lib.modules.Mine
import net.minecraft.server.v1_8_R3.ScoreboardServer
import java.util.HashMap
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboard
import org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboardManager
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Scoreboard
import java.lang.Exception

/**
 * API de criação de Scoreboard feita para facilitar sua vida
 * <br>
 * Updates
 * <br>
 * v1.1 Suporte a Animação de Frames a cada ticks
 * <br>
 * v1.2 Usando PlayerScore Classe para Scoreobard direto com NMS
 *
 * @author Eduard
 * @version 1.1
 */
open class DisplayBoard(
    /**
     * Titulo da scoreboard
     */

    var title: String,

    var lines: MutableList<String>
) {
    /**
     * Construtor vazio setando o nome da Scoreboard de '§6§lScoreboard'
     */
    constructor() : this("§6§lScoreboard", mutableListOf("§aLinha1"))
    constructor(title: String, vararg lines: String) : this(title, lines.toMutableList())

    var customLines = mutableListOf<DisplayBoardLine>()
    var customTitle: DisplayBoardLine? = null

    @Transient
    var score: PlayerScore? = null

    fun hasScore() = score != null

    @Transient
    private var cache: MutableMap<Int, String> = HashMap()

    /**
     * Aplica a Scoreboard no Jogador
     *
     * @param player Jogador
     */
    fun apply(player: Player) {
        score = PlayerScore.getScore(player)
        score!!.player = player
        score!!.removeAllLines()
        score!!.removeAllTeams()
        cache.clear()
        score!!.rebuild()
        update()

    }

    fun update() {
        if (!hasScore()) return
        var id = 15
        for (line in lines) {
            set(id, Mine.getReplacers(line, score!!.player))
            id--
        }

        for (line in customLines) {
            line.check()
            set(line.position, Mine.getReplacers(line.text, score!!.player))
        }
        customTitle?.check()
        setDisplay(customTitle?.text ?: title)
    }

    fun setHealthBar(health: String) {

    }

    open fun setLine(prefix: String, center: String, suffix: String, line: Int) {
        score!!.setLine(line, prefix, center, suffix)
    }

    fun copy(): DisplayBoard {
        val newScore = DisplayBoard(this.title, this.lines.toMutableList())
        for(customLine in this.customLines){
            newScore.customLines.add(customLine.copy())
        }

        return newScore
    }

    fun clone(): DisplayBoard {
        return copy()
    }


    open fun updateHealthBar(player: Player) {

    }

    open fun empty(slot: Int) {
        set(slot, "§f" + ChatColor.values()[slot - 1])
    }

    fun update(player: Player) {
        update()
    }

    var healthBarEnabled = false
    open fun getDisplay(): String {
        return score!!.getTitle()
    }

    open fun setDisplay(name: String) {
        score!!.setTitle(name)
    }

    fun getScoreboard()
            : Scoreboard? = null

    open fun getHealthBar(): String {
        return ""
    }

    open fun add(line: String) {
        this.lines.add(line)
    }



    private fun id(slot: Int): Int {
        return if (slot <= 0) 1 else Math.min(slot, 15)
    }

    operator fun set(slot: Int, line: String): Boolean {
        if (!hasScore()) return false
        var text = line
        val id = id(slot)

        if (line.trim().isEmpty()){
            text = "§f"+ChatColor.values()[id-1]
        }


        if (line == cache[id]) {
            // Não vai atualizar pois é a mesma
            return true
        }
        val prefixLimit = 16
        val suffixLimit = 16
        // 16 + 40 + 16 = Tamanho maximo de uma linha
        text = text.cut(prefixLimit + score!!.getNameLimit() + suffixLimit)


        var prefix = ""

        var center = ""

        var suffix = ""

        if (text.length <= score!!.getNameLimit()) {
            center = text
        } else if (text.length <= score!!.getNameLimit() + prefixLimit) {
            center = text.substring(0, score!!.getNameLimit())
            suffix = text.substring(score!!.getNameLimit())
        } else if (text.length <= (score!!.getNameLimit() + prefixLimit + suffixLimit)) {
            prefix = text.substring(0, prefixLimit)
            center = text.substring(prefixLimit, prefixLimit + score!!.getNameLimit() - 1)
            suffix = text.substring(prefixLimit + score!!.getNameLimit())
        }
        cache[id] = text
        score!!.setLine(id, prefix, center, suffix)
        return true
    }

    /**
     * Remove a linha da Scoreboard
     *
     * @param slot Linha
     */
    fun clear(slot: Int) {
        val id = id(slot)
        remove(id)
    }

    /**
     * Remove a linha da Scoreboard
     *
     * @param slot Linha
     */
    fun remove(id: Int): Boolean {

        // Antigo código
        //scoreboard!!.resetScores(fake)
        score!!.clearLine(id)
        return false
    }


}

