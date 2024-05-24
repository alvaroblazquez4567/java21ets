package com.java21ets.whenguards;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    @Test
    @DisplayName("Categorize a large red circle. It should be red and with a radius >= 10.")
    void categorizeLargeRedCircle() {
        Shape circle = new Circle(10, "red");
        assertEquals("large red circle", Categorizer.categorize(circle));
    }

    @Test
    @DisplayName("Categorize a small circle. Its radius is less than 5.")
    void categorizeSmallCircle() {
        Shape circle = new Circle(4, "blue");
        assertEquals("small circle", Categorizer.categorize(circle));
    }

    @Test
    @DisplayName("Categorize a blue square. Its color is blue and its width and height are equal.")
    void categorizeBlueSquare() {
        Shape rectangle = new Rectangle(5, 5, "blue");
        assertEquals("blue square", Categorizer.categorize(rectangle));
    }

    @Test
    @DisplayName("Categorize a green rectangle. Its color should be green.")
    void categorizeGreenRectangle() {
        Shape rectangle = new Rectangle(5, 10, "green");
        assertEquals("green rectangle", Categorizer.categorize(rectangle));
    }

    @Test
    @DisplayName("Report unknown circle for all other kinds of circle.")
    void categorizeUnknownCircle() {
        Shape circle = new Circle(5, "green");
        assertEquals("unknown circle", Categorizer.categorize(circle));
    }

    @Test
    @DisplayName("Report unknown rectangle for all other kinds of rectangle.")
    void categorizeUnknownRectangle() {
        Shape rectangle = new Rectangle(5, 10, "red");
        assertEquals("unknown rectangle", Categorizer.categorize(rectangle));
    }

    @Test
    @DisplayName("Categorize should handle null gracefully")
    void categorizeNull() {
        assertEquals("null value", Categorizer.categorize(null));
    }
}
