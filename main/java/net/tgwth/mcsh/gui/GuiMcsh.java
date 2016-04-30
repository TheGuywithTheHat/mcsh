package net.tgwth.mcsh.gui;

import java.io.IOException;
import java.util.LinkedList;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;

public class GuiMcsh extends GuiScreen {
	LinkedList<String> history;
	StringBuilder currentLine;
	
	
	public GuiMcsh() {
		history = new LinkedList<String>();
    	currentLine = new StringBuilder();
	}
	
	/**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    @Override
	public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
    }
    
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    @Override
	public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    drawDefaultBackground();
	    
	    for(int i = 0; i < history.size(); i++) {
	    	drawString(fontRendererObj, history.get(i), 100, 100 + fontRendererObj.FONT_HEIGHT * i, 0xFFDDDDDD);
	    }
	    
	    drawString(fontRendererObj, currentLine.toString(), 100, 100 + fontRendererObj.FONT_HEIGHT * history.size(), 0xFFDDDDDD);
	    
        super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	/**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    @Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        super.keyTyped(typedChar, keyCode);

        if(GuiScreen.isKeyComboCtrlV(keyCode)) {
        	insertText(GuiScreen.getClipboardString());
        } else {
            switch (keyCode) {
                case 14:
                    backspace();
                    break;
                case 28:
                case 156:
                	execute();
                    break;
                default:
                    if(ChatAllowedCharacters.isAllowedCharacter(typedChar)) {
                        insertText(Character.toString(typedChar));
                    }
            }
        }
    }
    
    private void execute() {
    	history.add(currentLine.toString());
    	currentLine = new StringBuilder();
    }
    
    private void insertText(String text) {
    	currentLine.append(text);
    }
    
    private void backspace() {
    	currentLine.deleteCharAt(currentLine.length() - 1);
    }
}
