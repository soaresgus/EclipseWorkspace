package net.eduard.api.command

import net.eduard.api.lib.manager.CommandManager
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class MemoryCommand : CommandManager("memory", "memoria") {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        val div = 1000*1000
        val memoriaDisponivel = (Runtime.getRuntime().freeMemory() / div)
        val totalMemoria = (Runtime.getRuntime().totalMemory() / div)
        val maximoMemoria = Runtime.getRuntime().maxMemory() / div
        val memoriaUsada = totalMemoria - memoriaDisponivel
        sender.sendMessage("§aVerificador de uso de Memoria")
        sender.sendMessage("§bMemoria Disponivel: ${memoriaDisponivel}MB")
        sender.sendMessage("§bMemoria Total: ${totalMemoria}MB")
        sender.sendMessage("§aMemoria Maxima: ${maximoMemoria}MB")
        sender.sendMessage("§aMemoria Usada: ${memoriaUsada}MB")



        return true
    }
}