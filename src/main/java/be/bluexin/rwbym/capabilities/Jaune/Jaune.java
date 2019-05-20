package be.bluexin.rwbym.capabilities.Jaune;

import java.util.List;
import java.util.UUID;

import be.bluexin.rwbym.capabilities.Aura.AuraProvider;
import be.bluexin.rwbym.capabilities.Aura.IAura;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;

public class Jaune implements IJaune {
	
	private int level;
	
	private static final int MAX = 3;
	
	private float auraModifier = 2F;
	
	private String[] playerUUIDs = new String[5];
	
	private float transferRate = 1F;

	@Override
	public boolean onActivate(EntityPlayer player) {
		AxisAlignedBB aabb = player.getEntityBoundingBox().grow(5);
		List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(player, aabb);
		int i = 0;
		for (Entity entity : list) {
			if (entity instanceof EntityPlayer && i < 5) {
				EntityPlayer otherPlayer = (EntityPlayer) entity;
				playerUUIDs[i] = otherPlayer.getCachedUniqueIdString();
				i++;
			}
		}
		return i > 0;
	}

	@Override
	public boolean deActivate(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onUpdate(EntityPlayer player) {
		
		for (int i = 0; i < 5; i++) {
			
			String uuid = playerUUIDs[i];
			
			if (uuid == null || uuid.isEmpty()) {
				continue;
			}
			
			EntityPlayer otherPlayer = player.world.getPlayerEntityByUUID(UUID.fromString(uuid));
			
			if (otherPlayer == null) {
				continue;
			}
			
			IAura thisaura = player.getCapability(AuraProvider.AURA_CAP, null);
			IAura otheraura = otherPlayer.getCapability(AuraProvider.AURA_CAP, null);
			
			if (thisaura == null) {
				return;
			}
			if (otheraura == null) {
				continue;
			}
			
			if (otheraura.getAmount() < otheraura.getMaxAura() && thisaura.getAmount() > transferRate) {
			
				thisaura.addAmount(-transferRate);
				otheraura.addAmount(transferRate);
			
			}
			else {
				playerUUIDs[i] = "";
			}
			
		}
		
	}
	
	@Override
	public float getAuraModifier() {
		return this.auraModifier;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("level", level);
		nbt.setFloat("auraModifier", auraModifier);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.level = nbt.getInteger("level");
		this.auraModifier = nbt.getFloat("auraModifier");
	}

	@Override
	public float[] getColor() {
		return new float[] {0.5F, 0.5F, 0.5F};
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public void setLevel(int level) {
		if (level <= this.MAX) {
			this.level = level;
		}
	}

	@Override
	public Capability getCapability() {
		return JauneProvider.JAUNE_CAP;
	}

	@Override
	public boolean isActive() {
		for (String uuid : playerUUIDs) {
			if (uuid != null && !uuid.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isInvisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMovementBlocked() {
		return this.isActive();
	}

	@Override
	public int getSelectedLevel() {
		return -1;
	}

	@Override
	public void setSelectedLevel(int level) {}
	
	@Override
	public String toString() {
		return "Jaune";
	}

}
