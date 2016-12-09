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
                result.setReason("Auth Falied");
            }
            /***********************[Temp]*****************************/
            //result = new Gson().fromJson(tempResult, AuthResult.class);
        }catch(IOException e){
            result.setResult(false);
            result.setReason("§c登陆系统出现读取故障,请联系管理员解决");
        }catch(NoSuchElementException e){
            result.setResult(false);
            result.setReason("§e登陆服务器没有响应,请联系管理员解决");
        }catch(Exception e){
            result.setResult(false);
            result.setReason("§c登陆系统出现未知故障,请联系管理员解决");
            e.printStackTrace();
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
