package org.example;

public class CreditConditionTableModel extends TableModel {
    private Number id;
    private String name;
    private String period;
    private Number bet;
    private String currency;

    public CreditConditionTableModel(Number id, String name, String period, Number bet, String currency) {
        this.id = id;
        this.name = name;
        this.period = period;
        this.bet = bet;
        this.currency = currency;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Number getBet() {
        return bet;
    }

    public void setBet(Number bet) {
        this.bet = bet;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
