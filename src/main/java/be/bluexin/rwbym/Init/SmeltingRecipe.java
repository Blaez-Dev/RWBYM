package be.bluexin.rwbym.Init;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This class will allow one to use JSON smelting recipes very similar to 1.13's in previous versions.
 * To register it, place a file called _factories.json in your recipes folder containing the following json :
 * {
 *   "recipes": {
 *     "smelting": "<packagename>.SmeltingRecipe$SmeltingFactory"
 *   }
 * }
 * (simply replace <packagename> with your actual package name)
 * <p>
 * The actual SmeltingRecipe instance holds nothing (to lessen memory footprint) as furnace recipes are
 * stored separately on older versions.
 * <p>
 * Based on <a href="https://github.com/skylinerw/guides/blob/4767bc54cc113c4d258d5b74e62ce06f4c700f0e/java/recipes.md">this guide.</a>
 * 1.13 tags are not supported
 * 1.13 cookingtime is not supported
 *
 * Licensed under LGPL v3. Cba pasting full license disclaimer.
 *
 * @author Bluexin
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class SmeltingRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    public static final class SmeltingFactory implements IRecipeFactory {

        @Override
        public IRecipe parse(JsonContext context, JsonObject json) {
            NonNullList<ItemStack> ingredients = NonNullList.create();

            if (JsonUtils.isJsonArray(json, "ingredient"))
                for (JsonElement ele : JsonUtils.getJsonArray(json, "ingredient"))
                    ingredients.add(getIss(ele.getAsJsonObject()));
            else ingredients.add(getIss(JsonUtils.getJsonObject(json, "ingredient")));

            if (ingredients.isEmpty()) throw new JsonParseException("No ingredients for smelting recipe.");

            final ItemStack result;

            if (JsonUtils.isJsonPrimitive(json, "result"))
                result = new ItemStack(getItemChecked(JsonUtils.getString(json, "result")));
            else result = getIss(JsonUtils.getJsonObject(json, "result"));

            float experience = JsonUtils.getFloat(json, "experience", 0f);

            ingredients.forEach(iss -> GameRegistry.addSmelting(iss, result, experience));

            return new SmeltingRecipe();
        }
    }

    private static Item getItemChecked(String id) {
        Item item = Item.getByNameOrId(id);
        if (item == null)
            throw new JsonParseException("Item ID \"" + id + "\" was found invalid when parsing a smelting recipe.");
        return item;
    }

    private static ItemStack getIss(JsonObject json) {
        Item item = getItemChecked(JsonUtils.getString(json, "item"));
        int count = JsonUtils.getInt(json, "count", 1);
        return new ItemStack(item, count);
    }
}