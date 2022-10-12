package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber, editTextNumber2;
    public Button SUBTRACTION;
    public Button MULTIPLICATION;
    public Button DIVISION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerOnSUBTRACTION();
        addListenerOnMULTIPLICATION();
        addListenerOnDivision();
    }

    public void addListenerOnButton() {

        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        Button add = (Button) findViewById(R.id.add);

        add.setOnClickListener(view -> {
            String value1 = editTextNumber.getText().toString();
            String value2 = editTextNumber2.getText().toString();

            int a = Integer.parseInt(value1);
            int b = Integer.parseInt(value2);
            int sum = a + b;

            Toast.makeText(getApplicationContext(), String.valueOf(sum), Toast.LENGTH_LONG).show();

        });


    }

    public void addListenerOnSUBTRACTION() {

        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        SUBTRACTION = (Button) findViewById(R.id.SUBTRACTION);

        SUBTRACTION.setOnClickListener(view -> {

            String value1 = editTextNumber.getText().toString();
            String value2 = editTextNumber2.getText().toString();

            int a = Integer.parseInt(value1);
            int b = Integer.parseInt(value2);

            int sub = a - b;

            Toast.makeText(getApplicationContext(), String.valueOf(sub), Toast.LENGTH_LONG).show();


        });
    }
    Run
    public void addListenerOnDivision() {
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        DIVISION = (Button) findViewById(R.id.DIVISION);

        DIVISION.setOnClickListener(view -> {
            String value1 = editTextNumber.getText().toString();
            String value2 = editTextNumber2.getText().toString();

            int a = Integer.parseInt(value1);
            int b = Integer.parseInt(value2);

            int div = a / b;

            Toast.makeText(getApplicationContext(), String.valueOf(div), Toast.LENGTH_LONG).show();

        });

    }

    public void addListenerOnMULTIPLICATION() {
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);

        MULTIPLICATION = (Button) findViewById(R.id.MULTIPLICATION);

        MULTIPLICATION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editTextNumber.getText().toString();
                String value1 = editTextNumber2.getText().toString();

                int a = Integer.parseInt(value);
                int b = Integer.parseInt(value1);

                int mul = a * b;

                Toast.makeText(getApplicationContext(), String.valueOf(mul), Toast.LENGTH_LONG).show();


            }
        });

    }


}