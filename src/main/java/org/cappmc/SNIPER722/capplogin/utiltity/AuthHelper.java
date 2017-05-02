package org.cappmc.SNIPER722.capplogin.utiltity;

import com.google.gson.Gson;
import net.minecraft.entity.player.EntityPlayerMP;
import org.cappmc.SNIPER722.capplogin.object.AuthRequest;
import org.cappmc.SNIPER722.capplogin.object.AuthResult;
import org.cappmc.SNIPER722.capplogin.reference.Settings;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by SNIPER722 on 8/1/2015.
 */
public class AuthHelper {
    public AuthResult userAuth(EntityPlayerMP player){
        AuthResult result = new AuthResult();
        String tempResult = "";
        Scanner inFromServer = null;
        PrintWriter outToServer = null;
        Gson gson = new Gson();
        try {
            // Open Socket to Server (IOException)
            Socket socketToServer = new Socket(Settings.url, Settings.port);
            logHelper.debuginfo("Server [" + Settings.url + ":" + Settings.port + "] connected");
            // Scanner to read from Stream
            inFromServer = new Scanner(socketToServer.getInputStream());
            // PrintWrite to send to Server
            outToServer = new PrintWriter(socketToServer.getOutputStream(), true);
            // format to JSON
            AuthRequest request = new AuthRequest(player.getDisplayName(),player.getUniqueID());
            //log the info
            logHelper.debuginfo("Sent: "+gson.toJson(request));
            //send info to Server
            outToServer.println(gson.toJson(request));
            //get Info from Server
            tempResult = inFromServer.nextLine();
            logHelper.debuginfo("Receive: " + tempResult);
            /***********************[Temp]*****************************/
            if(tempResult.equals("true")){
                result.setResult(true);
                result.setReason("null");
            }else{
                result.setResult(false);
                result.setReason("§cYou are not use the launcher we provided!");
            }
            /***********************[Temp]*****************************/
            //result = new Gson().fromJson(tempResult, AuthResult.class);
        }catch(IOException e){
            result.setResult(false);
            result.setReason("§cServer throws an IOException, Contact admin!");
            if(Settings.debug) {
                e.printStackTrace();
            }
        }catch(NoSuchElementException e){
            result.setResult(false);
            result.setReason("§eServer throws an NoSuchElementException, Contact admin!");
            if(Settings.debug) {
                e.printStackTrace();
            }
        }catch(Exception e){
            result.setResult(false);
            result.setReason("§cServer throws an generalException, Contact admin!");
            if(Settings.debug) {
                e.printStackTrace();
            }
        }finally {
            // closure
            if(inFromServer != null) {
                inFromServer.close();
            }
            if(outToServer !=null) {
                outToServer.close();
            }
        }
        return result;
    }
}
