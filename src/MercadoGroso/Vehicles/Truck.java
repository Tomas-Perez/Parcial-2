package MercadoGroso.Vehicles;
import MercadoGroso.MGPackage;
import MercadoGroso.MGSystem;

public class Truck extends Vehicle {

    public Truck(MGSystem system) {
        super(system);
    }

    @Override
    public boolean canCarry(MGPackage mgPackage) {
        return mgPackage.getWeight() > 10000;
    }

}
