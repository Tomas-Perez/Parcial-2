package MercadoGroso;

public class Client {

    private int id;
    private int postalCode;
    private MGSystem system;
    private int desiredItemCode;

    public Client(int id, int postalCode, MGSystem system) {
        this.id = id;
        this.postalCode = postalCode;
        this.system = system;
    }

    public int getId() {
        return id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void buy(int desiredItemCode){
        if(desiredItemCode <= 0) throw new RuntimeException("Codigo invalido");
        if(this.desiredItemCode == 0) {
            try {
                system.sell(desiredItemCode, this);
                this.desiredItemCode = desiredItemCode;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else throw new RuntimeException("Ya ordeno un paquete, espere a recibirlo");
    }

    public boolean receivePackage(MGPackage mgPackage) {
        if (mgPackage.getItem().getItemCode() == desiredItemCode){
            desiredItemCode = 0;
        return true;
        }
        return false;
    }
}
