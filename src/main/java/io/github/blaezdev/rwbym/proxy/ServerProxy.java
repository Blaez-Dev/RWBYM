package io.github.blaezdev.rwbym.proxy;

import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy extends CommonProxy {

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }

    @Override
    public void showGuiScreen(Object clientGuiElement) {

    }

}
