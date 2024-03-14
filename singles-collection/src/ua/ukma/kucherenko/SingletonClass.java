package ua.ukma.kucherenko;

public class SingletonClass {
    private static SingletonClass instance = null;

    private SingletonClass(){}

    public static SingletonClass getInstance() {
        return (instance == null) ? instance = new SingletonClass() : instance;
    }

    public void foo() {
        System.out.println("Non-static method foo() has been called");
    }
}
