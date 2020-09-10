package io.github.blaezdev.rwbym.weaponry.specialweapons.animations;

import java.util.*;

import io.github.blaezdev.rwbym.KeyInputHandler;
import io.github.blaezdev.rwbym.weaponry.specialweapons.ItemPropertyWrapper;
import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AnimationControllerFireSelect implements IAnimationController {
	
	private final LinkedHashSet<Modes> options;
	private final ItemGun itemgun;
	private final int maxBurstCount;
	
	public AnimationControllerFireSelect(ItemGun itemgun, Modes... modes) {
		options = new LinkedHashSet<>(Arrays.asList(modes));
		if (options.contains(Modes.BURST)) {
			throw new IllegalArgumentException("Specified Burst Mode without specifying Burst Count");
		}
		this.itemgun = itemgun;
		MinecraftForge.EVENT_BUS.register(this);
		maxBurstCount = 0;
	}

	public AnimationControllerFireSelect(ItemGun itemgun, int maxBurstCount, Modes... modes) {
		options = new LinkedHashSet<>(Arrays.asList(modes));
		if (!options.contains(Modes.BURST)) {
			throw new IllegalArgumentException("Specified Burst Count without specifying Burst Mode");
		}
		this.itemgun = itemgun;
		MinecraftForge.EVENT_BUS.register(this);
		this.maxBurstCount = maxBurstCount;
	}

	@Override
	public List<ItemPropertyWrapper> getProperties() {
		List<ItemPropertyWrapper> list = new ArrayList<>();
		
		list.add(IAnimationController.integerProperty("mode", true));
		list.add(IAnimationController.integerProperty("modeindex", true));
		if (this.options.contains(Modes.BURST)) {
			list.add(IAnimationController.integerProperty("burstcount", true));
		}
		
		return list;
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onHammerDownEvent(AnimationControllerHammer.HammerDownEvent event) {
		if (event.getGun() == this.itemgun) {
			Modes mode = Modes.values()[event.getNbt().getInteger("mode")];
			if (mode == Modes.SAFETY) {
				event.setCanceled(true);
			}
			else if (mode == Modes.SEMI) {
				if (event.getNbt().getBoolean("held")) {
					event.setCanceled(true);
				}
			}
			else if (mode == Modes.BURST) {
				int burstCount = event.getNbt().getInteger("burstcount");
				if (event.getNbt().getBoolean("held")) {
					System.out.println("burst" + event.getNbt().getInteger("burstcount"));
					if (burstCount >= maxBurstCount - 1) {
						event.setCanceled(true);
					}
					else {
						event.getNbt().setInteger("burstcount", burstCount + 1);
					}
				}
				else {
					event.getNbt().setInteger("burstcount", 0);
				}
			}
		}
	}

	@Override
	public void update(ItemStack stack, World worldIn, EntityPlayer player, int itemSlot, boolean isSelected, NBTTagCompound nbt, ItemGun gun) {
		boolean flag = player.getHeldItemMainhand().equals(stack);
		if (flag && KeyInputHandler.isKeyPressed(KeyInputHandler.KeyPresses.FIRESELECT)) {
			nbt.setInteger("modeindex", (nbt.getInteger("modeindex") + 1)%options.size());
		}
		nbt.setInteger("mode", options.toArray(new Modes[0])[nbt.getInteger("modeindex")].ordinal());
	}
	
	public enum Modes {
		SEMI,
		BURST,
		AUTO,
		SAFETY
	}

}
