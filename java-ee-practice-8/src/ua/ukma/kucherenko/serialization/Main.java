package ua.ukma.kucherenko.serialization;

import ua.ukma.kucherenko.serialization.SerializableClass;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create a SerializableClass obj
        SerializableClass obj = new SerializableClass("TestObject");

        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream("object.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
            System.out.println("Object serialized and saved to object.ser");
        } catch(IOException i) {
            i.printStackTrace();
        }

        // Deserialization
        SerializableClass newObj = null;
        try(FileInputStream fileIn = new FileInputStream("object.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            newObj = (SerializableClass) in.readObject();
            System.out.println("Object deserialized from object.ser");
        } catch(IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }

        // Check whether the constructor has been called
        if (newObj != null) {
            System.out.println("Deserialized object name: " + newObj.getName());
        }
    }
}
