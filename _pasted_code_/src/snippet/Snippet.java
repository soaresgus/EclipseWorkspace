package snippet;

public class Snippet {
	public static void main(String[] args) {
		
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eTodos os mundos")) {
								Inventory menu = Mine.newInventory("Todos os mundos", 9*5);
								ItemStack globaldes = Mine.newHead("§eDesativar global", "Aa", 1);
								ItemStack globalativ = Mine.newHead("§eAtivar global", "Lime", 1);
								ItemStack cleardropsdes = Mine.newHead("§eDesativar limpar drops", "Aa", 1);
								ItemStack cleardropsativ = Mine.newHead("§eAtivar limpar drops", "Lime", 1);
								ItemStack mobsdes = Mine.newHead("§eDesativar spawn de mobs", "Aa", 1);
								ItemStack mobsativ = Mine.newHead("§eAtivar spawn de mobs", "Lime", 1);
								ItemStack limparmobs = Mine.newHead("§eLimpar mobs", "Spe", 1);
								ItemStack redstonedes = Mine.newHead("§eDesativar redstone", "Aa", 1);
								ItemStack redstoneativ = Mine.newHead("§eAtivar redstone", "Lime", 1);
								ItemStack explodes = Mine.newHead("§eDesativar explosão", "Aa", 1);
								ItemStack exploativ = Mine.newHead("§eAtivar explosão", "Lime", 1);
								ItemStack carregar = Mine.newHead("§eCarregar mundo", "Earth", 1);
								ItemStack limpardrops = Mine.newHead("§eLimpar drops", "Spe", 1);
								
							if(Main.config.getBoolean("todos.global") == false) {
								menu.setItem(Mine.getPosition(2, 3), globalativ);
							}else {
								menu.setItem(Mine.getPosition(2, 3), globaldes);
							}
							if(Main.config.getBoolean("todos.cleardrops") == false) {
								menu.setItem(Mine.getPosition(2, 4), cleardropsativ);
							}else {
								menu.setItem(Mine.getPosition(2, 4), cleardropsdes);
							}
							if(Main.config.getBoolean("todos.mobs") == false) {
								menu.setItem(Mine.getPosition(2, 5), mobsativ);
							}else {
								menu.setItem(Mine.getPosition(2, 5), mobsdes);
							}
							if(Main.config.getBoolean("todos.redstone") == false) {
								menu.setItem(Mine.getPosition(2, 6), redstoneativ);
							}else {
								menu.setItem(Mine.getPosition(2, 6), redstonedes);
							}
							if(Main.config.getBoolean("todos.explosao") == false) {
								menu.setItem(Mine.getPosition(2, 7), exploativ);
							}else {
								menu.setItem(Mine.getPosition(2, 7), explodes);
							}
							
							menu.setItem(Mine.getPosition(4, 3), limpardrops);
							menu.setItem(Mine.getPosition(4, 5), limparmobs);
							menu.setItem(Mine.getPosition(4, 7), carregar);
							
							p.openInventory(menu);
							}
		
	}
}

