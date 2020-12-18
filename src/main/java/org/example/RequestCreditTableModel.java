package org.example;

public class RequestCreditTableModel {
    private Number id;
    private Number loan_amount;
    private Number credit_condition;
    private Number TIN;

    public RequestCreditTableModel(Number id, Number loan_amount, Number credit_condition, Number TIN) {
        this.id = id;
        this.loan_amount = loan_amount;
        this.credit_condition = credit_condition;
        this.TIN = TIN;
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

    public Number getCredit_condition() {
        return credit_condition;
    }

    public void setCredit_condition(Number credit_condition) {
        this.credit_condition = credit_condition;
    }

    public Number getTIN() {
        return TIN;
    }

    public void setTIN(Number TIN) {
        this.TIN = TIN;
    }
}
