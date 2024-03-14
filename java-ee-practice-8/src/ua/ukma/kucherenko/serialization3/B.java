package ua.ukma.kucherenko.serialization3;

import java.io.Serializable;

public class B extends A implements Serializable {
    private final int number;

    public B(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
