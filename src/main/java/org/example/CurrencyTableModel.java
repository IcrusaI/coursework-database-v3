package org.example;

public class CurrencyTableModel extends TableModel {
    public String name;

    public CurrencyTableModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
