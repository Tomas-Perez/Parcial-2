package MercadoGroso;

public class MGPackage {

    private Item Item;
    private int clientId;
    private int postalCode;

    public MGPackage(Item Item, int clientId, int postalCode) {
        this.Item = Item;
        this.clientId = clientId;
        this.postalCode = postalCode;
    }

    public Item getItem() {
        return Item;
    }

    public int getClientId() {
        return clientId;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getWeight(){
        return Item.getWeight() + 300;
    }
}
