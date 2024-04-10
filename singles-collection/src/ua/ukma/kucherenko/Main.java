package ua.ukma.kucherenko;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("Single call of foo()");
        // run foo() from static instance in singleton class
        SingletonClass.getInstance().foo();

        System.out.println("\nCalling foo() 5 times using reflection");
        List<SingletonClass> singletonList = new ArrayList<>();
        try {
            Constructor<SingletonClass> constructor = SingletonClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            for (int i = 0; i < 5; i++) {
                SingletonClass singletonObj = constructor.newInstance();
                singletonList.add(singletonObj);
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        for (SingletonClass instance : singletonList) {
            // reflection call of the foo method
            System.out.println(instance.hashCode());
            instance.foo();
        }
    }
}
