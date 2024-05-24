package com.java21ets.recordpattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;


class PersonTest {

    @ParameterizedTest
    @DisplayName("A person should print different properties depending on if it is a student or a teacher")
    @ArgumentsSource(PersonArgumentsProvider.class)
    void testPersonProperties(Person person) {
        if(person instanceof Teacher(var name, var surname, var telephone, var specialty)) {
            Assertions.assertEquals("John", name);
            Assertions.assertEquals("Doe", surname);
            Assertions.assertEquals("123456789", telephone);
            Assertions.assertEquals("Java", specialty);
        }
        else if(person instanceof Student(var name, var surname, var telephone, var specialty)) {
            Assertions.assertEquals("Jane", name);
            Assertions.assertEquals("Smith", surname);
            Assertions.assertEquals("987654321", telephone);
            Assertions.assertEquals("Java", specialty);
        }
    }

    public static class PersonArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new Teacher("John", "Doe", "123456789", "Java")),
                    Arguments.of(new Student("Jane", "Smith", "987654321", "Java"))
            );
        }
    }

}