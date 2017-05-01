package org.cappmc.SNIPER722.capplogin.object;


import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by SNIPER722 on 8/10/2015.
 */
public class AuthRequest {

    private final ManagedChannel channel;
    private final CappcraftGrpc.CappcraftBlockingStub stub;

    public AuthRequest(ManagedChannel channel){
        this.channel = channel;
        stub = CappcraftGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public AuthResult validate(String player,String UUID)throws IOException {
        AuthResult result = new AuthResult();
        ValidateUserRequest request = ValidateUserRequest.newBuilder().setUsername(player).setUUID(UUID).build();
        ValidateUserResponse response;
        try{
            response = stub.validateUser(request);
            result.setResult(response.getCode()==1);
            result.setReason("§c"+response.getMessage());
        }catch (StatusRuntimeException e) {
            result.setResult(false);
            result.setReason("§eServer throws a StatusRuntimeException, Contact admin!");
        }

        return result;
    }

}
