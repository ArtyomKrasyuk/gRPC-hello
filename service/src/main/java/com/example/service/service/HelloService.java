package com.example.service.service;

import com.example.service.grpc.Hello;
import com.example.service.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(Hello.HelloRequest request, StreamObserver<Hello.HelloResponse> responseObserver) {
        Hello.HelloResponse response = Hello.HelloResponse.newBuilder().setGreeting("Hello " + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
