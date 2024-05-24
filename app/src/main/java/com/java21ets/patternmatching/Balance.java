package com.java21ets.patternmatching;

import java.util.List;

public class Balance {

    private int currentBalance;

    public Balance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Balance(List<BalanceOperation> operations) {
        operations.forEach(this::apply);
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

    public void apply(BalanceOperation operation) {
        this.currentBalance = switch (operation) {
            case AddOperation(int amount) -> this.currentBalance + amount;
            case SubtractOperation(int amount) -> this.currentBalance - amount;
            case MultiplyOperation(int amount) -> this.currentBalance * amount;
        };
    }
}
