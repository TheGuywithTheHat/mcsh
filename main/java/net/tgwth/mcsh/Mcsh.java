package net.tgwth.mcsh;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Mcsh.MODID, name = Mcsh.MODNAME, version = Mcsh.MODVERSION)
public class Mcsh
{
    public static final String MODID = "mcsh";
    public static final String MODNAME = "mcsh";
    public static final String MODVERSION = "1.0.0";
    

    @SidedProxy(clientSide = "com.treevamped.ClientProxy")
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
