package io.github.blaezdev.rwbym.Init;

import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class RWBYFluids {
	
	public static final Fluid GRIMM = new Fluid("grimm", new ResourceLocation( "rwbym:blocks/fluidgrimm_still"), new ResourceLocation( "rwbym:blocks/fluidgrimm_flow"));
	
	public static void register() {
		FluidRegistry.registerFluid(GRIMM);
	}

}
