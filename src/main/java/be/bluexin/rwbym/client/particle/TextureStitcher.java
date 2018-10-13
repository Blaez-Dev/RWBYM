package be.bluexin.rwbym.client.particle;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextureStitcher
{
    @SubscribeEvent
    public void stitcherEventPre(TextureStitchEvent.Pre event) {
        ResourceLocation rosepetalrl = new ResourceLocation("rwbym:entity/rosepetal");
        event.getMap().registerSprite(rosepetalrl);
    }
}
