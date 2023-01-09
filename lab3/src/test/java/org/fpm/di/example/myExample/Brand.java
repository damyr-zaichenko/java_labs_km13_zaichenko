package org.fpm.di.example.myExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Brand {
    private final Sedan sedan;

    @Inject
    public Brand(Sedan sedan) {
        this.sedan = sedan;
    }

    public Sedan getBootsBrand() {
        return sedan;
    }
}
