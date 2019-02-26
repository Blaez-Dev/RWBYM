package be.bluexin.rwbym.weaponry;

import akka.japi.Pair;
import be.bluexin.rwbym.RWBYModels;
import be.bluexin.rwbym.RWBYSoundHandler;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.Map;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
@MethodsReturnNonnullByDefault
public class RWBYAmmoEntity extends EntityArrow { // FIXME: for some reason these are shaking like a superpowered vibrator
    private static final DataParameter<String> RS = EntityDataManager.createKey(RWBYAmmoEntity.class, DataSerializers.STRING);

    private ResourceLocation rs = new ResourceLocation("minecraft", "textures/entity/projectiles/spectral_arrow.png");
    private RWBYAmmoItem itemRef;


    private NBTTagCompound nbt = null;
    private Pair<Potion, Pair<Integer, Integer>> potion;

    private static final MethodHandle getTicksInGround;

    private double maxMotionX = 0D;
    private double maxMotionY = 0D;
    private double maxMotionZ = 0D;


    public RWBYAmmoEntity(World world) {
        super(world);
        this.dataManager.set(RS, this.rs.toString());
    }

    static {
        try {
            Field f = ReflectionHelper.findField(EntityArrow.class, "ticksInGround", "field_70252_j");
            f.setAccessible(true);
            getTicksInGround = MethodHandles.publicLookup().unreflectGetter(f);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public RWBYAmmoEntity(World worldIn, double x, double y, double z, RWBYAmmoItem from) {
        super(worldIn, x, y, z);
        this.rs = new ResourceLocation(RWBYModels.MODID, from.getTexture());
        this.dataManager.set(RS, this.rs.toString());
        this.setDamage(from.getBaseDamage());
        this.setNoGravity(!from.obeysGravity());
        this.itemRef = from;

        /*if (from.getPotion() != null) {
            String[] ps = from.getPotion().split("\\*", -1);
            Potion p = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ps[0]));
            if (p != null){
                Integer d = 100;
                Integer power = 1;
                if (ps.length > 1) {
                    try { power = Integer.parseInt(ps[1]); } catch (Exception ignored) { }
                }
                if (ps.length > 2) {
                    try { d = Integer.parseInt(ps[2]); } catch (Exception ignored) { }
                }
                this.potion = new Pair<>(p, new Pair<>(power, d));
            }
            else throw new IllegalStateException("Invalid Potion requested: " + new ResourceLocation(ps[0]));
        }
        */

        if (from.getNbt() != null && !world.isRemote) this.nbt = from.getNbt();
    } // TODO: add to dispenser registries (see usage of this constructor in other impl of EntityArrow

    public RWBYAmmoEntity(World worldIn, EntityLivingBase shooter, RWBYAmmoItem from) {
        this(worldIn, shooter.posX, shooter.posY + (double) shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ, from);
        this.shootingEntity = shooter;

        if (shooter instanceof EntityPlayer && from.canPickup()) this.pickupStatus = PickupStatus.ALLOWED;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(RS, "");
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(itemRef);
    }

    ResourceLocation getRs() {
        return new ResourceLocation(this.dataManager.get(RS));
    }



    @Override
    protected void arrowHit(EntityLivingBase living)
    {
        living.attackEntityFrom(DamageSource.GENERIC, 8);
        living.hurtResistantTime = 0;
        super.arrowHit(living);
        if (potion != null)
        {
            PotionEffect potioneffect = new PotionEffect(potion.first(), potion.second().first(), potion.second().second());
            living.addPotionEffect(potioneffect);
        }

    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

        compound.setString("itemRef", this.itemRef == null ? "" : this.itemRef.getRegistryName().toString());
        compound.setString("texture", this.rs.toString());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        if (compound.hasKey("itemRef"))
            this.itemRef = (RWBYAmmoItem) Item.getByNameOrId(compound.getString("itemRef"));
        if (compound.hasKey("texture")) {
            String s = compound.getString("texture");
            this.rs = s.length() > 0 ? new ResourceLocation(s) : null;
            if (this.rs != null) this.dataManager.set(RS, this.rs.toString());
        }
    }

    @Override
    public void setDead() {
        this.getPassengers().forEach(it -> {
            it.motionX = this.maxMotionX;
            it.motionY = this.maxMotionY;
            it.motionZ = this.maxMotionZ;
        });
        super.setDead();
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.nbt != null) {
            this.maxMotionX = this.motionX;
            this.maxMotionY = this.motionY;
            this.maxMotionZ = this.motionZ;




            if (nbt.hasKey("Passengers", 9)) {
                NBTTagList nbttaglist = nbt.getTagList("Passengers", 10);

                for (int i = 0; i < nbttaglist.tagCount(); ++i) {
                    Entity entity = AnvilChunkLoader.readWorldEntityPos(nbttaglist.getCompoundTagAt(i), world, posX, posY, posZ, false);
                    if (entity != null) {
                        entity.isDead = false;
                        world.spawnEntity(entity);
                        entity.startRiding(this, true);
                    }
                }
            }
            this.nbt = null;
        }

        if (this.inGround && getTicksInGround() > 1) this.setDead();
    }


    private int getTicksInGround() {
        try {
            return (Integer) getTicksInGround.invoke(this);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return 0;
        }
    }

}
