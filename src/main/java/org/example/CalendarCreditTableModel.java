package org.example;

import java.util.Date;

public class CalendarCreditTableModel {
    public Number id;
    private Number credit;
    private Number payment;
    private Date date;

    public CalendarCreditTableModel(Number id, Date date, Number payment, Number credit) {
        this.id = id;
        this.date = date;
        this.payment = payment;
        this.credit = credit;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public Number getCredit() {
        return credit;
    }

    public void setCredit(Number credit) {
        this.credit = credit;
    }

    public Number getPayment() {
        return payment;
    }

    public void setPayment(Number payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
