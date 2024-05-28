package com.java21ets.whenguards;

public sealed interface Shape permits Circle, Rectangle {
}

record Circle(double radius, String color) implements Shape { }

record Rectangle(double width, double height, String color) implements Shape { }
