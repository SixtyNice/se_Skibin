package sef.module15.sample;

public class MyClass<T> {
    private T x;

    <X> MyClass(T x) {
        this.x = x;
    }
}
