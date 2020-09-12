package io.github.blaezdev.rwbym.weaponry.specialweapons.guns;

import java.util.List;

import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerADS;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerBolt;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerHammer;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerMag;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerShoot;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

public class ItemHecate extends ItemGun {
	
	public ItemHecate() {
		super();
		this.accuracy = 0;
		this.drift = 5f;
		this.spreadX = 1f;
		this.spreadY = 1f;
		this.ammo = () -> RWBYItems.Hecate50BMG;
		this.mag = () -> RWBYItems.HecateMag;
		this.casing = () -> Items.AIR;
	}

	@Override
	protected void getAnimationControllers() {
		animationControllers.add(new AnimationControllerADS());
		animationControllers.add(new AnimationControllerShoot(this, nbt -> nbt.getInteger("boltup") == 0));
		animationControllers.add(new AnimationControllerHammer(this, false));
		animationControllers.add(new AnimationControllerBolt());
		animationControllers.add(new AnimationControllerMag());
	}

//	@Override
//	public SoundEvent getShootSound() {
//		return Sound.RIFLE_SHOOT.getSound();
//	}

	@Override
	public float getDefaultZoomFactor(ItemStack stack) {
		return 0.1f;
	}

}
