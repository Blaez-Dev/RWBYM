package be.bluexin.rwbym;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class KeybindRegistry {
	@SideOnly(Side.CLIENT)
	public static KeyBinding activateSemblance = new KeyBinding("key.activatesemblance", Keyboard.KEY_G, "key.categories.RWBYM");
	public static KeyBinding cycleLevel = new KeyBinding("key.cyclelevel", Keyboard.KEY_H, "key.categories.RWBYM");


	public static void register() {
		ClientRegistry.registerKeyBinding(activateSemblance);
		ClientRegistry.registerKeyBinding(cycleLevel);
	}
}
