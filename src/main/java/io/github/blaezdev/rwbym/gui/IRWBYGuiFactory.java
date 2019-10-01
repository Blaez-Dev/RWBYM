package io.github.blaezdev.rwbym.gui;

import io.github.blaezdev.rwbym.RWBYModels;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface IRWBYGuiFactory {

	public static <T extends IRWBYGuiFactory> T createInstance(Class<T> clazz, InventoryPlayer playerInv, ItemStack stack) {
		try {
			Constructor<T> constructor = clazz.getConstructor(InventoryPlayer.class, ItemStack.class);
			return constructor.newInstance(playerInv, stack);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			RWBYModels.LOGGER.log(Level.FATAL, "Unable to Create Gui Instance: {}", clazz);
			e.printStackTrace();
		}
		return null;
	}
	
}
