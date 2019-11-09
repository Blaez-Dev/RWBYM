package io.github.blaezdev.rwbym.capabilities.Weiss;

import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.entity.EntityWinterArmorgeist;
import io.github.blaezdev.rwbym.entity.EntityWinterBeowolf;
import io.github.blaezdev.rwbym.entity.EntityWinterBoarbatusk;
import io.github.blaezdev.rwbym.entity.EntityWinterUrsa;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

public class Weiss implements IWeiss {
	
	
	// a level greater than 0 will signal that this is the active semblance
	
	private static final int MAX_LEVEL = 4;
	
	private int level = 0;
	
	private int cooldown = 0;
	
	private int[] cooldowns = {100, 300, 500, 1200};
	private int[] auraUses = {RWBYConfig.aura.weissboarbatusk, RWBYConfig.aura.weissbeowolf, RWBYConfig.aura.weissursa, RWBYConfig.aura.weissarmagigas};

	private int selectedLevel = 0;

	public boolean onActivate(EntityPlayer player) {
		IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
		if (!this.useAura(player, auraUses[selectedLevel - 1])) return false;
		if (this.cooldown > 0) {
			return false;
		}

		this.cooldown = cooldowns[selectedLevel-1];
		if (player.onGround && !player.world.isRemote){
			BlockPos blockpos = (new BlockPos(player));
			switch(this.selectedLevel) {
			case 1:
				EntityWinterBoarbatusk entityWinterBoarbatusk = new EntityWinterBoarbatusk(player.world);
				entityWinterBoarbatusk.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entityWinterBoarbatusk);
				return true;
			case 2:
				EntityWinterBeowolf entitybeowolf = new EntityWinterBeowolf(player.world);
				entitybeowolf.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entitybeowolf);
				return true;
			case 3:
				EntityWinterUrsa entityWinterUrsa = new EntityWinterUrsa(player.world);
				entityWinterUrsa.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entityWinterUrsa);
				return true;
			case 4:
				EntityWinterArmorgeist entityWinterArmorgeist = new EntityWinterArmorgeist(player.world);
				entityWinterArmorgeist.moveToBlockPosAndAngles(blockpos, 0.0F, 0.0F);
				player.world.spawnEntity(entityWinterArmorgeist);
				return true;
			default:
				return false;
			}
		}
		
		return false;
	}
	
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {

		if (this.cooldown > 0) {
			this.cooldown--;
		}
		
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("level", level);
		nbt.setInteger("cooldown", cooldown);
		nbt.setInteger("selectedLevel", selectedLevel);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.level = nbt.getInteger("level");
		this.cooldown = nbt.getInteger("cooldown");
		this.selectedLevel = nbt.getInteger("selectedLevel");
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public Capability getCapability() {
		return WeissProvider.WEISS_CAP;
	}
	
	@Override
	public String toString() {
		return "Weiss";
	}

	@Override
	public void setLevel(int level) {
		
		if (level > MAX_LEVEL) {
			return;
		}
		
		this.level = level;
		this.selectedLevel = level;
	}

	@Override
	public boolean isActive() {
		return false;
	}
	
	@Override
	public boolean isInvisible() {
		return false;
	}
	
	@Override
	public boolean isMovementBlocked() {
		return false;
	}
	
	@Override
	public int getSelectedLevel() {
		return selectedLevel ;
	}
	
	@Override
	public void setSelectedLevel(int level) {
		if (level <= this.level) {
			this.selectedLevel = level;
		}
	}

	@Override
	public float[] getColor() {
		float color[] = new float[3];
		color[0] = 1F;
		color[1] = 1F;
		color[2] = 1F;
		return color;
	}
}
