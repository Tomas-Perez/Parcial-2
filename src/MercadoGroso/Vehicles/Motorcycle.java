package MercadoGroso.Vehicles;

import MercadoGroso.MGPackage;
import MercadoGroso.MGSystem;

public class Motorcycle extends Vehicle {

    public Motorcycle(MGSystem system) {
        super(system);
    }

    @Override
    public boolean canCarry(MGPackage mgPackage) {
        return mgPackage.getWeight() <= 1000;
    }
}
