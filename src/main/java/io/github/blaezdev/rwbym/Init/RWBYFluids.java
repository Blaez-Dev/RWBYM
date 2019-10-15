package io.github.blaezdev.rwbym.Init;

import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class RWBYFluids {
	
	public static final Fluid GRIMM = new Fluid("grimm", new ResourceLocation(RWBYModels.MODID, "grimm/still"), new ResourceLocation(RWBYModels.MODID, "grimm/flowing"));
	
	public static void register() {
		FluidRegistry.registerFluid(GRIMM);
	}

}
