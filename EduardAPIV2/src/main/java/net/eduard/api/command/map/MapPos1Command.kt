package net.eduard.api.command.map

import net.eduard.api.lib.manager.CommandManager
import net.eduard.api.lib.modules.Mine
import net.eduard.api.server.minigame.MinigameSchematic

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MapPos1Command : CommandManager("pos1", "setpos1", "setlow") {
    override fun onCommand(
        sender: CommandSender, command: Command,
        label: String, args: Array<String>
    ): Boolean {
        if (!Mine.onlyPlayer(sender)) return true
        val player = sender as Player
        val schema =
            MinigameSchematic.getSchematic(player)
        schema.low = player.location.toVector()
        player.sendMessage("§bEduardAPI §aPosicão 1 setada!")

        return true
    }

    init {
        description = "Define a posição 1"
    }
}