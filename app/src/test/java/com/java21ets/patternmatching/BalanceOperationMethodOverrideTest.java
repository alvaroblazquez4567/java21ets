package com.java21ets.patternmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceOperationMethodOverrideTest {

    @Test
    void testAddition() {
        BalanceMethodOverride balance = new BalanceMethodOverride(1000);
        BalanceOperationMethodOverride operation1 = new AddOperationMethodOverride(100);
        balance.apply(operation1);
        assertEquals(1100, balance.getCurrentBalance());
    }

    @Test
    void testSubtraction() {
        BalanceMethodOverride balance = new BalanceMethodOverride(1000);
        BalanceOperationMethodOverride operation1 = new SubtractOperationMethodOverride(100);
        balance.apply(operation1);
        assertEquals(900, balance.getCurrentBalance());

    }

    @Test
    void testAdditionAndSubtraction() {
        BalanceMethodOverride balance = new BalanceMethodOverride(1000);
        BalanceOperationMethodOverride operation1 = new AddOperationMethodOverride(100);
        BalanceOperationMethodOverride operation2 = new SubtractOperationMethodOverride(50);
        balance.apply(operation1);
        balance.apply(operation2);
        assertEquals(1050, balance.getCurrentBalance());
    }

    @Test
    void testMultiplication() {
        BalanceMethodOverride balance = new BalanceMethodOverride(1000);
        BalanceOperationMethodOverride operation1 = new MultiplyOperationMethodOverride(100);
        balance.apply(operation1);
        assertEquals(100000, balance.getCurrentBalance());
    }

    @Test
    void testBalanceRestoration() {
        List<BalanceOperationMethodOverride> operations = List.of(
                new AddOperationMethodOverride(100),
                new SubtractOperationMethodOverride(50),
                new MultiplyOperationMethodOverride(100)
        );

        BalanceMethodOverride balance = new BalanceMethodOverride(operations);

        assertEquals(5000, balance.getCurrentBalance());
    }

    @Test
    @DisplayName("Test balance restoration performance with 20.0000.000 operations and get the execution time")
    void testBalanceRestorationPerformance() {
        List<BalanceOperationMethodOverride> operations = new ArrayList<>(1000);

        for (int i = 0; i < 10_000_000; i++) {
            operations.add(new AddOperationMethodOverride(725));
        }

        for (int i = 0; i < 10_000_000; i++) {
            operations.add(new SubtractOperationMethodOverride(725));
        }

        Collections.shuffle(operations);

        long startTime = System.currentTimeMillis();
        BalanceMethodOverride balance = new BalanceMethodOverride(operations);
        long endTime = System.currentTimeMillis();

        System.out.println("Execution time: " + (endTime - startTime) + " ms");

        assertEquals(0, balance.getCurrentBalance());
    }

    @Test
    @DisplayName("Get the size in bytes of the serialized operation")
    void testSerializedOperationSize() {
        BalanceOperationMethodOverride operation = new AddOperationMethodOverride(100);
        byte[] serializedOperation = serializeBalance(operation);
        assertEquals( 90, serializedOperation.length);
    }

    @Test
    @DisplayName("Get the size in bytes of 100 serialized operation")
    void testSerializedOperationsSize() {
        List<BalanceOperationMethodOverride> operations = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            operations.add(new AddOperationMethodOverride(100));
        }

        byte[] serializedOperations = serializeBalances(operations);
        assertEquals(1134, serializedOperations.length);
    }

    byte[] serializeBalance(BalanceOperationMethodOverride operation) {
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

    byte[] serializeBalances(List<BalanceOperationMethodOverride> operations) {
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
}
