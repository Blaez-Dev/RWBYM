package io.github.blaezdev.rwbym.capabilities.Clover;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Clover implements IClover {

	interface ListFactory<T> { List<T> createList(); }

	private boolean active = false;

	private int Timer = 0;

	private static final int MAX_LEVEL = 3;
	
	private int level = 0;

	private float auraUse = 0;

	private int cooldown;


	private int selectedLevel = -1;

	@Override
	public boolean onActivate(EntityPlayer player) {
		switch(this.level) {
			case 1:
			case 2:
			case 3:
				return false;
			default:
				return false;
		}
	}


	@Override
	public boolean deActivate(EntityPlayer player) {
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		PotionEffect potioneffect = new PotionEffect(MobEffects.LUCK, 2147000000, 8*level, false, false);
		player.addPotionEffect(potioneffect);
		--cooldown;
		if(!player.world.isRemote){
		Random rand = player.getRNG();
		if (cooldown <= 0) {
			AxisAlignedBB axisalignedbb2 = player.getEntityBoundingBox().grow(20,20,20);
			List<EntityPlayer> list2 = player.world.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb2);
			if(list2.contains(player)){list2.remove(player);}
			if (!list2.isEmpty()) {
				EntityPlayer victim = list2.get(player.world.rand.nextInt(list2.size()));
				int nextRandom = rand.nextInt(this.potioneffectlist.length);
				Set<Integer> validate = new HashSet<>();
				validate.add(nextRandom);
				for (int i = 0; i < 1; i++) {
					while(validate.contains(nextRandom)) {
						nextRandom = rand.nextInt(this.potioneffectlist.length);
					}
					validate.add(nextRandom);
				}
				for (int i : validate) {
					victim.addPotionEffect(this.potioneffectlist[i]);
				}
				cooldown = player.world.rand.nextInt(2400) + 1200;
			}
		}
	}}

	private static PotionEffect[] potioneffectlist = new PotionEffect[]{
			new PotionEffect(MobEffects.NIGHT_VISION, 600, 1, true, false),
			new PotionEffect(MobEffects.HASTE, 600, 1, true, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 600, 1, true, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 600, 1, true, false),
			new PotionEffect(MobEffects.WATER_BREATHING, 600, 1, true, false),
			new PotionEffect(MobEffects.ABSORPTION, 600, 1, true, false),
			new PotionEffect(MobEffects.HEALTH_BOOST, 600, 1, true, false),
			new PotionEffect(MobEffects.STRENGTH, 600, 1, true, false),
			new PotionEffect(MobEffects.REGENERATION, 600, 1, true, false),
			new PotionEffect(MobEffects.SPEED, 600, 1, true, false),
			new PotionEffect(MobEffects.RESISTANCE, 600, 1, true, false)
	};


	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("timer", Timer);
		nbt.setInteger("level", level);
		nbt.setBoolean("active", active);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.Timer = nbt.getInteger("timer");
		this.level = nbt.getInteger("level");
		this.active = nbt.getBoolean("active");
	}

	@Override
	public int getLevel() {
		return this.level ;
	}

	@Override
	public void setLevel(int level) {
		
		if (level > MAX_LEVEL) {
			return;
		}
		
		this.level = level;
	}

	@Override
	public Capability getCapability() {
		return CloverProvider.Clover_CAP;
	}

	@Override
	public boolean isActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "Clover";
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
		color[0] = 0.33F;
		color[1] = 1F;
		color[2] = 0.0F;
		return color;
	}

}
