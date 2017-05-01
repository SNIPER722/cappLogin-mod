package org.cappmc.SNIPER722.capplogin.utiltity;

import com.google.gson.Gson;
import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.handler.ssl.SslContext;
import net.minecraft.entity.player.EntityPlayerMP;
import org.cappmc.SNIPER722.capplogin.object.AuthRequest;
import org.cappmc.SNIPER722.capplogin.object.AuthResult;
import org.cappmc.SNIPER722.capplogin.reference.Reference;
import org.cappmc.SNIPER722.capplogin.reference.Settings;

import javax.net.ssl.SSLException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * Created by SNIPER722 on 8/1/2015.
 */
public class AuthHelper {


    public AuthResult userAuth(EntityPlayerMP player){
        AuthResult result = new AuthResult();
        result.setResult(false);
        try {
            SslContext sslcon = GrpcSslContexts.forClient().trustManager(new ByteArrayInputStream(Reference.CERTIFICATION.getBytes(StandardCharsets.UTF_8))).build();
            //SslContext sslcon = GrpcSslContexts.forClient().trustManager(new File("config/CARoot.cer")).build();

            ManagedChannel channel = NettyChannelBuilder.forAddress(Settings.url, Settings.port).sslContext(sslcon).build();
            AuthRequest authRequest = new AuthRequest(channel);
            logHelper.debuginfo("Sent Auth Request for "+player.getDisplayName()+" ["+player.getUniqueID().toString()+"]");
            result = authRequest.validate(player.getDisplayName(),player.getUniqueID().toString());
            authRequest.shutdown();
        } catch (SSLException e) {
            result.setReason("§cServer throws a SSLException, Contact admin!");
            e.printStackTrace();
        } catch (IOException e) {
            result.setReason("§cServer throws an IOException, Contact admin!");
            e.printStackTrace();
        } catch (Exception e){
            result.setReason("§cServer throws a General Error, Contact admin!");
            e.printStackTrace();
        }


        return result;
    }

}
