package io.github.blaezdev.rwbym;

import io.github.blaezdev.rwbym.Init.EnchantInit;
import io.github.blaezdev.rwbym.Init.RWBYBiomes;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.capabilities.Aura.AuraProvider;
import io.github.blaezdev.rwbym.capabilities.Aura.IAura;
import io.github.blaezdev.rwbym.capabilities.CapabilityHandler;
import io.github.blaezdev.rwbym.capabilities.Clover.IClover;
import io.github.blaezdev.rwbym.capabilities.ISemblance;
import io.github.blaezdev.rwbym.capabilities.Lysette.ILysette;
import io.github.blaezdev.rwbym.capabilities.Qrow.IQrow;
import io.github.blaezdev.rwbym.capabilities.itemdata.ItemDataProvider;
import io.github.blaezdev.rwbym.entity.EntityBullet;
import io.github.blaezdev.rwbym.entity.EntityGrimm;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import io.github.blaezdev.rwbym.utility.Util;
import io.github.blaezdev.rwbym.utility.network.MessageSendPlayerData;
import io.github.blaezdev.rwbym.utility.network.MessageUpdateFlying;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.ArmourBase;
import io.github.blaezdev.rwbym.weaponry.RWBYGliderItem;
import io.github.blaezdev.rwbym.weaponry.RWBYGun;
import io.github.blaezdev.rwbym.weaponry.RWBYHood;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.reflect.internal.Trees;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.renderer.GlStateManager.FogMode.EXP;
import static net.minecraft.client.renderer.GlStateManager.FogMode.LINEAR;

public class EntityUpdatesHandler {

    private ItemStack generateitem(ItemStack is){
        ItemStack generatedis = is;
        ItemStack generatedisclean = new ItemStack(generatedis.getItem());
        generatedisclean.addEnchantment(EnchantInit.getBarrelmodifierEnchant(), 1);
        generatedisclean.addEnchantment(EnchantInit.getFramemodifierEnchant(), 1);
        generatedisclean.addEnchantment(EnchantInit.getShotmodifierEnchant(), 1);
        generatedisclean.addEnchantment(EnchantInit.getKillmodifierEnchant(), 1);
        //generatedis.addEnchantment(EnchantInit.getEnemymodifierEnchant(), 1);
        return generatedisclean;
    }

    @SubscribeEvent
    public void onUpdate(LivingUpdateEvent event) {
        EntityLivingBase entityLiving = event.getEntityLiving();

        if (entityLiving != null && entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;

            IAura aura = null;

            if (!player.world.isRemote && player.hasCapability(AuraProvider.AURA_CAP, null)) {
                aura = player.getCapability(AuraProvider.AURA_CAP, null);
                aura.onUpdate(player);
            }

            ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
            if (semblance != null) {
                semblance.onUpdate(player);
            }
            if (!player.world.isRemote) {
                RWBYNetworkHandler.sendToAll(new MessageSendPlayerData(semblance, aura, player.getEntityData().getCompoundTag(RWBYModels.MODID), player.getName()));
            }
        }
    }

    @SubscribeEvent
    public void onItemStopUse(LivingEntityUseItemEvent.Stop event) {
		ItemStack stack = event.getItem();
		if (stack.getItem() instanceof ItemGun) {
    		event.setCanceled(event.getEntityLiving().world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).getData().getCompoundTag(Util.getOrCreateTag(stack).getString("UUID")).getBoolean("ads"));
    	}
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(EntityViewRenderEvent.FogDensity event)
    {   EntityPlayer player = (EntityPlayer) event.getEntity();
        Biome biome = player.world.getBiome(player.getPosition());
        if (biome == RWBYBiomes.GrimmWastes)
        {
            GlStateManager.setFog(EXP);
            event.setDensity(0.3F);
            event.setCanceled(true);
        }//else if (biome == RWBYBiomes.DomainofLight) { GlStateManager.setFog(EXP); event.setDensity(0.005F); event.setCanceled(true);}
        else{GlStateManager.setFog(LINEAR); event.setDensity(0.0000001F);}
         // must cancel event for event handler to take effect
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(EntityViewRenderEvent.FogColors event)
    { EntityPlayer player = (EntityPlayer) event.getEntity();
        Biome biome = player.world.getBiome(player.getPosition());
        if (biome == RWBYBiomes.GrimmWastes)
        {
            event.setRed(0.2F);
            event.setGreen(0.2F);
            event.setBlue(0.2F);
        }/*else if (biome == RWBYBiomes.DomainofLight)
        {
            event.setRed(1F);
            event.setGreen(1F);
            event.setBlue(0.65F);
        }*/
    }

    @SubscribeEvent
    public void playerRespawn(PlayerRespawnEvent e) {
        EntityPlayer player = e.player;
        IAura otheraura = player.getCapability(AuraProvider.AURA_CAP, null);
        otheraura.setAmount(0);
        otheraura.addAmount(otheraura.getMaxAura());
        //System.out.println("Respawn");
    }

    @SubscribeEvent
    public void entityDeath(LivingDeathEvent event){
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
            ItemStack isMainhand = player.getHeldItemMainhand();
            ItemStack isOffhand = player.getHeldItemOffhand();
            if(EnchantmentHelper.getEnchantmentLevel(EnchantInit.AURA_SIPHON, isMainhand) > 0||EnchantmentHelper.getEnchantmentLevel(EnchantInit.AURA_SIPHON, isOffhand) > 0 && aura.getAmount() < aura.getMaxAura()){
                aura.useAura(player, -10F, false);
                if(aura.getMaxAura()<aura.getAmount()){
                    aura.setAmount(aura.getMaxAura());
                }
            }

            if(EnchantmentHelper.getEnchantmentLevel(EnchantInit.SCAVENGER, isMainhand) > 0||EnchantmentHelper.getEnchantmentLevel(EnchantInit.SCAVENGER, isOffhand) > 0){
                if(isMainhand.getItem() instanceof RWBYGun && EnchantmentHelper.getEnchantmentLevel(EnchantInit.SCAVENGER, isMainhand) > 0 && player.getRNG().nextInt(32) < 4){
                RWBYGun gun = (RWBYGun)isMainhand.getItem();
                ItemStack ammo = gun.findAmmo(player, false);
                    if(gun.weapontype == gun.INT_MAG){
                        ammo = isMainhand;
                    }
                ammo.damageItem(-2, player);
                }else if(isOffhand.getItem() instanceof RWBYGun && EnchantmentHelper.getEnchantmentLevel(EnchantInit.SCAVENGER, isOffhand) > 0 && player.getRNG().nextInt(32) < 4){
                    RWBYGun gun = (RWBYGun)isOffhand.getItem();
                    ItemStack ammo = gun.findAmmo(player, false);
                    if(gun.weapontype == gun.INT_MAG){
                        ammo = isOffhand;
                    }
                    ammo.damageItem(-2, player);
                }
            }

        }
    }

    @SubscribeEvent
    public void firstJoin(PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        IAura otheraura = player.getCapability(AuraProvider.AURA_CAP, null);
        NBTTagCompound entityData = player.getEntityData();
        if (!entityData.getBoolean(RWBYModels.MODID + "joinedBefore")) {
            entityData.setBoolean(RWBYModels.MODID + "joinedBefore", true);

            if (RWBYConfig.general.enablefirstspawnscroll) {
                player.inventory.addItemStackToInventory(new ItemStack(RWBYItems.scroll));
            }
            otheraura.setAmount(otheraura.getMaxAura());
        }
    }

    @SubscribeEvent
    public void exp(PlayerPickupXpEvent event){
        EntityPlayer player = event.getEntityPlayer();
        if(player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == RWBYItems.relicofknowledge){
        player.addExperience(10);}
    }

    @SubscribeEvent
    public void onBlockDropItems(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getHarvester();
            if (event.getState().getMaterial() == Material.PLANTS && player.getHeldItemMainhand().getItem() == RWBYItems.leafshield || event.getState().getMaterial() == Material.PLANTS && player.getHeldItemOffhand().getItem() == RWBYItems.leafshield) {
                List<ItemStack> drops = new ArrayList<ItemStack>();
                drops.addAll(event.getDrops());
                for (int i = 0; i < 1; ++i) {
                    event.setDropChance(1.0F);
                    event.getDrops().addAll(drops);
                    System.out.println(event.getDrops().toString());
                }
            }
        }

    }

    @SubscribeEvent
    public void onLivingDropsEvent(LivingDropsEvent event) {
        Entity entity = event.getEntity();
        World world = event.getEntity().getEntityWorld();
        BlockPos pos = event.getEntity().getPosition();
        ArrayList<Item> itemset1 = new ArrayList<>();
        itemset1.add(RWBYItems.lichtroze_closedfire);
        itemset1.add(RWBYItems.lichtroze_closedice);
        itemset1.add(RWBYItems.lichtroze_closedwind);
        ArrayList<Item> itemset2 = new ArrayList<>();
        itemset2.add(RWBYItems.heroshield);
        itemset2.add(RWBYItems.leafshield);
        itemset2.add(RWBYItems.pickaxeshield);
        itemset2.add(RWBYItems.rageshield);
        Entity killer = event.getSource().getTrueSource();

        for (int i = 0; i < event.getDrops().size(); i++) {
            ItemStack randomizedrops = event.getDrops().get(i).getItem();
            if(randomizedrops.getItem() instanceof RWBYGun){
                randomizedrops = generateitem(randomizedrops);
                EntityItem itemdroprandomizer = new EntityItem(world, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, randomizedrops);
                event.getDrops().set(i, itemdroprandomizer);
            }
        }


        if (event.getSource().getDamageType().equals("player")) {
            if (entity instanceof EntityGrimm && killer instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                //mh equals the item held by the Player
                Item mh = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
                if (itemset1.contains(mh)) {
                    ItemStack stack = new ItemStack(RWBYItems.peach);
                    EntityItem itemDropX = new EntityItem(world, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, stack);
                    event.getDrops().add(itemDropX);
                }
                if (itemset2.contains(mh)) {
                    ItemStack stack = new ItemStack(RWBYItems.remnants);
                    EntityItem itemDrop1 = new EntityItem(world, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, stack);
                    EntityItem itemDrop2 = new EntityItem(world, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, stack);
                    event.getDrops().add(itemDrop1);
                    event.getDrops().add(itemDrop2);
                }
            }
        }
    }

    public boolean validperk(EntityLivingBase playerIn,long armorperk){
        for (ItemStack stack:playerIn.getArmorInventoryList()){
            if(stack.getItem() instanceof ArmourBase){
                if((((ArmourBase) stack.getItem()).armourperks & armorperk) !=0L){
                    //System.out.println("armor works");
                    return true;
                }}
            if(stack.getItem() instanceof RWBYHood){
                if((((RWBYHood) stack.getItem()).armourperks & armorperk) !=0L) {
                    //System.out.println("hood works");
                    return true;
                }}
        }
        return false;
    }

    @SubscribeEvent
    public void onEntityDamageLast(LivingHurtEvent event) {
        EntityLivingBase entityliving = event.getEntityLiving();

        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
            float attackdamage = event.getAmount();
            if (semblance instanceof IClover) {
                int level = semblance.getLevel();
                if (level == 1) {
                    float eventdamage = attackdamage * 1.2f;
                    event.setAmount(eventdamage);
                }
                if (level == 2) {
                    float eventdamage = attackdamage * 1.3f;
                    event.setAmount(eventdamage);
                }
                if (level == 3) {
                    float eventdamage = attackdamage * 1.4f;
                    event.setAmount(eventdamage);
                }
            }
        }

        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
            if (semblance instanceof ILysette) {
                int level = semblance.getLevel();
                PotionEffect potion = new PotionEffect(MobEffects.SLOWNESS, level * 150, 128, true, false);
                if (semblance.isActive()) {
                    entityliving.addPotionEffect(potion);
                    player.getCapability(AuraProvider.AURA_CAP, null).useAura(player, 15F, false);
                }
            }
        }

        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);
            float attackdamage = event.getAmount();
            if (semblance instanceof IQrow) {
                int level = semblance.getLevel();
                if (level == 1) {
                    float eventdamage = attackdamage * (player.getEntityWorld().rand.nextFloat() + 0.5F);
                    event.setAmount(eventdamage);
                }
                if (level == 2) {
                    float eventdamage = attackdamage * (player.getEntityWorld().rand.nextFloat() + 0.6F);
                    event.setAmount(eventdamage);
                }
                if (level == 3) {
                    float eventdamage = attackdamage * (player.getEntityWorld().rand.nextFloat() + 0.7F);
                    event.setAmount(eventdamage);
                }

            }
        }

        if(event.getSource().getTrueSource() instanceof EntityPlayer){
            EntityPlayer attacker = (EntityPlayer) event.getSource().getTrueSource();
            if(this.validperk(attacker, ArmourBase.KINGSPAWN)){
                AxisAlignedBB axisalignedbb2 = attacker.getEntityBoundingBox().grow(10,10,10);
                //System.out.println(event.getAmount());
                List<EntityPlayer> nearbyplayers = attacker.world.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb2);
                for (EntityPlayer entityplayer : nearbyplayers) if(validperk(entityplayer, ArmourBase.KINGSGAMBIT))
                {
                    event.setAmount(event.getAmount() * 1.5F);
                    //System.out.println(event.getAmount());
                    break;
                }
            }
        }
    }

    @SubscribeEvent
    public void onEntityDamageFirst(LivingHurtEvent event) {
        EntityLivingBase entityliving = event.getEntityLiving();
        if (RWBYConfig.aura.aurablockdamage) {
            if (entityliving instanceof EntityPlayer && !entityliving.world.isRemote) {
                EntityPlayer player = (EntityPlayer) entityliving;
                if (player.hasCapability(AuraProvider.AURA_CAP, null)) {
                    IAura aura = player.getCapability(AuraProvider.AURA_CAP, null);
                    float playerdamagereduction = aura.getMaxAura() / RWBYConfig.aura.playerdamagetoaurareduction;
                    float mobdamagereduction = aura.getMaxAura() / RWBYConfig.aura.entitydamagetoaurareduction;
                    float eventamount = event.getAmount() * 5;
                    if (playerdamagereduction > 0.5F) {
                        playerdamagereduction = 0.5F;
                    }
                    if (mobdamagereduction > 0.7F) {
                        mobdamagereduction = 0.7F;
                    }


                    if (RWBYConfig.aura.mobauradamagereduction) {
                        if (event.getSource().getTrueSource() instanceof EntityMob) {
                            float overflow = aura.useAura(player, eventamount * mobdamagereduction, true);
                            aura.delayRecharge(600);
                            event.setAmount(overflow / 5);
                        } else {
                            float overflow = aura.useAura(player, event.getAmount() * 5, true);
                            aura.delayRecharge(600);
                            event.setAmount(overflow / 5);
                        }}
                    if (RWBYConfig.aura.aurareduction) {
                        if (event.getSource().getTrueSource() instanceof EntityPlayer || event.getSource().getTrueSource() instanceof EntityBullet || event.getSource().getTrueSource() instanceof EntityArrow) {
                            float overflow = aura.useAura(player, eventamount * playerdamagereduction, true);
                            aura.delayRecharge(600);
                            event.setAmount(overflow / 5);
                        } else {
                            float overflow = aura.useAura(player, event.getAmount() * 5, true);
                            aura.delayRecharge(600);
                            event.setAmount(overflow / 5);
                        }

                    } else {
                        float overflow = aura.useAura(player, event.getAmount() * 5, true);
                        aura.delayRecharge(600);
                        event.setAmount(overflow / 5);
                    }
                }
            }
        }

    }


    @SubscribeEvent
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        RWBYModels.LOGGER.log(RWBYModels.debug, "Player Respawn");

        EntityPlayer player = event.player;

        ISemblance semblance = CapabilityHandler.getCurrentSemblance(player);

        if (semblance != null && player.hasCapability(semblance.getCapability(), null)) {
            RWBYModels.LOGGER.log(RWBYModels.debug, "Player has Semblance: " + semblance + ", with Level: " + ((ISemblance) player.getCapability(semblance.getCapability(), null)).getLevel());
        }
    }

    @SubscribeEvent
    public void onPlayerClone(Clone event) {
        ISemblance semblance = CapabilityHandler.getCurrentSemblance(event.getOriginal());

        int level = semblance.getLevel();

        semblance = CapabilityHandler.getCapabilityByName(event.getEntityPlayer(), semblance.getCapability().getName());

        semblance.setLevel(level);

        IAura oldaura = event.getOriginal().getCapability(AuraProvider.AURA_CAP, null);

        IAura newaura = event.getEntityPlayer().getCapability(AuraProvider.AURA_CAP, null);

        newaura.deserialize((NBTTagCompound) oldaura.serialize());

        event.getEntityPlayer().getEntityData().merge(event.getOriginal().getEntityData());
    }

    @SubscribeEvent
    public void onPlayerLoggedOn(PlayerLoggedInEvent event) {

        ISemblance semblance = CapabilityHandler.getCurrentSemblance(event.player);

        if (semblance == null) {

            List<ISemblance> semblances = CapabilityHandler.getAllSemblances(event.player);

            semblance = semblances.get(event.player.world.rand.nextInt(semblances.size()));

            if (semblance == null) {
                RWBYModels.LOGGER.error("Could not Get A Semblance for Player {}", event.player.getDisplayNameString());
            } else {
                RWBYModels.LOGGER.log(RWBYModels.debug, "Set Semblance for Player {} to {}", event.player.getDisplayNameString(), semblance);
                semblance.setLevel(1);
            }
        }

        RWBYModels.LOGGER.log(RWBYModels.debug, "Player {} Logged On With Semblance {}", event.player.getDisplayNameString(), semblance);

    }



    @SubscribeEvent
    public void clientConnectedToServer(ClientConnectedToServerEvent event) {
        RWBYModels.LOGGER.log(RWBYModels.debug, "Client Connected");
    }

    private boolean flag = false;
    
    @SubscribeEvent
    public void onClientTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        Biome biome = player.world.getBiome(player.getPosition());


        if (biome == RWBYBiomes.GrimmWastes && player.isInWater()) {
            PotionEffect potioneffect = new PotionEffect(MobEffects.POISON, 60, 3, false, false);
            PotionEffect potioneffect1 = new PotionEffect(MobEffects.WITHER, 60, 2, false, false);
            player.addPotionEffect(potioneffect);
            player.addPotionEffect(potioneffect1);
        }


        if (biome == RWBYBiomes.DomainofLight && player.isInWater()) {
            PotionEffect potioneffect = new PotionEffect(MobEffects.REGENERATION, 60, 3, false, false);
            player.addPotionEffect(potioneffect);
        }

        if (player.world.isRemote) {
            if(player instanceof EntityPlayer){
                if(player instanceof EntityPlayerSP){
        	EntityPlayerSP client = (EntityPlayerSP) player;

	        if (!client.onGround && client.motionY < 0.0D && !client.isElytraFlying() && !client.capabilities.isFlying)
	        {
	            ItemStack itemstack1 = client.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
	            ItemStack itemstack2 = client.getActiveItemStack();

	            if ((client.movementInput.jump && !flag && itemstack1.getItem() instanceof ItemElytra && ItemElytra.isUsable(itemstack1)) || itemstack2.getItem() instanceof RWBYGliderItem && ItemElytra.isUsable(itemstack2))
	            {
 	            	RWBYNetworkHandler.sendToServer(new MessageUpdateFlying());
	            }
	        }

	        flag = client.movementInput.jump;

        }}}

    }

    private ItemStack findtainted(EntityPlayer player){
        for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = player.inventory.getStackInSlot(i);
            if (itemstack.getItem() == RWBYItems.taintedartefact) {
                return itemstack;
            }
        }
        return ItemStack.EMPTY;
    }


/*
    @SubscribeEvent
    public void DropItem(LivingDamageEvent event) {
        Entity e = event.getEntity();
        if (e instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e;
            World world = player.world;
            ItemStack itemstack = findtainted(player);
            if(itemstack.getItem() == RWBYItems.taintedartefact){
            ItemStack tainted = new ItemStack(RWBYItems.taintedartefact);
            if(itemstack.getCount()>5){
            tainted.setCount(itemstack.getCount());}
            EntityItem item = new EntityItem(world, player.posX, player.posY + 1, player.posZ, tainted);
            item.motionX = world.rand.nextGaussian() * 0.1;
            item.motionZ = world.rand.nextGaussian() * 0.1;
            item.motionY = 0.5;
            world.spawnEntity(item);
            itemstack.setCount(0);
            //mc.player.dropItem(RWBYItems.taintedartefact, 1);
        }else{  if(world.rand.nextInt(100)>50 && event.getSource().getTrueSource() instanceof EntityPlayer){
                ItemStack tainted = new ItemStack(RWBYItems.taintedartefact);
                EntityItem item = new EntityItem(world, player.posX, player.posY + 1, player.posZ, tainted);
                item.motionX = world.rand.nextGaussian() * 0.1;
                item.motionZ = world.rand.nextGaussian() * 0.1;
                item.motionY = 0.5;
                world.spawnEntity(item);}}
        }
    }*/
}
