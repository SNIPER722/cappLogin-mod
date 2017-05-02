package org.cappmc.SNIPER722.capplogin.object;

import java.util.UUID;

/**
 * Created by SNIPER722 on 8/10/2015.
 */
public class AuthRequest {
    private final String Action = "Server_OnlineCheck";
    private String Target = "";
    private UUID UUID = null;
    private String IP = "";

    public AuthRequest(){

    }
    public AuthRequest(String name,UUID uid){
        Target = name;
        UUID = uid;
    }

    public AuthRequest(String name,UUID uid,String address){
        Target = name;
        UUID = uid;
        IP = address;
    }

    public String getName(){
        return Target;
    }

    public String getUUID(){
        return UUID.toString();
    }

    public String getIP(){
        return IP;
    }

    // for GSON toJson
    @Override
    public String toString(){
        return "AuthRequest [Action="+Action+",Target="+Target+",UUID="+UUID.toString()+", IP="+IP+"]";
    }

}
