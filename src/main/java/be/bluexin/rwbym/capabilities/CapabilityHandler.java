package be.bluexin.rwbym.capabilities;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.ruby.RubyProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	public static final ResourceLocation RUBY_CAP = new ResourceLocation(RWBYModels.MODID, "ruby");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent event) {
		event.addCapability(RUBY_CAP, new RubyProvider());
	}
}
