package io.github.blaezdev.rwbym.weaponry.specialweapons.animations;

import java.util.ArrayList;
import java.util.List;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.utility.network.MessageEject;
import io.github.blaezdev.rwbym.utility.network.MessagePlaySound;
import io.github.blaezdev.rwbym.utility.network.RWBYNetworkHandler;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class AnimationControllerBolt implements IAnimationController {
    @Override
    public List<ItemPropertyWrapper> getProperties() {

        List<ItemPropertyWrapper> list = new ArrayList<>();

        list.add(IAnimationController.integerProperty("boltup", true));
        list.add(IAnimationController.integerProperty("boltback", true));

        return list;
    }

    @Override
    public void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {

        boolean flag = player.getHeldItemMainhand().equals(stack);

        if (flag && KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.SLIDELOCK_BOLT) && nbt.getInteger("boltback") == 0) {
            if (nbt.getBoolean("up")) {
            	RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.RIFLE_BOLT_DOWN));
            }
            else {
            	RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.RIFLE_BOLT_UP));
            }
            nbt.setBoolean("up", !nbt.getBoolean("up"));
        }
        if (flag && KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.REMOVEBULLET_SLIDE) && nbt.getInteger("boltup") == 2) {
            if (nbt.getBoolean("back")) {
            	RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.RIFLE_BOLT_FORWARD));
            }
            else {
            	RWBYNetworkHandler.sendToServer(new MessagePlaySound(Sound.RIFLE_BOLT_BACK));
            }
            nbt.setBoolean("back", !nbt.getBoolean("back"));
        }

        if (nbt.getBoolean("up")) {
            if (nbt.getInteger("boltup") < 2) {
                nbt.setInteger("boltup", nbt.getInteger("boltup") + 1);
            }
        }
        else {
            if (nbt.getInteger("boltup") > 0) {
                nbt.setInteger("boltup", nbt.getInteger("boltup") - 1);
            }
        }

        if (nbt.getBoolean("back")) {
            if (nbt.getInteger("boltback") < 2) {
                nbt.setInteger("boltback", nbt.getInteger("boltback") + 1);
            }
        }
        else {
            if (nbt.getInteger("boltback") > 0) {
                nbt.setInteger("boltback", nbt.getInteger("boltback") - 1);
            }
        }

        if (nbt.getBoolean("up")) {
            nbt.setBoolean("hammer", true);
        }

        if (nbt.getInteger("boltback") == 1) {
            if (nbt.getBoolean("back")) {
                if (!nbt.getString("BulletChambered").isEmpty()) {
                	RWBYNetworkHandler.sendToServer(new MessageEject(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(nbt.getString("BulletChambered"))))));
                    nbt.setString("BulletChambered", "");
                }
            }
            else {
                if (nbt.getTagList("bullets", 8).tagCount() > 0 && nbt.getString("BulletChambered").isEmpty()) {
                    nbt.setString("BulletChambered", nbt.getTagList("bullets", 8).getStringTagAt(nbt.getTagList("bullets", 8).tagCount() - 1));
                    nbt.getTagList("bullets", 8).removeTag(nbt.getTagList("bullets", 8).tagCount() - 1);
                }
            }
        }

    }
}
