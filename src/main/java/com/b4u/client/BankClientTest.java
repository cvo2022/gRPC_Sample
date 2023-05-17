package com.b4u.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.b4u.models.*;

public class BankClientTest {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 9000)
                .usePlaintext()
                .build();
        BankServiceGrpc.BankServiceBlockingStub blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);

        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(5).build();
        Balance balance = blockingStub.getBalance(balanceCheckRequest);
        System.out.println("Reiceived " + balance.getAmount());
    }
}
