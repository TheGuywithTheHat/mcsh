package net.tgwth.mcsh;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tgwth.mcsh.gui.KeyHandler;

@SideOnly(Side.CLIENT)
public class ClientProxy {
	
    public void preInit() {
    	MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }
    
    public void init() {
    	//
    }
    
    public void postInit() {
        //
    }
}
