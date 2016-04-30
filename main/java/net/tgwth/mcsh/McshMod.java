package net.tgwth.mcsh;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = McshMod.MODID, name = McshMod.MODNAME, version = McshMod.MODVERSION)
public class McshMod
{
    public static final String MODID = "mcsh";
    public static final String MODNAME = "mcsh";
    public static final String MODVERSION = "1.0.0";
    
    @SidedProxy(clientSide = "net.tgwth.mcsh.ClientProxy")
    public static ClientProxy proxy;
    
    
    /**
     * @param event The event passed by Forge 
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }
    
    /**
     * @param event The event passed by Forge 
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }
    
    /**
     * @param event The event passed by Forge 
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
