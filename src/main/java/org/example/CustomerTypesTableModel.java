package org.example;

public class CustomerTypesTableModel extends TableModel {
    private String type;

    public CustomerTypesTableModel(String type) {

        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
