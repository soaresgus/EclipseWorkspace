package me.ninjay.oneperfil.tags;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.lib.modules.VaultAPI;

public class TagCommanddesativado implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("cargo.admin")) {
				return true;
			}
			if (p.hasPermission("cargo.admin") && args.length == 0) {
				p.sendMessage(
						"§6§lCargos disponiveis:\n§6» Diretor\n§4» Gerente\n§c» Admin\n§9» Dev\n§2» Moderador\n§e» Ajudante\n§d» Builder\n§c» YT\n§4» Titan\n§5» Gladiador\n§3» Guerreiro\n§7» Membro\n ");
				return true;
			}
			String set = args[1];
			String tag = args[2];
			Player p2 = Bukkit.getPlayer(args[0]);
			if (p.hasPermission("cargo.admin") && p2 == null) {
				p.sendMessage("§cJogador offline.");
				return true;
			}
			if (p.hasPermission("cargo.admin") && args.length == 1) {
				p.sendMessage(
						"§6§lCargos disponiveis:\n§6» Diretor\n§4» Gerente\n§c» Admin\n§9» Dev\n§2» Moderador\n§e» Ajudante\n§d» Builder\n§c» YT\n§4» Titan\n§5» Gladiador\n§3» Guerreiro\n§7» Membro\n ");
				return true;
			}
			if (p.hasPermission("cargo.admin") && args.length == 2) {
				p.sendMessage(
						"§6§lCargos disponiveis:\n§6» Diretor\n§4» Gerente\n§c» Admin\n§9» Dev\n§2» Moderador\n§e» Ajudante\n§d» Builder\n§c» YT\n§4» Titan\n§5» Gladiador\n§3» Guerreiro\n§7» Membro\n ");
				return true;
			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("diretor")) {
				p2.sendMessage("§aVocê recebeu a tag diretor de " + p.getName());
				p.sendMessage("§aVocê setou a tag diretor para " + p2.getName());

				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerAdd(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("gerente")) {
				p2.sendMessage("§aVocê recebeu a tag gerente de " + p.getName());
				p.sendMessage("§aVocê setou a tag gerente para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerAdd(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("admin")) {
				p2.sendMessage("§aVocê recebeu a tag admin de " + p.getName());
				p.sendMessage("§aVocê setou a tag admin para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerAdd(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("moderador")) {
				p2.sendMessage("§aVocê recebeu a tag moderador de " + p.getName());
				p.sendMessage("§aVocê setou a tag moderador para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerAdd(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("ajudante")) {
				p2.sendMessage("§aVocê recebeu a tag ajudante de " + p.getName());
				p.sendMessage("§aVocê setou a tag ajudante para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerAdd(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("builder")) {
				p2.sendMessage("§aVocê recebeu a tag builder de " + p.getName());
				p.sendMessage("§aVocê setou a tag builder para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerAdd(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("yt")) {
				p2.sendMessage("§aVocê recebeu a tag yt de " + p.getName());
				p.sendMessage("§aVocê setou a tag yt para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerAdd(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("titan")) {
				p2.sendMessage("§aVocê recebeu a tag titan de " + p.getName());
				p.sendMessage("§aVocê setou a tag titan para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerAdd(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("gladiador")) {
				p2.sendMessage("§aVocê recebeu a tag gladiador de " + p.getName());
				p.sendMessage("§aVocê setou a tag gladiador para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerAdd(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("guerreiro")) {
				p2.sendMessage("§aVocê recebeu a tag guerreiro de " + p.getName());
				p.sendMessage("§aVocê setou a tag guerreiro para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerAdd(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "construtor.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("membro")) {
				p2.sendMessage("§aVocê recebeu a tag membro de " + p.getName());
				p.sendMessage("§aVocê setou a tag membro para " + p2.getName());
				VaultAPI.getPermission().playerAdd(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerRemove(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;
			}
			if (p.hasPermission("cargo.admin") && set.equalsIgnoreCase("setar") && tag.equalsIgnoreCase("dev")) {
				p2.sendMessage("§aVocê recebeu a tag dev de " + p.getName());
				p.sendMessage("§aVocê setou a tag dev para " + p2.getName());
				VaultAPI.getPermission().playerRemove(p2, "membro.tag");
				VaultAPI.getPermission().playerRemove(p2, "guerreiro.tag");
				VaultAPI.getPermission().playerRemove(p2, "gladiador.tag");
				VaultAPI.getPermission().playerRemove(p2, "titan.tag");
				VaultAPI.getPermission().playerRemove(p2, "youtuber.tag");
				VaultAPI.getPermission().playerRemove(p2, "builder.tag");
				VaultAPI.getPermission().playerRemove(p2, "ajudante.tag");
				VaultAPI.getPermission().playerRemove(p2, "moderador.tag");
				VaultAPI.getPermission().playerAdd(p2, "programador.tag");
				VaultAPI.getPermission().playerRemove(p2, "admin.tag");
				VaultAPI.getPermission().playerRemove(p2, "gerente.tag");
				VaultAPI.getPermission().playerRemove(p2, "diretor.tag");
				TagAPIdesativado.update();
				return true;

			}
		}
		return false;
	}
}
