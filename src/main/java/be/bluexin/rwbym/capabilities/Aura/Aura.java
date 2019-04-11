package be.bluexin.rwbym.capabilities.Aura;

import be.bluexin.rwbym.RWBYModels;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import scala.tools.nsc.interactive.Main;

public class Aura implements IAura {
	
	/**Current Aura amount*/
	private int amount = 0;
	
	/**Maximum Aura*/
	private static final int MAX = 100;
	
	/**Amount to recharge*/
	private int recharge = 1;
	
	/**How many ticks until recharge*/
	private int rate = 10;
	
	private int delay = 0;
	
	@Override
	public void onUpdate(EntityPlayer player) {
		if (!player.getFoodStats().needFood()) {
			if (delay == 0) {
				if (player.world.getTotalWorldTime() % rate == 0) {
					if (amount < MAX) {
						player.getFoodStats().addExhaustion(recharge);
						amount += recharge;
					}
				}
			}
			else {
				delay--;
			}
		}
		//RWBYModels.LOGGER.info("{}, {}", amount, delay);
	}
	
	@Override
	public int useAura(EntityPlayer player, int usage) {
		int temp = amount - usage;
		amount = Math.max(temp, 0);
		return temp < 0 ? -temp : 0;
	}
	
	@Override
	public void delayRecharge(int ticks) {
		this.delay = ticks;
	}
	
	@Override
	public NBTBase serialize() {
		RWBYModels.LOGGER.info("serialize");
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("amount", amount);
		nbt.setInteger("recharge", recharge);
		nbt.setInteger("rate", rate);
		return nbt;
	}

	@Override
	public void deserialize(NBTTagCompound nbt) {
		RWBYModels.LOGGER.info("deserialize");
		this.amount = nbt.getInteger("amount");
		this.recharge = nbt.getInteger("recharge");
		this.rate = nbt.getInteger("rate");
	}

}
