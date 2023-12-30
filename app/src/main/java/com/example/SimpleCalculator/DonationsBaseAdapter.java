package com.example.simpilecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DonationsBaseAdapter extends BaseAdapter {
    ArrayList<Donation> donationArrayList;
    Context activityContext;

    DonationsBaseAdapter(ArrayList<Donation> list, Context context){
        this.donationArrayList = list;
        activityContext = context;
    }
    @Override
    public int getCount() {
        return donationArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return donationArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
    // covert xml file into a view object.
        // cell for row at index path in iOS
    //Inflate a new view hierarchy from the specified xml resource.
      View donationRowView =  LayoutInflater.from(activityContext).inflate(R.layout.donation_list_row, viewGroup, false);
       TextView dt = donationRowView.findViewById(R.id.donation_row_date);
       TextView at = donationRowView.findViewById(R.id.donation_row_amount);
       TextView pmt = donationRowView.findViewById(R.id.donation_row_pmethod);

       dt.setText(donationArrayList.get(i).getDonation_date());
       String a = String.valueOf(donationArrayList.get(i).getAmount())+donationArrayList.get(i).getDonation_currency();
        at.setText(a);
        pmt.setText(donationArrayList.get(i).getPaymentMethodString());

        return donationRowView;
    }
}
