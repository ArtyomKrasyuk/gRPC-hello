package com.example.gateway.service;

import com.example.service.grpc.Hello;
import com.example.service.grpc.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloClientService {

    @GrpcClient("hello")
    private HelloServiceGrpc.HelloServiceBlockingStub stub;

    public String sayHello(String name){
        Hello.HelloRequest request = Hello.HelloRequest.newBuilder().setName(name).build();
        Hello.HelloResponse response = stub.sayHello(request);
        return response.getGreeting();
    }
}
