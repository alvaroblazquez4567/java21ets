package com.java21ets.patternmatching;

import java.io.Serializable;

public sealed interface BalanceOperationMethodOverride permits AddOperationMethodOverride, SubtractOperationMethodOverride, MultiplyOperationMethodOverride {
    int amount();

    public int apply(int balance);
}

record AddOperationMethodOverride(int amount) implements BalanceOperationMethodOverride, Serializable {
    @Override
    public int apply(int balance) {
        return balance + amount;
    }
}

record SubtractOperationMethodOverride(int amount) implements BalanceOperationMethodOverride, Serializable {
    @Override
    public int apply(int balance) {
        return balance - amount;
    }
}

record MultiplyOperationMethodOverride(int amount) implements BalanceOperationMethodOverride, Serializable {
    @Override
    public int apply(int balance) {
        return balance * amount;
    }
}


