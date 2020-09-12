package io.github.blaezdev.rwbym.weaponry.specialweapons.guns;

import io.github.blaezdev.rwbym.Init.RWBYItems;
import io.github.blaezdev.rwbym.RWBYSoundHandler.Sound;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerADS;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerFireSelect;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerHammer;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerMag;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerShoot;
import io.github.blaezdev.rwbym.weaponry.specialweapons.animations.AnimationControllerSlide;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

public class ItemP90 extends ItemGun {
	
	public ItemP90() {
		accuracy = 1f;
		drift = 0.2f;
		spreadX = 0.2f;
		spreadY = 0.1f;
		mag = () -> RWBYItems.P90Mag;
		ammo = () -> RWBYItems.P90Bullet;
		casing = () -> Items.AIR;
	}

	@Override
	protected void getAnimationControllers() {
        this.animationControllers.add(new AnimationControllerShoot(this, nbt -> !nbt.getBoolean("AutoSlideLock")));
        this.animationControllers.add(new AnimationControllerADS());
        this.animationControllers.add(new AnimationControllerFireSelect(this, AnimationControllerFireSelect.Modes.SEMI, AnimationControllerFireSelect.Modes.AUTO));
        this.animationControllers.add(new AnimationControllerSlide(this, false));
        this.animationControllers.add(new AnimationControllerMag());
        this.animationControllers.add(new AnimationControllerHammer(this, false));
	}

//	@Override
//	public SoundEvent getShootSound() {
//		return Sound.STORMFLOWER_SHOOT.getSound();
//	}

	@Override
	public float getDefaultZoomFactor(ItemStack stack) {
		return 0.9f;
	}

}
