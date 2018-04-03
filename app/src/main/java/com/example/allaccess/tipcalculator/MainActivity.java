package com.example.allaccess.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
//public class MainActivity extends AppCompatActivity{

    double tipTotal;
    double tipPercent;
    double mealCost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText meal = (EditText) findViewById(R.id.billAmount);
        final Spinner percent = (Spinner) findViewById(R.id.spinnerPercent);

        // ------------Set up spinner since I could not use resource string-array in strings.xml
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinArray, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
        //--------- END of spinner setup

        Button charges =findViewById(R.id.buttonCalculate);
            charges.setOnClickListener(new View.OnClickListener() {
                final TextView result = findViewById(R.id.tipAmount);

                @Override
                public void onClick(View view) {
                    mealCost = Double.parseDouble(meal.getText().toString());
                    String seeTip;
                    seeTip = percent.getSelectedItem().toString();
                    switch (seeTip){
                        case "5%":
                            tipPercent = .05;
                            break;
                        case "10%":
                            tipPercent = .10;
                            break;
                        case "15%":
                            tipPercent = .15;
                            break;
                        case "20%":
                            tipPercent = .20;
                            break;
                        case "25%":
                            tipPercent = .25;
                            break;
                    }
                    DecimalFormat currency;
                    currency = new DecimalFormat("$###,###.##");
                    tipTotal = mealCost * tipPercent;
                    result.setText(currency.format(tipTotal));


                }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
