package com.leryn.message.service;

import com.leryn.message.proto.HelloReply;
import com.leryn.message.proto.HelloRequest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@GrpcService
public class GrpcServerService {

  public void sayHello(final HelloRequest req, final StreamObserver<HelloReply> responseObserver) {
    final HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

}
