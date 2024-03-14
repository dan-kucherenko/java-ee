package ua.ukma.kucherenko.serialization;

import java.io.*;

public class SerializableClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public SerializableClass(String name) {
        this.name = name;
        System.out.println("Constructor invoked with name: " + name);
    }

    public String getName() {
        return name;
    }
}
