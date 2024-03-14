package ua.ukma.kucherenko.serialization2;

import java.io.Serializable;

public class A implements Serializable {
    private final String message;

    public A(String message) {
        this.message = message;
        System.out.println("A constructor invoked with message: " + message);
    }

    public String getMessage() {
        return message;
    }
}
