package MercadoGroso;

public class Notice {

    private int itemCode;
    private int clientId;
    private boolean accepted;

    public Notice(int itemCode, int clientId, boolean accepted) {
        this.itemCode = itemCode;
        this.clientId = clientId;
        this.accepted = accepted;
    }

    public int getItemCode() {
        return itemCode;
    }

    public int getClientId() {
        return clientId;
    }

    public boolean wasAccepted() {
        return accepted;
    }

}
