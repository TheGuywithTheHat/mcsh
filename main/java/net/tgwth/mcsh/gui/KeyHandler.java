package net.tgwth.mcsh.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyHandler {
	public KeyBinding mcshKey;
	
	public KeyHandler() {
		mcshKey = new KeyBinding("key.mcshkey", Keyboard.KEY_C, "key.categories.mcsh");
		ClientRegistry.registerKeyBinding(mcshKey);
	}
    
    /**
	 * @param event The event passed by Forge 
	 */
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(mcshKey.isPressed()) {
        	Minecraft.getMinecraft().displayGuiScreen(new GuiMcsh());
        }
    }
}
