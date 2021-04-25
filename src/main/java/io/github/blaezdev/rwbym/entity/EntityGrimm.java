package io.github.blaezdev.rwbym.entity;

import io.github.blaezdev.rwbym.capabilities.Predator.Predator;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityGrimm extends EntityMob implements IGrimm, Predator.IPrey
{
	public EntityGrimm(World worldIn) {
		super(worldIn);
	}
}
