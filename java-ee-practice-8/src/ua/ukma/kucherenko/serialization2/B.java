package ua.ukma.kucherenko.serialization2;

import java.io.Serializable;

public class B implements Serializable {
    private final A objA;

    public B(A objA) {
        this.objA = objA;
        System.out.println("B constructor has been called");
    }

    public A getObjA() {
        return objA;
    }
}
