package io.github.blaezdev.rwbym.capabilities.Predator;

import io.github.blaezdev.rwbym.utility.network.MessageSyncPredatorCap;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.ArmourBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.lwjgl.Sys;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Predator implements IPredator
{
	private int kills = 0;

	public Predator() {}

	@Override
	public int getKills()
	{
		return kills;
	}

	@Override
	public void setKills(@Nullable EntityPlayer player, int amount)
	{
		kills = amount;
		if (player instanceof EntityPlayerMP)
			syncPredatorCapWithClient((EntityPlayerMP) player);
	}

	@Override
	public void increaseKills(@Nullable EntityPlayer player)
	{
		increaseKills(player, 1);
	}

	@Override
	public void increaseKills(@Nullable EntityPlayer player, int amount)
	{
		setKills(player, getKills() + amount);
	}

	@Override
	public float getBonusDamageMultiplier()
	{
		float multiplierPerKill = 6.0F / 20000;
		//System.out.println(getKills());
		return 1.0F + multiplierPerKill * getKills();
	}

	@SubscribeEvent
	public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (event.player instanceof EntityPlayerMP && !event.player.world.isRemote)
			syncPredatorCapWithClient((EntityPlayerMP) event.player);
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event)
	{
		if (event.player instanceof EntityPlayerMP && !event.player.world.isRemote)
			syncPredatorCapWithClient((EntityPlayerMP) event.player);
	}

	@SubscribeEvent
	public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event)
	{
		if (event.player instanceof EntityPlayerMP && !event.player.world.isRemote)
			syncPredatorCapWithClient((EntityPlayerMP) event.player);
	}

	@SubscribeEvent
	public static void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
	{
		IPredator oldCap = Predator.getCap(event.getOriginal());
		IPredator newCap = Predator.getCap(event.getEntityPlayer());
		if (newCap != null && oldCap != null)
			newCap.setKills(event.getEntityPlayer(), oldCap.getKills());
	}

	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event)
	{
		EntityLivingBase entity = event.getEntityLiving();
		Entity attacker = event.getSource().getTrueSource();
		//System.out.println(attacker);
		//System.out.println(entity);
		if (attacker instanceof EntityPlayer && entity instanceof IPrey)
		{
			IPrey prey = (IPrey) entity;
			EntityPlayer predator = (EntityPlayer) attacker;
			//System.out.println(ArmourBase.validperk(predator, ArmourBase.Predator));
			//System.out.println(prey.canBeHunted());
			if (ArmourBase.validperk(predator, ArmourBase.Predator) && prey.canBeHunted())
			{
				IPredator cap = getCap(predator);
				if (cap != null)
				{
					prey.onHunted(predator);
					cap.increaseKills(predator, prey.getKillsFeed());
					//System.out.println(cap.getKills());
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingAttack(LivingHurtEvent event)
	{
		Entity attacker = event.getSource().getTrueSource();
		if (attacker instanceof EntityPlayer)
		{
			EntityPlayer predator = (EntityPlayer) attacker;
			if (ArmourBase.validperk(predator, ArmourBase.Predator))
			{
				IPredator cap = getCap(predator);
				//System.out.println(getCap(predator).getKills());
				//System.out.println("damage amount"+event.getAmount());
				//System.out.println("damage modifier"+cap.getBonusDamageMultiplier());

				if (cap != null) event.setAmount(event.getAmount() * cap.getBonusDamageMultiplier());
				//System.out.println("final damage"+event.getAmount());
			}
		}
	}

	@Nullable
	public static IPredator getCap(EntityPlayer player)
	{
		return player.getCapability(PredatorProvider.CAPABILITY, null);
	}

	public static void syncPredatorCapWithClient(EntityPlayerMP player)
	{
		IPredator cap = getCap(player);
		if (cap != null)
			RWBYNetworkHandler.sendToClient(new MessageSyncPredatorCap(cap.getKills()), player);
	}

	public static class PradatorStorage implements Capability.IStorage<IPredator>
	{
		@Override
		public NBTBase writeNBT(Capability<IPredator> capability, IPredator instance, EnumFacing side)
		{
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger("kills", instance.getKills());
			return compound;
		}

		@Override
		public void readNBT(Capability<IPredator> capability, IPredator instance, EnumFacing side, NBTBase nbt)
		{
			if (nbt instanceof NBTTagCompound)
				instance.setKills(null, ((NBTTagCompound) nbt).getInteger("kills"));
		}
	}

	public static class PredatorProvider implements ICapabilitySerializable<NBTTagCompound>
	{
		@CapabilityInject(IPredator.class)
		public static final Capability<IPredator> CAPABILITY = null;

		private final IPredator instance = new Predator();

		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing)
		{
			return capability == CAPABILITY;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing)
		{
			return capability == CAPABILITY ? CAPABILITY.cast(instance) : null;
		}

		@Override
		public NBTTagCompound serializeNBT()
		{
			return (NBTTagCompound) CAPABILITY.getStorage().writeNBT(CAPABILITY, instance, null);
		}

		@Override
		public void deserializeNBT(NBTTagCompound nbt)
		{
			CAPABILITY.getStorage().readNBT(CAPABILITY, instance, null, nbt);
		}
	}

	public interface IPrey
	{
		/**
		 * Upon killed by a predator
		 * @param predator the killer
		 */
		default void onHunted(EntityPlayer predator)
		{

		}

		/**
		 * Whether this entity/prey can trigger "hunt"
		 */
		default boolean canBeHunted()
		{
			return true;
		}

		/**
		 * Gets the kills for player's state
		 * @return the amount of kills provided by hunting down this entity
		 */
		default int getKillsFeed()
		{
			return 1;
		}
	}
}
