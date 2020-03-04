package io.github.blaezdev.rwbym.capabilities.Aura;

import io.github.blaezdev.rwbym.RWBYModels;
import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.capabilities.ISemblance;
import io.github.blaezdev.rwbym.capabilities.Jaune.IJaune;
import io.github.blaezdev.rwbym.utility.network.MessageSendPlayerData;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;


public class Aura implements IAura {
	
	/**Current Aura amount*/
	private float amount = 0;
	
	private float modifier = 1;
	
	/**Maximum Aura*/
	private float max = 100;
	
	/**Amount to recharge*/
	private float recharge = 1;
	
	/**How many ticks until recharge*/
	private int rate = 10;
	
	private int delay = 0;

	@Override
	public void onUpdate(EntityPlayer player) {
		
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
		
		modifier = this.getModifier(player);
				
		if (player.getFoodStats().getFoodLevel() > 6) {
			if (delay == 0) {
				if (player.world.getTotalWorldTime() % rate == 0) {
					if (amount < max) {
						if (player.getFoodStats().getFoodLevel() > 16) {
							player.getFoodStats().addExhaustion(recharge);
							this.addAmount(recharge);
						} else {
							this.addAmount(recharge / 4);
						}
						if (!player.world.isRemote) {
							RWBYNetworkHandler.sendToAll(new MessageSendPlayerData(CapabilityHandler.getCurrentSemblance(player), this, player.getEntityData().getCompoundTag(RWBYModels.MODID), player.getName()));
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
		float temp = this.getAmount() - usage;
		if (temp >= 0 || overflow) {
			this.setAmount(Math.max(temp, 0));
		}
		return temp < 0 ? -temp : 0;
	}
	
	@Override
	public void delayRecharge(int ticks) {
		this.delay = ticks;
	}

	@Override
	public int getDelay(){return delay;}
	
	@Override
	public float getModifier(EntityPlayer player) {
		ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
		
		float modifier = 1;
		
		if (semblance instanceof IJaune) {
			modifier = ((IJaune)semblance).getAuraModifier();
		}
		
		return modifier;
	}
	
	@Override
	public float getPercentage() {
		return amount / max;
	}
	
	@Override
	public void addToMax(int amount) {
		this.max += amount / modifier;
	}
	
	@Override
	public int getEXPToLevel() {
		int lvl = (int) (max - 100);
		return (int)(40 + 4 * lvl + 0.1 * lvl * lvl + Math.pow(1.005, lvl));
	}
	
	@Override
	public float getMaxAura() {
		return max * modifier;
	}
	
	@Override
	public void setMaxAura(int amount) {
		this.max = amount / modifier;
	}
	
	@Override
	public float getAmount() {
		return amount * modifier;
	}
	
	@Override
	public void setAmount(float amount) {
		this.amount = amount / modifier;
	}
	
	@Override
	public void addAmount(float amount) {
		this.amount += amount / modifier;
	}
	
	@Override
	public NBTBase serialize() {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setFloat("amount", amount);
		nbt.setFloat("recharge", recharge);
		nbt.setInteger("rate", rate);
		nbt.setFloat("max", max);
		nbt.setFloat("modifier", modifier);
		return nbt;
	}

	@Override
	public void deserialize(NBTTagCompound nbt) {
		this.amount = nbt.getFloat("amount");
		this.recharge = nbt.getFloat("recharge");
		this.rate = nbt.getInteger("rate");
		this.max = nbt.getFloat("max");
		this.modifier = nbt.getFloat("modifier");
	}

}
