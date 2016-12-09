package org.cappmc.SNIPER722.capplogin.utiltity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.io.IOException;
import java.util.*;
/**
 * Created by SNIPER722 on 8/1/2015.
 */
public class localInfoUtiltis {
    @SideOnly(Side.CLIENT)
    public static String getMachineUUID() throws IOException{
        Process process = Runtime.getRuntime().exec(new String[]{"wmic", "csproduct", "get", "uuid"});
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        logHelper.info(property + ": " + serial);
        return serial;
    }
}
