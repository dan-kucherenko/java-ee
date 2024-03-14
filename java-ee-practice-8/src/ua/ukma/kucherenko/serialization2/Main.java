package ua.ukma.kucherenko.serialization2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        final String OUT_FILE_NAME = "object.ser";

        A objA = new A("Hello from A");
        B objB = new B(objA);

        // Serialization of B obj
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(OUT_FILE_NAME))) {
            out.writeObject(objB);
            System.out.println("Object of class B serialized and saved to object.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Deserialization of B obj
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(OUT_FILE_NAME))) {
            B newObjB = (B) in.readObject();
            System.out.println("Object of class B deserialized from object.ser");

            System.out.println("Message from deserialized object of class A: " + newObjB.getObjA().getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
