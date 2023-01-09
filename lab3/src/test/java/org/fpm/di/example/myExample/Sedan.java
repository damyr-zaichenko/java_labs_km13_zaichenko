package org.fpm.di.example.myExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Sedan {
    private final Nissan nissan;
    private final Mercedes mercedes;

    @Inject
    public Sedan(Nissan nissan, Mercedes mercedes){
        this.nissan = nissan;
        this.mercedes = mercedes;
    }

    public Nissan getTnf() {
        return nissan;
    }

    public Mercedes getNike() {
        return mercedes;
    }
}
