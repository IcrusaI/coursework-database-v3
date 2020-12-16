package org.example;

public class BankAccountTableModel {
    public Number id;
    public Number quantity;
    public Number TIN;

    BankAccountTableModel(Number id, Number quantity, Number TIN) {
        this.id = id;
        this.quantity = quantity;
        this.TIN = TIN;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Number getTIN() {
        return TIN;
    }

    public void setTIN(Number TIN) {
        this.TIN = TIN;
    }
}
