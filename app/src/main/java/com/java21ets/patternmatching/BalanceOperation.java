package com.java21ets.patternmatching;


import java.io.Serializable;

public sealed interface BalanceOperation permits AddOperation, SubtractOperation, MultiplyOperation {
    int amount();
}

record AddOperation(int amount) implements BalanceOperation, Serializable { }

record SubtractOperation(int amount) implements BalanceOperation, Serializable { }

record MultiplyOperation(int amount) implements BalanceOperation, Serializable { }