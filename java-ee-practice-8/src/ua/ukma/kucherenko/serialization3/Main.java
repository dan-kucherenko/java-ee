package ua.ukma.kucherenko.serialization3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        final String OUT_FILE_NAME = "object.ser";

        B objB = new B("Hello from B", 42);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(OUT_FILE_NAME))) {
            out.writeObject(objB);
            System.out.println("Object of class B serialized and saved to object.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(OUT_FILE_NAME))) {
            B newObjB = (B) in.readObject();
            System.out.println("Object of class B deserialized from object.ser");
            // Виведення інформації про об'єкт класу B після десеріалізації
            System.out.println("Message from deserialized object of class A: " + newObjB.getMessage());
            System.out.println("Number from deserialized object of class B: " + newObjB.getNumber());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
