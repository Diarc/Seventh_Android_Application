package com.example.zadanie7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText display_data;
    Spinner namesSpinner, weekDaysSpinner;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesSpinner = findViewById(R.id.namesSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        namesSpinner.setAdapter(adapter);
        namesSpinner.setOnItemSelectedListener(this);

        weekDaysSpinner = findViewById(R.id.weekDaysSpinner);
        ArrayAdapter<CharSequence> adapterDays = ArrayAdapter.createFromResource(this, R.array.weekDays, android.R.layout.simple_spinner_item);
        adapterDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weekDaysSpinner.setAdapter(adapterDays);
        weekDaysSpinner.setOnItemSelectedListener(this);

        display_data = findViewById(R.id.display_data);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void displayResult(View view){
        if(display_data.getText().toString().equals("")){
            result = namesSpinner.getSelectedItem().toString() + " " + weekDaysSpinner.getSelectedItem().toString();
            display_data.setText(result);
        }
        else{
            result = result + "\n" + namesSpinner.getSelectedItem().toString() + " " + weekDaysSpinner.getSelectedItem().toString();
            display_data.setText(result);
        }
    }

}