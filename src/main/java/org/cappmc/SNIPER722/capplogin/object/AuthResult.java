package org.cappmc.SNIPER722.capplogin.object;

/**
 * Created by SNIPER722 on 8/10/2015.
 */
public class AuthResult {
    private boolean result = false;
    private String reason = null;

    public AuthResult(){
        result = false;
        reason = "NOT SET";
    }

    public boolean getResult(){
        return result;
    }
    public void setResult(final boolean key){result = key;}
    public String getReason(){
        return reason;
    }
    public void setReason(final String r){reason = r;}

    @Override
    public String toString(){
        return "AuthResult [result=" + result + ", reason=" + reason + "]";
    }
}
