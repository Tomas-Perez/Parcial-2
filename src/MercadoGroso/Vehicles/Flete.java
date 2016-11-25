package MercadoGroso.Vehicles;

import MercadoGroso.MGPackage;
import MercadoGroso.MGSystem;

public class Flete extends Vehicle {

    public Flete(MGSystem system) {
        super(system);
    }

    @Override
    public boolean canCarry(MGPackage mgPackage) {
        return mgPackage.getWeight() > 1000 && mgPackage.getWeight() <= 10000;
    }
}
