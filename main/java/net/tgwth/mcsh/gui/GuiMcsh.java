package net.tgwth.mcsh.gui;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;

public class GuiMcsh extends GuiScreen {
    LinkedList<String> history;
    PrintStream out;
    McshOutputStream mcOut;
    
    StringBuilder currentLine;
    /** How far from the end of the line the cursor is. */
    int cursorPos;
    
    public GuiMcsh() {
        history = new LinkedList<String>();
        mcOut = new McshOutputStream(this);
        out = new PrintStream(mcOut, true);
        
        currentLine = new StringBuilder();
        cursorPos = 0;
    }
    
    /**
     * Adds the buttons (and other controls) to the screen in question. Called
     * when the GUI is displayed and when the window resizes, the buttonList is
     * cleared beforehand.
     */
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        mcOut.setMaxLength(Math.max(width / 16, 8));
    }
    
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat
     * events
     */
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        
        for(int i = 0; i < history.size(); i++) {
            drawString(fontRendererObj, history.get(i), 100, 50 + fontRendererObj.FONT_HEIGHT * i, 0xFFDDDDDD);
        }
        
        drawString(fontRendererObj, "> " + currentLine, 100, 50 + fontRendererObj.FONT_HEIGHT * (history.size() - 1),
                0xFFDDDDDD);
                
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is
     * the equivalent of KeyListener.keyTyped(KeyEvent e). Args : character
     * (character on the key), keyCode (lwjgl Keyboard key code)
     */
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        System.out.println(typedChar + ", " + keyCode);
        super.keyTyped(typedChar, keyCode);
        
        if(GuiScreen.isKeyComboCtrlV(keyCode)) {
            insertText(GuiScreen.getClipboardString());
        } else {
            switch(keyCode) {
            case 14:
                backspace();
                break;
            case 28:
            case 156:
                execute();
                break;
            case 203:
                if(cursorPos < currentLine.length()) {
                    cursorPos++;
                }
                break;
            case 205:
                if(cursorPos > 0) {
                    cursorPos--;
                }
                break;
            default:
                if(ChatAllowedCharacters.isAllowedCharacter(typedChar)) {
                    insertText(Character.toString(typedChar));
                }
            }
        }
    }
    
    private void execute() {
        out.println("> " + currentLine);
        currentLine = new StringBuilder();
        cursorPos = 0;
    }
    
    private void insertText(String text) {
        currentLine.insert(currentLine.length() - cursorPos, text);
    }
    
    private void backspace() {
        if(currentLine.length() > 0) {
            currentLine.deleteCharAt(currentLine.length() - 1 - cursorPos);
        }
    }
}
