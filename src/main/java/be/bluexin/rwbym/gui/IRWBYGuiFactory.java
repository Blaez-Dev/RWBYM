package be.bluexin.rwbym.gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.Level;

import be.bluexin.rwbym.RWBYModels;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public interface IRWBYGuiFactory {

	public static <T extends IRWBYGuiFactory> T createInstance(Class<T> clazz, InventoryPlayer playerInv, ItemStack stack) {
		try {
			Constructor<T> constructor = clazz.getConstructor(playerInv.getClass(), stack.getClass());
			return constructor.newInstance(playerInv, stack);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			RWBYModels.LOGGER.log(Level.FATAL, "Unable to Create Gui Instance {}", clazz);
		}
		return null;
	}
	
}
