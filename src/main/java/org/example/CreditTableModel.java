package org.example;

public class CreditTableModel extends TableModel {
    private Number id;
    private Number loan_amount;
    private Number remains;
    private Number credit_condition;
    private Number bank_account;

    public CreditTableModel(Number id, Number loan_amount, Number remains, Number credit_condition, Number bank_account) {
        this.id = id;
        this.loan_amount = loan_amount;
        this.remains = remains;
        this.credit_condition = credit_condition;
        this.bank_account = bank_account;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public Number getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(Number loan_amount) {
        this.loan_amount = loan_amount;
    }

    public Number getRemains() {
        return remains;
    }

    public void setRemains(Number remains) {
        this.remains = remains;
    }

    public Number getCredit_condition() {
        return credit_condition;
    }

    public void setCredit_condition(Number credit_condition) {
        this.credit_condition = credit_condition;
    }

    public Number getBank_account() {
        return bank_account;
    }

    public void setBank_account(Number bank_account) {
        this.bank_account = bank_account;
    }
}
