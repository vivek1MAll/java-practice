package com.example.roomlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editAmount,editName;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAmount=findViewById(R.id.editAmount);
        editName=findViewById(R.id.editName);
        button=findViewById(R.id.button);



        DataBaseHelper dataBaseHelper=DataBaseHelper.getDB(this);

        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=editName.getText().toString();
                String amount=editAmount.getText().toString();

                dataBaseHelper.expenseDao().addTx(
                        new Expense(title,amount)
                );
                ArrayList<Expense> arrExpense=(ArrayList<Expense>)dataBaseHelper.expenseDao().getAllExpense();
                for(int i=0;i<arrExpense.size();i++){
                    Log.d("data", "Title: "+arrExpense.get(i).getTitle()+"Amount:"+arrExpense.get(i).getAmount());
                }

            }
        });

    }
}