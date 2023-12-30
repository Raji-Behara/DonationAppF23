package com.example.SimpleCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.time.Duration;
import java.util.ArrayList;

public class DonationList extends AppCompatActivity {

    ListView donationlist;
    ArrayList<Donation> listOfDonations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);
        donationlist = findViewById(R.id.donation_list); // Adapter View

        //listOfDonations = ((MyApp)getApplication()).allDonations;
        listOfDonations = (ArrayList<Donation>) getIntent().getSerializableExtra("list"); // Donation ArrayList

        // Donation Base Adapter
        DonationsBaseAdapter donationsBaseAdapter =
                new DonationsBaseAdapter(listOfDonations, this);

        donationlist.setAdapter(donationsBaseAdapter);
        donationlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = "The amout of this donation is "+ listOfDonations.get(i).getAmount() + listOfDonations.get(i).getDonation_currency();
                Toast.makeText(DonationList.this ,s , Toast.LENGTH_LONG).show();
            }
        });

    }
}