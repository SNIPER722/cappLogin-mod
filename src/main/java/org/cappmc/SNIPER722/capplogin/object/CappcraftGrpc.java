package org.cappmc.SNIPER722.capplogin.object;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: Cappcraft.proto")
public final class CappcraftGrpc {

  private CappcraftGrpc() {}

  public static final String SERVICE_NAME = "Lu.McBox.Protos.Cappcraft";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ValidateUserRequest,
      ValidateUserResponse> METHOD_VALIDATE_USER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "Lu.McBox.Protos.Cappcraft", "ValidateUser"),
          io.grpc.protobuf.ProtoUtils.marshaller(ValidateUserRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(ValidateUserResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CappcraftStub newStub(io.grpc.Channel channel) {
    return new CappcraftStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CappcraftBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CappcraftBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static CappcraftFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CappcraftFutureStub(channel);
  }

  /**
   */
  public static abstract class CappcraftImplBase implements io.grpc.BindableService {

    /**
     */
    public void validateUser(ValidateUserRequest request,
        io.grpc.stub.StreamObserver<ValidateUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_VALIDATE_USER, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_VALIDATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                ValidateUserRequest,
                ValidateUserResponse>(
                  this, METHODID_VALIDATE_USER)))
          .build();
    }
  }

  /**
   */
  public static final class CappcraftStub extends io.grpc.stub.AbstractStub<CappcraftStub> {
    private CappcraftStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CappcraftStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CappcraftStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CappcraftStub(channel, callOptions);
    }

    /**
     */
    public void validateUser(ValidateUserRequest request,
        io.grpc.stub.StreamObserver<ValidateUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_VALIDATE_USER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CappcraftBlockingStub extends io.grpc.stub.AbstractStub<CappcraftBlockingStub> {
    private CappcraftBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CappcraftBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CappcraftBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CappcraftBlockingStub(channel, callOptions);
    }

    /**
     */
    public ValidateUserResponse validateUser(ValidateUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_VALIDATE_USER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CappcraftFutureStub extends io.grpc.stub.AbstractStub<CappcraftFutureStub> {
    private CappcraftFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CappcraftFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CappcraftFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CappcraftFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ValidateUserResponse> validateUser(
        ValidateUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_VALIDATE_USER, getCallOptions()), request);
    }
  }

  private static final int METHODID_VALIDATE_USER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CappcraftImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CappcraftImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VALIDATE_USER:
          serviceImpl.validateUser((ValidateUserRequest) request,
              (io.grpc.stub.StreamObserver<ValidateUserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CappcraftDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CappcraftOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CappcraftGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CappcraftDescriptorSupplier())
              .addMethod(METHOD_VALIDATE_USER)
              .build();
        }
      }
    }
    return result;
  }
}
