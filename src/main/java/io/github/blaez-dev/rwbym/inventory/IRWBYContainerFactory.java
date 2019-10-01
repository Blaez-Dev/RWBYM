package io.github.blaez-dev.rwbym.inventory;

import io.github.blaez-dev.rwbym.RWBYModels;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface IRWBYContainerFactory {
	
	public static <T extends IRWBYContainerFactory> T createInstance(Class<T> clazz, IInventory playerInv, ItemStack stack) {
		try {
			Constructor<T> constructor = clazz.getConstructor(IInventory.class, ItemStack.class);
			return constructor.newInstance(playerInv, stack);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			RWBYModels.LOGGER.log(Level.FATAL, "Unable to Create Container Instance: {}", clazz);
			e.printStackTrace();
		}
		return null;
	}
	
}
