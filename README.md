# JAVA 21

## Records
Records are a new kind of type declaration in Java. They are a special kind of class that holds pure data. A record  
automatically has a final field for each component, a public constructor, and public read accessor methods.

```java
public record Point(int x, int y) {}
```

What this concise syntax is providing is:
* A concise syntax for the constructor declaration  
* A private final field for each component
* A public read accessor method for each component
e.g:
```java
Point p = new Point(1, 2);
System.out.println(p.x()); // 1
System.out.println(p.y()); // 2
```
* An implicit public equals method that compares the fields of two records
* An implicit public hashCode method that uses the fields of the record to compute the hash code
* An implicit public toString method that returns a string representation of the record

## Prove
* Record patterns and destructuring in instanceof
* Record patterns and destructuring in switch
* Switch expressions with records
* Exhaustiveness checking with switch expressions
* Sealed classes and interfaces
* Switch with guarded patterns
* Switch handling null

## Questions
* Why use pattern matching over inheritance and method overriding in the balance use case?

## Use cases
* Use when you do not own the class hierarchy in which implement method overrides