package com.java21ets.patternmatching;

public sealed interface BalanceOperationMethodOverride permits AddOperationMethodOverride, SubtractOperationMethodOverride, MultiplyOperationMethodOverride {
    int amount();

    public int apply(int balance);
}

record AddOperationMethodOverride(int amount) implements BalanceOperationMethodOverride {
    @Override
    public int apply(int balance) {
        return balance + amount;
    }
}

record SubtractOperationMethodOverride(int amount) implements BalanceOperationMethodOverride {
    @Override
    public int apply(int balance) {
        return balance - amount;
    }
}

record MultiplyOperationMethodOverride(int amount) implements BalanceOperationMethodOverride {
    @Override
    public int apply(int balance) {
        return balance * amount;
    }
}


