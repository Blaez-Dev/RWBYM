package be.bluexin.rwbym.capabilities.Aura;

import be.bluexin.rwbym.RWBYModels;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import scala.tools.nsc.interactive.Main;

public class Aura implements IAura {
	
	/**Current Aura amount*/
	private float amount = 0;
	
	/**Maximum Aura*/
	private float max = 100;
	
	/**Amount to recharge*/
	private float recharge = 1;
	
	/**How many ticks until recharge*/
	private int rate = 10;
	
	private int delay = 0;

	@Override
	public void onUpdate(EntityPlayer player) {
		if (player.getFoodStats().getFoodLevel() > 6) {
			if (delay == 0) {
				if (player.world.getTotalWorldTime() % rate == 0) {
					if (amount < max) {
						if (player.getFoodStats().getFoodLevel() > 19) {
							player.getFoodStats().addExhaustion(recharge);
							amount += recharge;
						} else {
							player.getFoodStats().addExhaustion(recharge / 4);
							amount += (recharge / 4);
						}
					}
				}
			}
		}
		if (delay > 0) {
			delay--;
		}
	}
	
	@Override
	public float useAura(EntityPlayer player, float usage) {
		float temp = amount - usage;
		amount = Math.max(temp, 0);
		return temp < 0 ? -temp : 0;
	}
	
	@Override
	public void delayRecharge(int ticks) {
		this.delay = ticks;
	}
	
	@Override
	public float getPercentage() {
		return amount / (float) max;
	}
	
	@Override
	public NBTBase serialize() {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setFloat("amount", amount);
		nbt.setFloat("recharge", recharge);
		nbt.setInteger("rate", rate);
		return nbt;
	}

	@Override
	public void deserialize(NBTTagCompound nbt) {
		this.amount = nbt.getFloat("amount");
		this.recharge = nbt.getFloat("recharge");
		this.rate = nbt.getInteger("rate");
	}

}
