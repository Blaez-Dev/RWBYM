package io.github.blaezdev.rwbym.potion;

import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionAuraRegen extends Potion {

    public PotionAuraRegen(String name,Boolean isBadEffect,int colour) {
        super(isBadEffect, colour);
        setPotionName(name);
        this.setRegistryName(name);
    }

    private String name = "Aura Regen";

    private int statusIconIndex = 14;


    @Override
    public boolean isInstant() {
        return false;
    }


    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        if(entityLivingBaseIn instanceof EntityPlayer){
        IAura otheraura = entityLivingBaseIn.getCapability(AuraProvider.AURA_CAP, null);
        if (otheraura.getAmount() < otheraura.getMaxAura() && otheraura != null && otheraura.getDelay() < 45) {

            otheraura.addAmount(0.35F*amplifier);
        }}
    }

    @Override
    public boolean isReady(int duration, int amplifier)
    {
            int k = 50 >> amplifier;

            if (k > 0)
            {
                return duration % k == 0;
            }
            else
            {
                return true;
            }

    }

    /**
     * Set the potion name.
     */
    public Potion setPotionName(String nameIn)
    {
        this.name = nameIn;
        return this;
    }

    /**
     * returns the name of the potion
     */
    public String getName()
    {
        return this.name;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon()
    {
        return this.statusIconIndex >= 0;
    }

    /**
     * Returns the index for the icon to display when the potion is active.
     */
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex()
    {
        return this.statusIconIndex;
    }

}