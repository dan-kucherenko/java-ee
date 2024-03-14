package ua.ukma.kucherenko;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Single call of foo()");
        // run foo() from static instance in singleton class
        SingletonClass.getInstance().foo();

        System.out.println("\nCalling foo() 5 times using reflection");
        List<SingletonClass> singletonList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SingletonClass instance = SingletonClass.getInstance();
            singletonList.add(instance);
        }

        for (SingletonClass instance : singletonList) {
            try {
                // reflection call of the foo method
                Method method = instance.getClass().getMethod("foo");
                method.invoke(instance);
            } catch (ReflectiveOperationException e) {
                System.err.println("Error invoking foo method: " + e.getMessage());
            }
        }
    }
}
