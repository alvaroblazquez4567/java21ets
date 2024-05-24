package com.java21ets.records;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    @DisplayName("A person should have name, surname and telephone properties")
    void testPersonProperties() {
        Person classUnderTest = new Person("John", "Doe", "123456789");
        Assertions.assertEquals("John", classUnderTest.name());
        Assertions.assertEquals("Doe", classUnderTest.surname());
        Assertions.assertEquals("123456789", classUnderTest.telephone());
    }

    @Test
    @DisplayName("A person should be equal to another person with the same name, surname and telephone")
    void testPersonEquality() {
        Person person1 = new Person("John", "Doe", "123456789");
        Person person2 = new Person("John", "Doe", "123456789");
        Assertions.assertEquals(person1, person2);
    }

    @Test
    @DisplayName("A person should have the same hash code as another person with the same name, surname and telephone")
    void testPersonHashCode() {
        Person person1 = new Person("John", "Doe", "123456789");
        Person person2 = new Person("John", "Doe", "123456789");
        Assertions.assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    @DisplayName("A person should have a string representation with name, surname and telephone")
    void testPersonToString() {
        Person classUnderTest = new Person("John", "Doe", "123456789");
        assertEquals("Person[name=John, surname=Doe, telephone=123456789]", classUnderTest.toString());
    }

}
