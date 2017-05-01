package org.cappmc.SNIPER722.capplogin;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import org.cappmc.SNIPER722.capplogin.handler.ConfigurationHandler;
import org.cappmc.SNIPER722.capplogin.handler.PlayerEventHandler;
import org.cappmc.SNIPER722.capplogin.proxy.IProxy;
import org.cappmc.SNIPER722.capplogin.reference.Reference;

@Mod(modid = Reference.MOD_ID ,name=Reference.MOD_NAME ,version=Reference.VERSION,acceptableRemoteVersions="*")
public class CappLogin {

    @Mod.Instance(Reference.MOD_ID)
    public static CappLogin instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        FMLCommonHandler.instance().bus().register(new PlayerEventHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
    }





}
