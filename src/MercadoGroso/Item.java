package MercadoGroso;

public class Item {
    private int itemCode;
    private int weight;

    public Item(int itemCode, int weight) {
        if(itemCode <= 0) throw new RuntimeException("Codigo invalido");
        this.itemCode = itemCode;
        this.weight = weight;
    }

    public int getItemCode() {
        return itemCode;
    }

    public int getWeight() {
        return weight;
    }
}
