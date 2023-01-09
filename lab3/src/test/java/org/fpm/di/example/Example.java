package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Before;
import org.junit.Test;
import org.fpm.di.example.myExample.*;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void shouldBuildInInjectDep(){
        final Marketplace marketplace = container.getComponent(Marketplace.class);
        assertSame(marketplace.getMarketplace(), container.getComponent(CarDealer.class));
    }

    @Test
    public void shouldBuildInInjectDep2(){
        final CarDealer carDealer = container.getComponent(CarDealer.class);
        final CarDealer sCarDealer = container.getComponent(CarDealer.class);
        assertSame(carDealer, sCarDealer);
    }

    @Test
    public void shouldBuildInInjectDep3(){
        final CarDealer carDealer = container.getComponent(CarDealer.class);
        assertSame(container.getComponent(CarDealer.class), carDealer);
    }

    @Test
    public void shouldBuildInInjectDep4(){
        final CarDealer carDealer = container.getComponent(CarDealer.class);
        assertSame(container.getComponent(Garage.class), carDealer);
    }

    @Test
    public void shouldBuildingInInjectDep5(){
        final CarBrands carBrands = container.getComponent(CarBrands.class);
        assertSame(container.getComponent(Ford.class), carBrands.getHighHeelBrand());
    }

    @Test
    public void shouldBuildingInInjectDep6(){
        final CarBrands carBrands = container.getComponent(CarBrands.class);
        assertSame(carBrands.getBootsBrand().getNike(), carBrands.getSneakersBrands().getNike());
    }

    @Test
    public void shouldBuildingInInjectDep7(){
        final Brand brand = container.getComponent(Brand.class);
        final CarBrands carBrands = container.getComponent(CarBrands.class);

        assertSame(brand.getBootsBrand().getNike(), carBrands.getSneakersBrands().getNike());
    }
}
