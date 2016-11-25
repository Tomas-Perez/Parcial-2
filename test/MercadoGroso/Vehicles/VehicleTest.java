package MercadoGroso.Vehicles;

import MercadoGroso.Client;
import MercadoGroso.Item;
import MercadoGroso.MGPackage;
import MercadoGroso.MGSystem;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {


    Item lightItem = new Item(2324, 340);
    Item mediumItem =new Item(504, 5000);
    Item heavyItem = new Item(123, 15300);
    Item heavyItem2 = new Item(890, 15300);
    MGPackage lightPackage = new MGPackage(lightItem, 45, 342235);
    MGPackage mediumPackage = new MGPackage(mediumItem, 45, 342235);
    MGPackage heavyPackage = new MGPackage(heavyItem, 45, 342235);
    MGPackage heavyPackage2 = new MGPackage(heavyItem2, 45, 342235);

    @Test
    public void canCarry() throws Exception {
        MGSystem system = new MGSystem();
        Truck truck = new Truck(system);
        Flete flete = new Flete(system);
        Motorcycle motorcycle = new Motorcycle(system);
        assertFalse(motorcycle.canCarry(mediumPackage));
        assertFalse(motorcycle.canCarry(heavyPackage));
        assertTrue(motorcycle.canCarry(lightPackage));

        assertTrue(truck.canCarry(heavyPackage));
        assertFalse(truck.canCarry(mediumPackage));
        assertFalse(truck.canCarry(lightPackage));

        assertFalse(flete.canCarry(lightPackage));
        assertFalse(flete.canCarry(heavyPackage));
        assertTrue(flete.canCarry(mediumPackage));
    }

    @Test
    public void add() throws Exception {
        MGSystem system = new MGSystem();
        Truck truck = new Truck(system);
        truck.add(lightPackage);
        assertTrue(truck.getPackages().isEmpty());
        truck.add(heavyPackage);
        assertFalse(truck.getPackages().isEmpty());
    }

    @Test
    public void deliver() throws Exception {

        MGSystem system = new MGSystem();
        Truck truck = new Truck(system);
        Flete flete = new Flete(system);
        Client client = new Client(45, 342235, system);
        Motorcycle motorcycle = new Motorcycle(system);
        system.addItem(heavyItem2);
        system.addItem(heavyItem);
        truck.add(heavyPackage2);
        client.buy(123);
        truck.deliver();
        assertFalse(truck.getNotices().get(0).wasAccepted());
        truck.add(heavyPackage);
        truck.deliver();
        assertTrue(truck.getNotices().get(1).wasAccepted());
    }
}