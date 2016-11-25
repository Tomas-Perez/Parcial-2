package MercadoGroso;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    @Test
    public void buy() throws Exception {
        MGSystem system = new MGSystem();
        system.addItem(new Item(2, 3444));
        Client client = new Client(23, 543534, system);
        client.buy(1);
        assertTrue(system.getPendingOrders().isEmpty());
        client.buy(2);
        assertFalse(system.getPendingOrders().isEmpty());
    }

}