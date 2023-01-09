package org.fpm.di.example;

import org.fpm.di.Binder;

import java.util.ArrayList;
import java.util.HashMap;

public class DummyBinder implements Binder {
    public HashMap<Class<?>, Object> instance;
    public HashMap<Class<?>, Class<?>> impl;
    public ArrayList<Class<?>> classes;

    public DummyBinder(){
        instance = new HashMap<>();
        impl = new HashMap<>();
        classes = new ArrayList<>();
    }
    @Override
    public <T> void bind(Class<T> clazz) {
        classes.add(clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        impl.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        this.instance.put(clazz, instance);
    }
}
