package be.bluexin.rwbym.blocks.tileentities;

import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.entity.*;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


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

		int i1 = rand.nextInt(100)+5;
		while (i1 > 0)
		{
			i1 --;
			ArrayList<ItemStack> drops = new ArrayList<>();
			drops.add(new ItemStack(RWBYItems.lien50, world.rand.nextInt(3) + 1));
			drops.add(new ItemStack(RWBYItems.lien100, world.rand.nextInt(3)+1));
			drops.add(new ItemStack(RWBYItems.remnants, rand.nextInt(3)+1));
			drops.add(new ItemStack(RWBYItems.lien500, 1));
			drops.add(new ItemStack(RWBYItems.rwbyblock8, 1));
			drops.add(new ItemStack(RWBYItems.waterblock, 1));
			drops.add(new ItemStack(RWBYItems.windblock, 1));
			drops.add(new ItemStack(RWBYItems.lightblock, 1));
			drops.add(new ItemStack(RWBYItems.fireblock, 1));
			drops.add(new ItemStack(RWBYItems.iceblock, 1));
			drops.add(new ItemStack(RWBYItems.impureblock, 1));
			drops.add(new ItemStack(RWBYItems.gravityblock, 1));

			EntityItem item = new EntityItem(this.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), drops.get(rand.nextInt(drops.size())));
			this.world.spawnEntity(item);
		}
		ArrayList<ItemStack> drops2 = new ArrayList<>();
		drops2.add(new ItemStack(RWBYItems.grimmrapier, 1));
		drops2.add(new ItemStack(RWBYItems.grimmscy, 1));
		drops2.add(new ItemStack(RWBYItems.grimmwhip, 1));
		drops2.add(new ItemStack(RWBYItems.noctustraumnormal, 1));
		drops2.add(new ItemStack(RWBYItems.he1, 1));
		drops2.add(new ItemStack(RWBYItems.he2, 1));
		drops2.add(new ItemStack(RWBYItems.he3, 1));
		drops2.add(new ItemStack(RWBYItems.he4, 1));
		drops2.add(new ItemStack(RWBYItems.he5, 1));
		drops2.add(new ItemStack(RWBYItems.he6, 1));
		drops2.add(new ItemStack(RWBYItems.extasis, 1));
		drops2.add(new ItemStack(RWBYItems.lichtroze_closedfire, 1));

		EntityItem item2 = new EntityItem(this.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), drops2.get(rand.nextInt(drops2.size())));
		this.world.spawnEntity(item2);

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
		//RWBYModels.LOGGER.info("Read");
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
		//RWBYModels.LOGGER.info("Write");
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
