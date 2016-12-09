package org.cappmc.SNIPER722.capplogin.handler;


import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import org.cappmc.SNIPER722.capplogin.reference.Reference;
import org.cappmc.SNIPER722.capplogin.reference.Settings;

import java.io.File;

/**
 * Created by SNIPER722 on 7/6/2015.
 */
public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File configFile){
        //create the confutation file object from the given configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadconfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            // Resync Configs
            loadconfiguration();
        }
    }

    private static void loadconfiguration(){
        // Why i have to dealer it first blame forge
        String[] templist = {"2","3"};
        Settings.enable = configuration.getBoolean("Enable", Configuration.CATEGORY_GENERAL, true, "This is the plugin control");
        Settings.url = configuration.getString("URL", Configuration.CATEGORY_GENERAL, "127.0.0.1", "This is the auth URL for verify the player");
        Settings.port = configuration.getInt("Port", Configuration.CATEGORY_GENERAL, 80, 0, 99999, "This is the port of verify server");
        Settings.debug = configuration.getBoolean("Debug", Configuration.CATEGORY_GENERAL, true, "This is the debug feature");
        if(configuration.hasChanged()){
            configuration.save();
        }
    }

}
