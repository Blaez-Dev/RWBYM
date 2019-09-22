package be.bluexin.rwbym.capabilities.Ruby;

import be.bluexin.rwbym.capabilities.ISemblance;

public interface IRuby extends ISemblance{
			
	public void setInvisisbility(int time);

	public void setInvisisbilityTimer(int time);
	
	public void setCooldownTimer(int time);
		
	public void setPlayerY(double Y);
		
	public int getInvisibilityTimer();
	
	public int getCooldown();
	
	public boolean getInvisibility();
	
	public boolean getActiveStatus();
	
	public double getPlayerY();

	public int getLevel();
	
	public void setLevel(int level);
}
