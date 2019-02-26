package be.bluexin.rwbym.entity.utility;


import be.bluexin.rwbym.weaponry.RWBYSword;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.swing.text.html.parser.Entity;

public class HideUtil {


    @SubscribeEvent
    public void pre(RenderPlayerEvent.Pre event)
    {
        if (RWBYSword.runhideevent){
        event.setCanceled(true);}
    }
}