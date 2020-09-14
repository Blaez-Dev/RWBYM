package io.github.blaezdev.rwbym.weaponry.specialweapons.bullets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import io.github.blaezdev.rwbym.Init.RWBYCreativeTabs;
import io.github.blaezdev.rwbym.utility.RWBYConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class ItemBullet extends Item {
		
	protected final RandomQueue nextRandA = new RandomQueue();
	protected final RandomQueue nextRandB = new RandomQueue();
	
	protected final Supplier<Item> casing;

	public ItemBullet(Supplier<Item> casing) {
		super();
		this.setCreativeTab(RWBYCreativeTabs.tab_rwbyitems);
		this.casing = casing;
		nextRandA.push();
		nextRandB.push();
	}
	
	public Item getCasing() {
		return casing == null ? null : casing.get();
	}
	
	public abstract void fire(World world, EntityPlayer player, float entityAccuracy, float gunAccuracy, int life);
	
	public abstract Vec3d getPredictorLine(int index, EntityPlayer player, float entityAccuracy, float gunAccuracy);
	public abstract Vec3d getPredictorLine(int index, EntityPlayer player, float partialTicks, float entityAccuracy, float gunAccuracy);
	
	protected class RandomQueue {
		
		private final Random rand = new Random();
		
		private final List<Double> randomNumbers = new ArrayList<>();
		
		public double get(int index) {
			if (index >= randomNumbers.size()) {
				push();
			}
			return randomNumbers.get(index);
		}
		
		public void push() {
			while (randomNumbers.size() <= RWBYConfig.general.maxBulletLines) {
				randomNumbers.add(rand.nextDouble());
			}
			while (randomNumbers.size() > RWBYConfig.general.maxBulletLines) {
				randomNumbers.remove(0);
			}
		}
		
		public double get() {
			double d = get(0);
			push();
			return d;
		}
		
	}


}
