package ua.ukma.kucherenko.serialization3;

public class A {
    private final String message;

    public A(String message) {
        this.message = message;
        System.out.println("A constructor invoked with message: " + message);
    }

    public String getMessage() {
        return message;
    }
}
