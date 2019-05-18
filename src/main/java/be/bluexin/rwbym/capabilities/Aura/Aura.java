package be.bluexin.rwbym.capabilities.Aura;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.capabilities.CapabilityHandler;
import be.bluexin.rwbym.utility.network.MessageSendPlayerData;
import be.bluexin.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import scala.tools.nsc.interactive.Main;

public class Aura implements IAura {
	
	/**Current Aura amount*/
	private float amount = 0;
	
	/**Maximum Aura*/
	private int max = 100;
	
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
						if (player.getFoodStats().getFoodLevel() > 16) {
							player.getFoodStats().addExhaustion(recharge);
							amount += recharge;
						} else {
							amount += (recharge / 4);
						}
						if (!player.world.isRemote) {
							RWBYNetworkHandler.sendToAll(new MessageSendPlayerData(CapabilityHandler.getCurrentSemblance(player), this, player.getName()));
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
	public float useAura(EntityPlayer player, float usage, boolean overflow) {
		float temp = amount - usage;
		if (temp >= 0 || overflow) {
			amount = Math.max(temp, 0);
		}
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
	public void addToMax(int amount) {
		this.max += amount;
	}
	
	@Override
	public int getEXPToLevel() {
		int lvl = max - 100;
		return (int)(40 + 4 * lvl + 0.1 * lvl * lvl + Math.pow(1.07, lvl));
	}
	
	@Override
	public int getMaxAura() {
		return max;
	}
	
	@Override
	public void setMaxAura(int amount) {
		this.max = amount;
	}
	
	@Override
	public float getAmount() {
		return amount;
	}
	
	@Override
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public void addAmount(float amount) {
		this.amount += amount;
	}
	
	@Override
	public NBTBase serialize() {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setFloat("amount", amount);
		nbt.setFloat("recharge", recharge);
		nbt.setInteger("rate", rate);
		nbt.setInteger("max", max);
		return nbt;
	}

	@Override
	public void deserialize(NBTTagCompound nbt) {
		this.amount = nbt.getFloat("amount");
		this.recharge = nbt.getFloat("recharge");
		this.rate = nbt.getInteger("rate");
		this.max = nbt.getInteger("max");
	}

}
