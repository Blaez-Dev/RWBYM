package io.github.blaezdev.rwbym.weaponry.specialweapons;

import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.util.ResourceLocation;

public class ItemPropertyWrapper {

	private final ResourceLocation name;
	private final IItemPropertyGetter override;
	
	public ItemPropertyWrapper(String name, IItemPropertyGetter override) {
		this.name = new ResourceLocation(name);
		this.override = override;
	}

	public ResourceLocation getName() {
		return name;
	}
	
	public IItemPropertyGetter getOverride() {
		return override;
	}
	
}
