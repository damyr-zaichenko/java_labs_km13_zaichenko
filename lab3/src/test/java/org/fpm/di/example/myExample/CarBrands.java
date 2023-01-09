package org.fpm.di.example.myExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CarBrands {
    private final Sedan sedan;
    private final Coupe coupe;
    private final SportsCar sportsCar;


    @Inject
    public CarBrands(Sedan sedan, Coupe coupe, SportsCar sportsCar) {
        this.sedan = sedan;
        this.coupe = coupe;
        this.sportsCar = sportsCar;
    }


    public Sedan getBootsBrand() {
        return sedan;
    }

    public Coupe getSneakersBrands() {
        return coupe;
    }

    public SportsCar getHighHeelBrand() {
        return sportsCar;
    }
}
