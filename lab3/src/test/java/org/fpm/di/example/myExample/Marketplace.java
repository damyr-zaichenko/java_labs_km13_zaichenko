package org.fpm.di.example.myExample;

import javax.inject.Inject;

public class Marketplace {
    private final Garage garage;

    @Inject
    public Marketplace(Garage garage) {
        this.garage = garage;
    }


    public Garage getMarketplace() {
        return garage;
    }
}
