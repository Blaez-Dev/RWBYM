package io.github.blaezdev.rwbym.weaponry;

import com.mojang.realmsclient.gui.ChatFormatting;
import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.Init.RegUtil;
import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Part of rwbym by Bluexin.
 *
 * @author Bluexin
 */
public class RWBYFood extends Item implements ICustomItem {

    private final String data;
    private boolean alwaysEdible;
    private int food;
    private boolean food6;


    public RWBYFood(String name,String data,int food, CreativeTabs creativetab) {
        this.setRegistryName(new ResourceLocation(RWBYModels.MODID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
        this.data = data;
        this.setCreativeTab(creativetab);
        this.alwaysEdible = true;
        this.setMaxDamage(3);
        this.food = food;
        this.maxStackSize = 2;
        if(food == 2||food == 6|| food == 7||food ==9||food ==12){
            this.food6 = true;
        }
        if(food6){
            maxStackSize = 1;
        }
        if(food == 14 || food == 15|| food == 16){
            maxStackSize = 64;
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
    {
        return enchantment.type.canEnchantItem(Items.CAKE);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (food == 1) {//Hot Chocolate
            tooltip.add(ChatFormatting.BLUE +"-" +  "Regeneration and Health Boost for 1 minute.");
        }
        if (food == 2) {//Coffee
            tooltip.add(ChatFormatting.BLUE +"-" +  "Speed and Haste for 1 minute.");
        }
        if (food == 3) {//Strawberry Sunrise
            tooltip.add(ChatFormatting.BLUE +"-" +  "Speed, Resistance, and Strength for 1 minute");
        }
        if (food == 4) {//Grape Soda
            tooltip.add(ChatFormatting.BLUE +"-" +  "Haste for 1 minute and Health Restore.");
        }
        if (food == 5) {//TorchQuick
            tooltip.add(ChatFormatting.BLUE +"-" +  "a Tasty Energy Drink with none of the Horrible Side Effects!");

        }
        if (food == 6) {//Qrow's Flask
            tooltip.add(ChatFormatting.BLUE +"-" +  "Smells Strong. Restores Saturation and Health");
        }
        if (food == 7) {//Sake
            tooltip.add(ChatFormatting.BLUE +"-" +  "Invisibility for 1 minute.");

        }
        if (food == 8) {
            //Coconut Milk
            tooltip.add(ChatFormatting.BLUE +"-" +  "Jump Boost,Speed,Water Breathing and Night Vision for 1 minute.");
        }

        if (food == 9) {//Pancakes
            tooltip.add(ChatFormatting.BLUE +"-" +  "Good Luck for 2 minutes, Aura Regen for 1 Minute and Restores Saturation");
        }

        if (food == 10) {
            //Boubon
            tooltip.add(ChatFormatting.BLUE +"-" +  "Absorption for 2 minutes.");
        }

        if (food == 11) {//Brandy
            tooltip.add(ChatFormatting.BLUE +"-" +  "Strength and Aura Regen for 2 minutes.");
        }

        if (food == 12) {//Vodka
            tooltip.add(ChatFormatting.BLUE +"-" +  "Strength for 2 minutes.");
        }

        if (food == 13) {//Wine
            tooltip.add(ChatFormatting.BLUE +"-" +  "Strength and Speed for 2 minutes.");
        }

        if (food == 14) {//Fish Ramen
            tooltip.add(ChatFormatting.BLUE +"-" +  "Aura Regen and Night Vision for 2 minutes and Restores Saturation.");
        }

        if (food == 15) {//Ramen
            tooltip.add(ChatFormatting.BLUE +"-" +  "Aura Regen for 2 minutes and Restores Saturation.");
        }
        if (food == 16) {//Peach
            tooltip.add(ChatFormatting.BLUE +"-" +  "Heals for 2.5 Hearts");
        }
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            //this.onFoodEaten(stack, worldIn, entityplayer);
            if (food == 1) {
                //Hot Chocolate
                PotionEffect potioneffect = new PotionEffect(MobEffects.REGENERATION, 1200, 0, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.HEALTH_BOOST, 1200, 0, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if (food == 2) {
                //Coffee
                PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, 1200, 1, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.HASTE, 1200, 1, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if (food == 3) {
                //Strawberry Sunrise
                PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, 1200, 1, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.RESISTANCE, 1200, 1, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.STRENGTH, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
            }
            if (food == 4) {
                //Grape Soda
                PotionEffect potioneffect = new PotionEffect(MobEffects.HASTE, 1200, 3, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.INSTANT_HEALTH, 20, 0, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if (food == 5) {
                //TorchQuick
                PotionEffect potioneffect = new PotionEffect(MobEffects.BLINDNESS, 1200, 1, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.WEAKNESS, 1200, 1, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.POISON, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
            }
            if (food == 6) {
                //Qrow's Flask
                PotionEffect potioneffect = new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 0, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.NAUSEA, 200, 1, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.UNLUCK, 3600, 2, false, false);
                PotionEffect potioneffect3 = new PotionEffect(MobEffects.SATURATION, 5, 0, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
                entityplayer.addPotionEffect(potioneffect3);
            }
            if (food == 7) {
                //Sake
                PotionEffect potioneffect = new PotionEffect(MobEffects.NAUSEA, 100, 3, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.INVISIBILITY, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
            }
            if (food == 8) {
                //Coconut Milk
                PotionEffect potioneffect = new PotionEffect(MobEffects.SPEED, 1200, 2, false, false);
                PotionEffect potioneffect1 = new PotionEffect(MobEffects.JUMP_BOOST, 1200, 2, false, false);
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.WATER_BREATHING, 1200, 3, false, false);
                PotionEffect potioneffect3 = new PotionEffect(MobEffects.NIGHT_VISION, 1200, 2, false, false);
                entityplayer.addPotionEffect(potioneffect);
                entityplayer.addPotionEffect(potioneffect1);
                entityplayer.addPotionEffect(potioneffect2);
                entityplayer.addPotionEffect(potioneffect3);
            }

            if (food == 9) {
                //Pancakes
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.SATURATION, 60, 5, false, false);
                entityplayer.addPotionEffect(potioneffect2);
                ;
                PotionEffect potioneffect21 = new PotionEffect(MobEffects.LUCK, 2400, 5, false, false);
                entityplayer.addPotionEffect(potioneffect21);
                ;
                PotionEffect potionEffect3 = new PotionEffect(RegUtil.AURA_REGEN, 1200, 0);
                entityLiving.addPotionEffect(potionEffect3);
            }

            if (food == 10) {
                //Boubon
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.ABSORPTION, 2400, 2, false, false);
                entityplayer.addPotionEffect(potioneffect2);
            }

            if (food == 11) {
                //Brandy
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.STRENGTH, 2400, 1, false, false);
                entityplayer.addPotionEffect(potioneffect2);
                PotionEffect potionEffect3 = new PotionEffect(RegUtil.AURA_REGEN, 2400, 0);
                entityLiving.addPotionEffect(potionEffect3);
            }

            if (food == 12) {
                //Vodka
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.STRENGTH, 2400, 2, false, false);
                entityplayer.addPotionEffect(potioneffect2);
            }

            if (food == 13) {
                //Wine
                entityplayer.clearActivePotions();
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.SPEED, 2400, 0, false, false);
                entityplayer.addPotionEffect(potioneffect2);
                PotionEffect potionEffect3 = new PotionEffect(MobEffects.STRENGTH, 2400, 0);
                entityLiving.addPotionEffect(potionEffect3);
            }

            if (food == 14) {
                //Fish Ramen
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.SATURATION, 60, 5, false, false);
                entityplayer.addPotionEffect(potioneffect2);
                PotionEffect potioneffect21 = new PotionEffect(MobEffects.NIGHT_VISION, 2400, 5, false, false);
                entityplayer.addPotionEffect(potioneffect21);
                PotionEffect potionEffect3 = new PotionEffect(RegUtil.AURA_REGEN, 2400, 0);
                entityLiving.addPotionEffect(potionEffect3);
            }

            if (food == 15) {
                //Ramen
                PotionEffect potioneffect2 = new PotionEffect(MobEffects.SATURATION, 60, 5, false, false);
                entityplayer.addPotionEffect(potioneffect2);
                PotionEffect potionEffect3 = new PotionEffect(RegUtil.AURA_REGEN, 2400, 0);
                entityLiving.addPotionEffect(potionEffect3);
            }
            if (food == 16) {
                //Peach
                entityplayer.heal(2.5F);
            }
        }
        if(food6){
            stack.damageItem(1, entityLiving);
        }
        if(!food6){
        stack.shrink(1);}
        return stack;
    }


    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (playerIn.canEat(this.alwaysEdible)) {
            playerIn.setActiveHand(handIn);
            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
        } else {
            return new ActionResult(EnumActionResult.FAIL, itemstack);
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    public int getItemEnchantability()
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return false;
    }

    @Override
    public String toString() {
        return "RWBYItem{" + this.getRegistryName() + "}";
    }
}
