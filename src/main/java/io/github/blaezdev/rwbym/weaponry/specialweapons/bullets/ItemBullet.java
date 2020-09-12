package io.github.blaezdev.rwbym.weaponry.specialweapons.bullets;

import java.util.Random;
import java.util.function.Supplier;

import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class ItemBullet extends Item {
	
	protected final Random rand = new Random();
	
	protected double nextRandA;
	protected double nextRandB;
	
	protected final Supplier<Item> casing;

	public ItemBullet(Supplier<Item> casing) {
		super();
		this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
		this.casing = casing;
		nextRandA = rand.nextDouble();
		nextRandB = rand.nextDouble();
	}
	
	public Item getCasing() {
		return casing == null ? null : casing.get();
	}
	
	public abstract void fire(World world, EntityPlayer player, float entityAccuracy, float gunAccuracy, int life);
	
	public abstract Vec3d getPredictorLine(EntityPlayer player, float entityAccuracy, float gunAccuracy);

}
