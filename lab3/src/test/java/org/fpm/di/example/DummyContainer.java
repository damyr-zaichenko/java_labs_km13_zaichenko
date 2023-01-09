package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class DummyContainer implements Container {
    private DummyBinder dummyBinder;

    public DummyContainer(DummyBinder dummyBinder){
        this.dummyBinder = dummyBinder;
    }
    @Override
    public <T> T getComponent(Class<T> clazz) {
        if(dummyBinder.impl.containsKey(clazz))
            return getComponent((Class<T>)dummyBinder.impl.get(clazz));
        if(dummyBinder.instance.containsKey(clazz))
            return (T)dummyBinder.instance.get(clazz);

        T type = null;

        Constructor<?>[] constructors = clazz.getConstructors();
        for(int i = 0; i < constructors.length; i++){
            if(constructors[i].isAnnotationPresent(Inject.class)){

                Object[] params = new Object[constructors[i].getParameters().length];

                for(int j = 0; j < params.length; j++){
                    params[j] = getComponent(constructors[i].getParameters()[j].getType());
                }

                try {
                    type = (T)constructors[i].newInstance(params);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }


        if(type == null){
            try {
                type = clazz.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if(clazz.isAnnotationPresent(Singleton.class)){
            dummyBinder.bind(clazz, type);
        }

        return type;
    }
}
