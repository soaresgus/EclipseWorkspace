package me.ninjay.aurealobby;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoCargos implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {

			Player p = (Player) sender;
			if (!p.hasPermission("admin.use")) {
				return true;
			}
			if (p.hasPermission("admin.use") && args.length == 0) {
				p.sendMessage(
						"§6§lCargos disponiveis:\n§6» Master\n§4» Gerente\n§c» Admin\n§2» Moderador\n§e» Ajudante\n§a» Construtor\n§c» Youtuber\n§5» Galaxy\n§d» Meteor\n§b» Moon\n§7» Membro");
				return true;
			}
			String set = args[1];
			String tag = args[2];
			Player p2 = Bukkit.getPlayer(args[0]);
			if (p.hasPermission("admin.use") && p2 == null) {
				p.sendMessage("§cJogador offline.");
				return true;
			}
			if (p.hasPermission("admin.use") && args.length == 1) {
				p.sendMessage(
						"§6§lCargos disponiveis:\n§6» Master\n§4» Gerente\n§c» Admin\n§2» Moderador\n§e» Ajudante\n§a» Construtor\n§c» Youtuber\n§5» Galaxy\n§d» Meteor\n§b» Moon\n§7» Membro");
				return true;
			}
			if (p.hasPermission("admin.use") && args.length == 2) {
				p.sendMessage(
						"§6§lCargos disponiveis:\n§6» Master\n§4» Gerente\n§c» Admin\n§2» Moderador\n§e» Ajudante\n§a» Construtor\n§c» Youtuber\n§5» Galaxy\n§d» Meteor\n§b» Moon\n§7» Membro");
				return true;
			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("master")) {
				p2.sendMessage("§aVocê recebeu a tag master de " + p.getName());
				p.sendMessage("§aVocê setou a tag master para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerAdd(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("gerente")) {
				p2.sendMessage("§aVocê recebeu a tag gerente de " + p.getName());
				p.sendMessage("§aVocê setou a tag gerente para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerAdd(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("admin")) {
				p2.sendMessage("§aVocê recebeu a tag admin de " + p.getName());
				p.sendMessage("§aVocê setou a tag admin para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerAdd(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("moderador")) {
				p2.sendMessage("§aVocê recebeu a tag moderador de " + p.getName());
				p.sendMessage("§aVocê setou a tag moderador para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerAdd(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("ajudante")) {
				p2.sendMessage("§aVocê recebeu a tag ajudante de " + p.getName());
				p.sendMessage("§aVocê setou a tag ajudante para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerAdd(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("construtor")) {
				p2.sendMessage("§aVocê recebeu a tag construtor de " + p.getName());
				p.sendMessage("§aVocê setou a tag construtor para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerAdd(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("youtuber")) {
				p2.sendMessage("§aVocê recebeu a tag youtuber de " + p.getName());
				p.sendMessage("§aVocê setou a tag youtuber para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerAdd(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("galaxy")) {
				p2.sendMessage("§aVocê recebeu a tag galaxy de " + p.getName());
				p.sendMessage("§aVocê setou a tag galaxy para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerAdd(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("meteor")) {
				p2.sendMessage("§aVocê recebeu a tag meteor de " + p.getName());
				p.sendMessage("§aVocê setou a tag meteor para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerAdd(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("moon")) {
				p2.sendMessage("§aVocê recebeu a tag moon de " + p.getName());
				p.sendMessage("§aVocê setou a tag moon para " + p2.getName());
				Main.permission.playerRemove(p2, "membro.tag");
				Main.permission.playerAdd(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}
			if (p.hasPermission("admin.use") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("membro")) {
				p2.sendMessage("§aVocê recebeu a tag membro de " + p.getName());
				p.sendMessage("§aVocê setou a tag membro para " + p2.getName());
				Main.permission.playerAdd(p2, "membro.tag");
				Main.permission.playerRemove(p2, "moon.tag");
				Main.permission.playerRemove(p2, "meteor.tag");
				Main.permission.playerRemove(p2, "galaxy.tag");
				Main.permission.playerRemove(p2, "youtuber.tag");
				Main.permission.playerRemove(p2, "construtor.tag");
				Main.permission.playerRemove(p2, "ajudante.tag");
				Main.permission.playerRemove(p2, "moderador.tag");
				Main.permission.playerRemove(p2, "admin.tag");
				Main.permission.playerRemove(p2, "gerente.tag");
				Main.permission.playerRemove(p2, "master.tag");
				return true;

			}

		}

		return false;
	}

}
