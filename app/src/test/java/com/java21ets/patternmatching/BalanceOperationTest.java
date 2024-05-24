package com.java21ets.patternmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceOperationTest {

    @Test
    void testAddition() {
        Balance balance = new Balance(1000);
        BalanceOperation operation1 = new AddOperation(100);
        balance.apply(operation1);
        assertEquals(1100, balance.getCurrentBalance());
    }

    @Test
    void testSubtraction() {
        Balance balance = new Balance(1000);
        BalanceOperation operation1 = new SubtractOperation(100);
        balance.apply(operation1);
        assertEquals(900, balance.getCurrentBalance());
    }

    @Test
    void testAdditionAndSubtraction() {
        Balance balance = new Balance(1000);
        BalanceOperation operation1 = new AddOperation(100);
        BalanceOperation operation2 = new SubtractOperation(50);
        balance.apply(operation1);
        balance.apply(operation2);
        assertEquals(1050, balance.getCurrentBalance());
    }

    @Test
    void testMultiplication() {
        Balance balance = new Balance(1000);
        BalanceOperation operation1 = new MultiplyOperation(100);
        balance.apply(operation1);
        assertEquals(100000, balance.getCurrentBalance());
    }

    @Test
    void testBalanceRestoration() {
        List<BalanceOperation> operations = List.of(
                new AddOperation(100),
                new SubtractOperation(50),
                new MultiplyOperation(100)
        );

        Balance balance = new Balance(operations);

        assertEquals(5000, balance.getCurrentBalance());
    }

    @Test
    @DisplayName("Test balance restoration performance with 20.0000.000 operations and get the execution time")
    void testBalanceRestorationPerformance() {
        List<BalanceOperation> operations = new ArrayList<>(1000);

        for (int i = 0; i < 10_000_000; i++) {
            operations.add(new AddOperation(725));
        }

        for (int i = 0; i < 10_000_000; i++) {
            operations.add(new SubtractOperation(725));
        }

        Collections.shuffle(operations);

        long startTime = System.currentTimeMillis();
        Balance balance = new Balance(operations);
        long endTime = System.currentTimeMillis();

        System.out.println("Execution time: " + (endTime - startTime) + " ms");

        assertEquals(0, balance.getCurrentBalance());
    }

    @Test
    @DisplayName("Get the size in bytes of the serialized operation")
    void testSizeOfSerializedOperation() {
        BalanceOperation operation = new AddOperation(100);
        byte[] serializedOperation = serializeBalance(operation);
        assertEquals( 76, serializedOperation.length);
    }

    @Test
    @DisplayName("Get the size in bytes of 100 serialized operation")
    void testSizeOfSerializedOperations() {
        List<BalanceOperation> operations = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            operations.add(new AddOperation(100));
        }
        byte[] serializedOperations = serializeBalances(operations);
        assertEquals( 1120, serializedOperations.length);
    }


    private byte[] serializeBalances(List<BalanceOperation> operations) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(operations);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize operations", e);
        }
    }

    byte[] serializeBalance(BalanceOperation operation) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(operation);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize operation", e);
        }
    }
}
