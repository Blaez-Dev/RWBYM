package be.bluexin.rwbym.blocks.tileentities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.entity.EntityApathy;
import be.bluexin.rwbym.entity.EntityBeowolf;
import be.bluexin.rwbym.entity.EntityBoarbatusk;
import be.bluexin.rwbym.entity.EntityCreep;
import be.bluexin.rwbym.entity.EntityDeathStalker;
import be.bluexin.rwbym.entity.EntityGeist;
import be.bluexin.rwbym.entity.EntityGiantNeverMore;
import be.bluexin.rwbym.entity.EntityGoliath;
import be.bluexin.rwbym.entity.EntityJuvenileDeathstalker;
import be.bluexin.rwbym.entity.EntityLancer;
import be.bluexin.rwbym.entity.EntityMutantDeathStalker;
import be.bluexin.rwbym.entity.EntityNeverMore;
import be.bluexin.rwbym.entity.EntityNuckleeve;
import be.bluexin.rwbym.entity.EntityQueenLancer;
import be.bluexin.rwbym.entity.EntityUrsa;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class TileEntityRWBYGrimmBait extends TileEntity implements ITickable {

	private static final int BOSS_FREQUENCY = 3;
	private static final int SPAWN_RADIUS = 10;
	
    private Random rand = new Random();
    private int wavecount;
    private List<EntityLiving> wavelist = new ArrayList<EntityLiving>();
    private EntityPlayer player;
    
    public TileEntityRWBYGrimmBait() {
		// TODO Auto-generated constructor stub
	}

    public void activate(EntityPlayer player) {
    	if (!this.isActive()) {
	    	this.player = player;
    	}
    }
    
    public void stop() {
    	this.world.setBlockToAir(this.getPos());
    	this.wavecount = 0;
    	this.wavelist.clear();
    	this.player = null;
    }
    
    public boolean isActive() {
    	return wavecount > 0;
    }
    
	@Override
	public void update() {
		if (!this.world.isRemote) {
			if (player == null) {
				this.wavecount = 0;
				this.wavelist.clear();
				return;
			}
			
			if (!player.isEntityAlive() || wavecount > 17) {
				this.stop();
				return;
			}
			
			if (wavelist.isEmpty() || this.getAlivePercent() < 0.4) {
				wavecount++;
				wavelist.clear();
				wavelist = this.getEntityList();
			}
		}
	}
	
	private int getEntityCount() {
		return wavecount % BOSS_FREQUENCY == 0 ? (wavecount - 1) / (BOSS_FREQUENCY * 6) + 1 : 10;
	}
	
	private int getEntityType() {
		return wavecount % BOSS_FREQUENCY == 0 ? (wavecount / BOSS_FREQUENCY > 6 ? (6 + 9) : wavecount / BOSS_FREQUENCY + 9) : (wavecount - wavecount / BOSS_FREQUENCY > 9 ? 9 : wavecount - wavecount / BOSS_FREQUENCY);
	}
	
	private List<EntityLiving> getEntityList() {
		int entitycount = this.getEntityCount();
		int entitytype = this.getEntityType();
		List<EntityLiving> entities = new ArrayList<EntityLiving>();
		for (int i = 0; i < entitycount; i++) {
			EntityLiving entity = this.getGrim(entitytype);
			BlockPos pos = this.getPos().add(rand.nextInt(SPAWN_RADIUS * 2 + 1) - SPAWN_RADIUS, 0, rand.nextInt(SPAWN_RADIUS * 2 + 1) - SPAWN_RADIUS);
			pos = this.world.getTopSolidOrLiquidBlock(pos);
			entity.setPositionAndRotation(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
			this.world.spawnEntity(entity);
			entities.add(entity);
		}
		return entities;
	}
	
	private EntityLiving getGrim(int difficulty) {
		switch(difficulty) {
			case 1:
				return new EntityBoarbatusk(this.world);
			case 2:
				return new EntityBeowolf(this.world);
			case 3:
				return new EntityUrsa(this.world);
			case 4:
				return new EntityLancer(this.world);
			case 5:
				return new EntityGeist(this.world);
			case 6:
				return new EntityApathy(this.world);
			case 7:
				return new EntityCreep(this.world);
			case 8:
				return new EntityJuvenileDeathstalker(this.world);
			case 9:
				return new EntityNeverMore(this.world);
			case 10:
				return new EntityDeathStalker(this.world);
			case 11:
				return new EntityGiantNeverMore(this.world);
			case 12:
				return new EntityMutantDeathStalker(this.world);
			case 13:
				return new EntityQueenLancer(this.world);
			case 14:
				return new EntityNuckleeve(this.world);
			case 15:
				return new EntityGoliath(this.world);
			default:
				return null;
		}
	}
	
	private float getAlivePercent() {
		float alive = 0;
		float total = 0;
		for (EntityLiving entity : this.wavelist) {
			if (entity.isEntityAlive()) {
				alive++;
			}
			total++;
		}
		return alive / total;
	}
	
	@Override
	protected void setWorldCreate(World worldIn) {
		super.setWorld(worldIn);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		RWBYModels.LOGGER.info("Read");
		super.readFromNBT(nbt);
		this.wavecount = nbt.getInteger("wavecount");
		if (nbt.hasKey("wavelist", 10)) {
			NBTTagCompound entities = nbt.getCompoundTag("wavelist");
			this.wavelist = new ArrayList<EntityLiving>();
			for (String key : entities.getKeySet()) {
				EntityLiving entity = this.getGrim(this.getEntityType());
				entity.deserializeNBT(entities.getCompoundTag(key));
				wavelist.add(entity);
			}
		}
		this.player = nbt.getString("player").isEmpty() ? null : world.getPlayerEntityByUUID(UUID.fromString(nbt.getString("player")));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		RWBYModels.LOGGER.info("Write");
		nbt.setInteger("wavecount", wavecount);
		if (!this.world.isRemote) {
			NBTTagCompound entities = new NBTTagCompound();
			Integer i = 0;
			for (EntityLiving entity : this.wavelist) {
				entities.setTag(i.toString(), entity.serializeNBT());
				i++;
			}
			nbt.setTag("wavelist", entities);
		}
		nbt.setString("player", this.player == null ? "" : player.getCachedUniqueIdString());
		return super.writeToNBT(nbt);
	}
}
