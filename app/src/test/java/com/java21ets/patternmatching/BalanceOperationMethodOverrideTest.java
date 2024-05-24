package com.java21ets.patternmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Test balance restoration performance with 1000 operations and get the execution time")
    void testBalanceRestorationPerformance() {
        List<BalanceOperationMethodOverride> operations = new ArrayList<>(1000);

        for (int i = 0; i < 10000000; i++) {
            operations.add(new AddOperationMethodOverride(100));
        }

        for (int i = 0; i < 10000000; i++) {
            operations.add(new SubtractOperationMethodOverride(100));
        }

        Collections.shuffle(operations);

        long startTime = System.currentTimeMillis();
        BalanceMethodOverride balance = new BalanceMethodOverride(operations);
        long endTime = System.currentTimeMillis();

        assertEquals(0, balance.getCurrentBalance());
        System.out.println(balance.getCurrentBalance());
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }
}
