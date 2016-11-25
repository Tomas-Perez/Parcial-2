package MercadoGroso;

import MercadoGroso.Vehicles.Vehicle;

public class Operator {

    private MGSystem system;

    public Operator(MGSystem system) {
        this.system = system;
    }

    public void loadVehicles(){
        for (Vehicle vehicle: system.getVehicles()) {
            for (MGPackage aPackage: system.getPendingOrders()) {
                if(vehicle.canCarry(aPackage)) {
                    vehicle.add(aPackage);
                    system.getPendingOrders().remove(aPackage);
                    break;
                }
            }
        }
    }
}
