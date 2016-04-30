package net.tgwth.mcsh.gui;

import java.io.IOException;
import java.io.OutputStream;

public class McshOutputStream extends OutputStream {
	private GuiMcsh parent;
	private int maxLength = 8;

	public McshOutputStream(GuiMcsh parent) {
		this.parent = parent;
	}

	@Override
	public void write(int b) throws IOException {
        if(parent.history.size() == 0) {
	        parent.history.add("");
	    }
	    
	    if(b == '\n') {
            parent.history.add("");
        } else if(b == '\r') {
            //do nothing
        } else if(parent.history.getLast().length() >= maxLength) {
			parent.history.add(Character.toString((char)b));
		} else {
			parent.history.set(parent.history.size() - 1, parent.history.getLast() + Character.toString((char)b));
		}
	}
	
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
}
