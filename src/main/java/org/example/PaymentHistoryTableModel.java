package org.example;

public class PaymentHistoryTableModel extends TableModel {
    private Number id;
    private Number amount;
    private String recipient;
    private Number bank_account;

    public PaymentHistoryTableModel(Number id, Number amount, String recipient, Number bank_account) {
        this.id = id;
        this.amount = amount;
        this.recipient = recipient;
        this.bank_account = bank_account;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Number getBank_account() {
        return bank_account;
    }

    public void setBank_account(Number bank_account) {
        this.bank_account = bank_account;
    }
}
