package be.bluexin.rwbym.capabilities.ruby;

import net.minecraft.entity.player.EntityPlayer;

public interface IRuby {
	
	public boolean activate(EntityPlayer player);
		
	public void setInvisisbility(int time);

	public void setInvisisbilityTimer(int time);
	
	public void setCooldownTimer(int time);
	
	public void setActiveStatus(boolean status);
	
	public void setPlayerY(double Y);
	
	public void updateInvisisbility(EntityPlayer player);
	
	public int getInvisibilityTimer();
	
	public int getCooldown();
	
	public boolean getInvisibility();
	
	public boolean getActiveStatus();
	
	public double getPlayerY();
}
