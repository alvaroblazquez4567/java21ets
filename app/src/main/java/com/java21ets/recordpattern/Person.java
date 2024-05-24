package com.java21ets.recordpattern;

public interface Person { }

record Student(String name, String surname, String telephone, String course) implements Person { }

record Teacher(String name, String surname, String telephone, String specialty) implements Person { }