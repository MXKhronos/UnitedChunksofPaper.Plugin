package mx.plugin.unitedchunksofpaper;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CustomRecipesLibrary {
    public static void LoadRecipes() {
        {
            ItemStack item = new ItemStack(Material.SADDLE);
            NamespacedKey itemKey = new NamespacedKey(UCPMain.plugin, "saddle_key");
            ShapedRecipe itemRecipe = new ShapedRecipe(itemKey, item);
            itemRecipe.shape("ill", "lil");
            itemRecipe.setIngredient('l', Material.LEATHER);
            itemRecipe.setIngredient('i', Material.IRON_INGOT);

            UCPMain.plugin.getServer().addRecipe(itemRecipe);
        }

        UCPMain.logger.info("Loaded custom receipes.");
    }
}
