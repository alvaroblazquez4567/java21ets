package com.java21ets.patternmatching;


public sealed interface BalanceOperation permits AddOperation, SubtractOperation, MultiplyOperation {
    int amount();
}

record AddOperation(int amount) implements BalanceOperation { }

record SubtractOperation(int amount) implements BalanceOperation { }

record MultiplyOperation(int amount) implements BalanceOperation { }