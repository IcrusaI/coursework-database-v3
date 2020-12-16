package org.example;

public class CustomersTableModel extends TableModel {
    private Number TIN;
    public String name;
    private String type;
    private Number revenue;

    public CustomersTableModel(Number TIN, String name, String type, Number revenue) {
        this.TIN = TIN;
        this.name = name;
        this.type = type;
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getTIN() {
        return TIN;
    }

    public void setTIN(Number TIN) {
        this.TIN = TIN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Number getRevenue() {
        return revenue;
    }

    public void setRevenue(Number revenue) {
        this.revenue = revenue;
    }
}
