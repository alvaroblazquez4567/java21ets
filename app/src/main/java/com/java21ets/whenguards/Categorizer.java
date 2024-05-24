package com.java21ets.whenguards;

public class Categorizer {

    private Categorizer() {}

    public static String categorize(Shape shape) {
        return switch (shape) {
            case Circle(double radius, String color) when radius >= 10 && color.equals("red") -> "large red circle";
            case Circle(double radius, String color) when radius < 5 -> "small circle";
            case Rectangle(double width, double height, String color) when width == height && color.equals("blue") -> "blue square";
            case Rectangle(var width, var height, String color) when color.equals("green") -> "green rectangle";
            case Circle circle -> "unknown circle";
            case Rectangle rectangle -> "unknown rectangle";
            case null -> "null value";
        };
    }
}
