package org.fpm.di.example.myExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Coupe {
    private final Mercedes mercedes;
    private final Сhevrolet сhevrolet;

    @Inject
    public Coupe(Mercedes mercedes, Сhevrolet сhevrolet){
        this.mercedes = mercedes;
        this.сhevrolet = сhevrolet;
    }

    public Mercedes getNike() {
        return mercedes;
    }

    public Сhevrolet getAdidas() {
        return сhevrolet;
    }
}
