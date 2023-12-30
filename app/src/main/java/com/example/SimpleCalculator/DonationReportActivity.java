package com.example.simpilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DonationReportActivity extends AppCompatActivity {

    TextView reportText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_report);
       // String msg =  getIntent().getStringExtra("donation_report");
        Donation d = (Donation) getIntent().getSerializableExtra("donationObject");
        String paymentMethod = d.getPayment_method() == 1 ? "Credit Card" : "PayPal";

        String msg = "Thanks for your donation number " + (((MyApp)getApplication()).allDonations.size())  +
                " The amount is "+ d.getAmount() + d.getDonation_currency() +
                " The used payment method is " + paymentMethod + " On " + d.donation_date ;

        reportText = findViewById(R.id.reporttext);
        reportText.setText(msg);
    }
}