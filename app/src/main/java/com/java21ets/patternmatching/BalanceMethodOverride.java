package com.java21ets.patternmatching;

import java.util.List;

public class BalanceMethodOverride {
    private int currentBalance;

    public BalanceMethodOverride(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BalanceMethodOverride(List<BalanceOperationMethodOverride> operations) {
        operations.forEach(this::apply);
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public void apply(BalanceOperationMethodOverride operation) {
        this.currentBalance = operation.apply(this.currentBalance);
    }
}
