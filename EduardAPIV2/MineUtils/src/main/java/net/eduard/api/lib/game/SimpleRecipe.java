package net.eduard.api.lib.game;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.ArrayList;
import java.util.List;

/**
 * API de criação de Craft solto não importanto os Slots
 * <br>
 * Esta classe possuiu ao longo do tempo varios nomes e estava em packages diferentes
 * <br>
 * Isso não mudou em nada dentro dela então a versão dela ainda é 1.0
 * Nomes Antigos em ordem crescente:
 * <br>
 *    <ol>
 *        <li>
 *            net.eduard.craft.CraftSetup1
 *        </li>
 *        <li>
 *            net.eduard_api.game.craft.Crafts
 *        </li>
 * <li>
 * net.eduard.eduard_api.game.craft.simples.Craft
 * </li>
 * <li>
 * net.eduard.eduard_api.game.craft.CraftSimples
 * </li>
 * <li>
 * net.eduard.api.gui.SimpleCraft
 * </li>
 * <li>
 * net.eduard.api.setup.Mine$SimpleCraft
 * </li>
 *    </ol>

 *
 * @author Eduard
 * @version 1.0
 * @since EduardAPI v0.1
 */
@SuppressWarnings("unused")
public class SimpleRecipe {
    public boolean addRecipe() {
        if (getResult() == null)
            return false;
        return Bukkit.addRecipe(getRecipe());
    }

    private ItemStack result = null;
    private final List<ItemStack> items = new ArrayList<>();

    public SimpleRecipe() {

    }

    public SimpleRecipe(ItemStack result) {
        setResult(result);
    }

    public SimpleRecipe add(Material material) {
        return add(new ItemStack(material));
    }

    public SimpleRecipe add(Material material, int data) {
        return add(new ItemStack(material, 1, (short) data));
    }

    public SimpleRecipe add(ItemStack item) {
        items.add(item);
        return this;
    }

    public SimpleRecipe remove(ItemStack item) {
        items.remove(item);
        return this;
    }


    public ShapelessRecipe getRecipe() {
        if (result == null)
            return null;
        ShapelessRecipe recipe = new ShapelessRecipe(result);
        for (ItemStack item : items) {
            recipe.addIngredient(item.getData());
        }
        return recipe;
    }


    public ItemStack getResult() {

        return result;
    }

    public void setResult(ItemStack result) {
        this.result = result;
    }

}
