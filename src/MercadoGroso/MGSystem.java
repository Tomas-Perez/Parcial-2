package MercadoGroso;

import MercadoGroso.Comparators.IDComparator;
import MercadoGroso.Comparators.PostalCodeComparator;
import MercadoGroso.Comparators.WeightComparator;
import MercadoGroso.Vehicles.Flete;
import MercadoGroso.Vehicles.Motorcycle;
import MercadoGroso.Vehicles.Truck;
import MercadoGroso.Vehicles.Vehicle;

import java.util.ArrayList;

public class MGSystem {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<MGPackage> pendingOrders = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public MGSystem() {
        vehicles.add(new Motorcycle(this));
        vehicles.add(new Flete(this));
        vehicles.add(new Truck(this));
    }

    public void sell(int itemCode, Client client){
        for (Item item: items) {
            if(item.getItemCode() == itemCode){
                MGPackage mgPackage = new MGPackage(item, client.getId(), client.getPostalCode());
                pendingOrders.add(mgPackage);
                clients.add(client);
                return;
            }
        }
        throw new RuntimeException("Item desconocido");
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<MGPackage> getPendingOrders() {
        return pendingOrders;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void sortOrdersByPC(){
        pendingOrders.sort(new PostalCodeComparator());
    }

    public void sortOrdersByWeight(){
        pendingOrders.sort(new WeightComparator());
    }

    public void sortOrdersByID(){
        pendingOrders.sort(new IDComparator());
    }

    public Truck getTruck(){
        return (Truck) vehicles.get(2);
    }

    public Flete getFlete(){
        return (Flete) vehicles.get(1);
    }

    public Motorcycle getMotorcycle(){
        return (Motorcycle) vehicles.get(0);
    }
}
