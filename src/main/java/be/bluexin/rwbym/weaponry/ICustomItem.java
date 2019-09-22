package be.bluexin.rwbym.weaponry;

import be.bluexin.rwbym.RWBYModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

/**
 * Part of rwbym
 * <p>
 * When implementing this interface, your class should extend {@link Item} or crashes will happen.
 *
 * @author Bluexin
 */
public interface ICustomItem {
    String KEY = new ResourceLocation(RWBYModels.MODID, "statsSet").toString();

    @SideOnly(Side.CLIENT)
    default void registerModel() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register((Item) this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    default void register() {
        LogManager.getLogger(RWBYModels.MODID).debug("Registering " + this);
        ForgeRegistries.ITEMS.register((Item) this);
    }


    //void registerRecipes();

    ResourceLocation getRegistryName();
}
