package org.example;

import java.util.Date;

public class CreditHistoryTableModel {
    private Number id;
    private Number loan_amount;
    private Number remains;
    private Date expired;
    private String bank;
    private Number TIN;
    private Number repayment;
    private Number credit_condition;

    public CreditHistoryTableModel(Number id, Number loan_amount, Number remains, Date expired, String bank, Number TIN, Number repayment, Number credit_condition) {
        this.id = id;
        this.loan_amount = loan_amount;
        this.remains = remains;
        this.expired = expired;
        this.bank = bank;
        this.TIN = TIN;
        this.repayment = repayment;
        this.credit_condition = credit_condition;
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

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Number getTIN() {
        return TIN;
    }

    public void setTIN(Number TIN) {
        this.TIN = TIN;
    }

    public Number getRepayment() {
        return repayment;
    }

    public void setRepayment(Number repayment) {
        this.repayment = repayment;
    }

    public Number getCredit_condition() {
        return credit_condition;
    }

    public void setCredit_condition(Number credit_condition) {
        this.credit_condition = credit_condition;
    }
}
