package be.bluexin.rwbym.client.particle;

import be.bluexin.rwbym.utility.RegUtil;
import be.bluexin.rwbym.weaponry.ArmourBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderEvents {
    public RenderEvents() {
    }

    public static void init() {
    }

    @SubscribeEvent
    public void renderPlayerPostEvent(net.minecraftforge.client.event.RenderPlayerEvent.Post e) {
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (e.getEntityPlayer() != null && e.getRenderer().getMainModel() instanceof ModelPlayer) {
            ModelPlayer model = e.getRenderer().getMainModel();
            Item legs = RegUtil.getLegSlot(player);
            Item body = RegUtil.getBodySlot(player);
            if (body instanceof ArmourBase) {
                model.bipedLeftArmwear.isHidden = model.bipedRightArmwear.isHidden = model.bipedBodyWear.isHidden = true;
            } else {
                model.bipedLeftArmwear.isHidden = model.bipedRightArmwear.isHidden = model.bipedBodyWear.isHidden = false;
            }

            if (legs instanceof ArmourBase) {
                model.bipedLeftLegwear.isHidden = model.bipedRightLegwear.isHidden = true;
            } else {
                model.bipedLeftLegwear.isHidden = model.bipedRightLegwear.isHidden = false;
            }
        }

    }

}