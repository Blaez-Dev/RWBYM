package io.github.blaezdev.rwbym.weaponry.specialweapons.bullets;

import java.util.Random;
import java.util.function.Supplier;

import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public abstract class ItemBullet extends Item {
	
	protected static final Random rand = new Random();
	
	protected final Supplier<Item> casing;

	public ItemBullet(Supplier<Item> casing) {
		super();
		this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
		this.casing = casing;
	}
	
	public Item getCasing() {
		return casing == null ? null : casing.get();
	}
	
	public abstract void fire(World world, EntityPlayer player, float entityAccuracy, float gunAccuracy, int life);

}
