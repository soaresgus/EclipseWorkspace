package net.eduard.api.lib.menu

import net.eduard.api.lib.game.ItemBuilder
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

open class MenuButton(
    var name: String = "Botao",
    @Transient
    var parentMenu: Menu? = null,
    positionX: Int = 0,
    positionY: Int = 1,
    var page: Int = 1

) : Slot(positionX, positionY) {


    var menu: Menu? = null

    var fixed = false

    init {
        parentMenu?.addButton(this)
    }

    fun subMenu(title: String, lineAmount: Int, setup: Menu.() -> Unit) {
        this.menu = Menu(title, lineAmount)
        setup(this.menu!!)
    }

    fun subShop(title: String, lineAmount: Int, setup: Shop.() -> Unit) {
        this.menu = Shop(title, lineAmount)
        setup(this.shop)
    }


    val shop: Shop
        get() = menu as Shop

    @Transient
    var click: ClickEffect? = null


    @Transient
    var iconPerPlayer: (Player.() -> ItemStack)? = null

    open fun getIcon(player: Player): ItemStack {
        return iconPerPlayer?.invoke(player) ?: icon
    }

    var icon: ItemStack
        get() = item ?: ItemBuilder(Material.BARRIER)
            .name("§cItem nulo")
        set(itemParameter) {
            item = itemParameter
        }



    val isCategory: Boolean
        get() = menu != null

}