package com.example.simpilecalculator;

import android.os.Parcelable;


import java.io.Serializable;
import java.util.Date;

public class Donation implements Serializable {

    int payment_method; // 1 for credit card and 2 for paypal
    double amount;
    String donation_date;
    String donation_currency;

    public String getDonation_currency() {
        return donation_currency;
    }

    public Donation(int payment_method, double amount, String donation_date, String c) {
        this.payment_method = payment_method;
        this.amount = amount;
        this.donation_date = donation_date;
        donation_currency = c;
    }

    String getPaymentMethodString(){
        return payment_method == 1 ? "Credit Card" : "PayPal";

    }
        public int getPayment_method() {
        return payment_method;
    }

    public double getAmount() {
        return amount;
    }

    public String getDonation_date() {
        return donation_date;
    }

}

//
//public class Donation implements Parcelable {
//
//    int payment_method; // 1 for credit card and 2 for paypal
//    double amount;
//    String donation_date;
//
//    public Donation(int payment_method, double amount, String donation_date) {
//        this.payment_method = payment_method;
//        this.amount = amount;
//        this.donation_date = donation_date;
//    }
//
//    public int getPayment_method() {
//        return payment_method;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public String getDonation_date() {
//        return donation_date;
//    }
//
//    @Override
//    public String toString() {
//        return "Donation{" +
//                "payment_method=" + payment_method +
//                ", amount=" + amount +
//                ", donation_date=" + donation_date +
//                '}';
//    }
//}
