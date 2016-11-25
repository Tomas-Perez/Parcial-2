package MercadoGroso.Vehicles;
import MercadoGroso.*;
import java.util.ArrayList;

public abstract class Vehicle {

    private MGSystem system;
    private ArrayList<MGPackage> packages = new ArrayList<>();
    private ArrayList<Notice> notices = new ArrayList<>();

    public Vehicle(MGSystem system) {
        this.system = system;
    }

    public abstract boolean canCarry(MGPackage mgPackage);

    public void add(MGPackage mgPackage){
        if(canCarry(mgPackage)) packages.add(mgPackage);
    }

    public void deliver(){
        for (int i = 0; i<packages.size(); i++){
            for (Client client : system.getClients()) {
                if (client.getPostalCode() == packages.get(i).getPostalCode() && client.getId() == packages.get(i).getClientId()) {
                    if (client.receivePackage(packages.get(i))) {
                        notices.add(new Notice(packages.get(i).getItem().getItemCode(), client.getId(), true));
                    }
                    else notices.add(new Notice(packages.get(i).getItem().getItemCode(), client.getId(), false));
                }
            }
            packages.remove(packages.get(i));
        }
    }

    public ArrayList<MGPackage> getPackages() {
        return packages;
    }

    public ArrayList<Notice> getNotices() {
        return notices;
    }
}
