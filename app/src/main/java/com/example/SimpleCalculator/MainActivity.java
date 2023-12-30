package com.example.simpilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNumText ;
    EditText secondNumText ;
    Button add_but;
    Button sub_but;
    Button times_but;
    Button divid_but;
    Button change_colour_but;
    TextView resultText;
    // three different options for adding click listener
    int num1 = 0;
    int num2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcuator_layout);
        firstNumText = findViewById(R.id.first_num);
        secondNumText = findViewById(R.id.second_num);

        add_but =  findViewById(R.id.add_but);
        sub_but = findViewById(R.id.sub_but);
        times_but = findViewById(R.id.times_but);
        divid_but = findViewById( R.id.divid_but);
        resultText = findViewById(R.id.result_text);

        change_colour_but = findViewById(R.id.change_colour);
        change_colour_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  R.color.red
                setActivityBackgroundColor(0xfff00000);// hex (fff00000) -> int(0xfff00000)
            }
        });
        View.OnClickListener dividListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( validate()) {
                    int r = num1 / num2;
                    resultText.setText(String.valueOf(r));
                }
            }
        };
        // second option to add on click listener (recommended)
        divid_but.setOnClickListener(dividListener);

        times_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( validate()) {
                    int r = num1 * num2;
                    resultText.setText(String.valueOf(r));
                }
            }
        });
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }

    boolean validate(){
        boolean flag = false;
        if (!firstNumText.getText().toString().isEmpty() &&
                !secondNumText.getText().toString().isEmpty()) {
             num1 = Integer.parseInt(firstNumText.getText().toString());
             num2 = Integer.parseInt(secondNumText.getText().toString());
             flag = true;
        }else {
            resultText.setText(R.string.error_msg);
        }
        return flag;
    }

    // first option to add on click listener
    public void addtwonumber(View view) {
       if ( validate()) {
           int r = num1 + num2;
           resultText.setText(String.valueOf(r));
       }
    }
    // first option to add on click listener
    public void subtwonumber(View view) {
        if ( validate()) {
            int r = num1 - num2;
            resultText.setText(String.valueOf(r));
        }

    }
}