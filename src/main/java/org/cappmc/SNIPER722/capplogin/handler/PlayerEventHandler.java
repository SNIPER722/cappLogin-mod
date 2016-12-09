package org.cappmc.SNIPER722.capplogin.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import org.cappmc.SNIPER722.capplogin.object.AuthResult;
import org.cappmc.SNIPER722.capplogin.utiltity.AuthHelper;
import org.cappmc.SNIPER722.capplogin.utiltity.logHelper;


/**
 * Created by SNIPER722 on 7/8/2015.
 */
public class PlayerEventHandler {

    @SubscribeEvent
    @SideOnly(Side.SERVER)
    public void playerAboutToJoin(FMLNetworkEvent.ServerConnectionFromClientEvent event){
        EntityPlayerMP player = ((NetHandlerPlayServer)event.handler).playerEntity;
        // log the connected player
        logHelper.debuginfo("Player Connected: "+player.getDisplayName());
        // go fot Auth
        AuthResult result = new AuthHelper().userAuth(player);
        logHelper.debuginfo("Result: "+result.toString());
        if(!result.getResult()){
            ((NetHandlerPlayServer) event.handler).kickPlayerFromServer(result.getReason());
            logHelper.debuginfo("Player: " + player.getDisplayName() + " Kicked");
            logHelper.debuginfo("Reason: " +result.getReason());
        }else{
            logHelper.debuginfo("Player: " + player.getDisplayName() + " Joined");
        }
    }
}
