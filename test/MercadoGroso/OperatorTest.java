package MercadoGroso;

import MercadoGroso.Vehicles.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {
    @Test
    public void loadVehicles() throws Exception {
        Item lightItem = new Item(2324, 340);
        Item mediumItem =new Item(504, 5000);
        Item heavyItem = new Item(123, 15300);
        Item heavyItem2 = new Item(890, 15300);

        MGSystem system = new MGSystem();

        system.addItem(lightItem);
        system.addItem(mediumItem);
        system.addItem(heavyItem);
        system.addItem(heavyItem2);

        Client lightClient = new Client(1, 123, system);
        Client mediumClient = new Client(2, 345, system);
        Client heavyClient = new Client(3, 345, system);
        Client heavyClient2 = new Client(4, 123, system);

        lightClient.buy(2324);
        mediumClient.buy(502);
        heavyClient.buy(123);
        heavyClient2.buy(890);

        Operator operator = new Operator(system);
        operator.loadVehicles();

        assertEquals(1, system.getMotorcycle().getPackages().size());
        assertEquals(1, system.getFlete().getPackages().size());
        assertEquals(2, system.getTruck().getPackages().size());
    }

}