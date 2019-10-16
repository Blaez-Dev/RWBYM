package io.github.blaezdev.rwbym.utility;

import io.github.blaezdev.rwbym.Init.RWBYFluids;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.blocks.fluids.BlockFluidGrimm;
import io.github.blaezdev.rwbym.weaponry.RWBYItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

public class FluidRenderHandler {

    public  static void registerCustomMeshesAndStates(){
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(RWBYItems.fluidGrimm), new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation("rwbym:fluidgrimm", "fluid");
            }
        });
        ModelLoader.setCustomStateMapper(RWBYItems.fluidGrimm, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation("rwbym:fluidgrimm", "fluid");
            }
        });

    }
}
