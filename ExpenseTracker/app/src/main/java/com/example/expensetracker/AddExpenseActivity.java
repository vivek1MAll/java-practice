package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import com.example.expensetracker.databinding.ActivityAddExpenseBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.UUID;

public class AddExpenseActivity extends AppCompatActivity {

    ActivityAddExpenseBinding binding;
    private String type;
    private ExpenseModel expenseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        type = getIntent().getStringExtra("type");
        expenseModel = (ExpenseModel) getIntent().getSerializableExtra("model");

        if (expenseModel != null) {

            type = expenseModel.getType();
            binding.amount.setText(String.valueOf(expenseModel.getAmount()));
            binding.category.setText(String.valueOf(expenseModel.getCategory()));
            binding.category.setText(String.valueOf(expenseModel.getNote()));

        }
        if (type.equals("Income")) {
            binding.incomeRadio.setChecked(true);
        } else {
            binding.expenseRadio.setChecked(true);
        }
        binding.incomeRadio.setOnClickListener(view -> type = "Income");
        binding.expenseRadio.setOnClickListener(view -> type = "Expense");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.saveExpense) {
            if (type != null) {
                createExpense();
            } else {
                updateExpense();
            }
            return true;
        }
        return false;

    }

    private void createExpense() {

        String expenseId = UUID.randomUUID().toString();
        String amount = binding.amount.getText().toString();
        String note = binding.Note.getText().toString();
        String category = binding.category.getText().toString();


        boolean incomeRadioChecked = binding.incomeRadio.isChecked();

        if (incomeRadioChecked) {
            type = "income";
        } else {
            type = "expense";
        }


        if (amount.trim().length() == 0) {
            Toast.makeText(this, "please fill amount", Toast.LENGTH_SHORT).show();
        }
        ExpenseModel expenseModel = new ExpenseModel(expenseId, note, category, type, Long.parseLong(amount),
                Calendar.getInstance().getTimeInMillis(), FirebaseAuth.getInstance().getUid());

        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .document(expenseId)
                .set(expenseModel);
        finish();


    }

    private void updateExpense() {

        String expenseId = expenseModel.getExpenseId();
        String amount = binding.amount.getText().toString();
        String note = binding.Note.getText().toString();
        String category = binding.category.getText().toString();


        boolean incomeRadioChecked = binding.incomeRadio.isChecked();

        if (incomeRadioChecked) {
            type = "Income";
        } else {
            type = "Expense";
        }


        if (amount.trim().length() == 0) {
            Toast.makeText(this, "please fill amount", Toast.LENGTH_SHORT).show();
        }
        ExpenseModel model = new ExpenseModel(expenseId, note, category, type, Long.parseLong(amount), expenseModel.getTime(), FirebaseAuth.getInstance().getUid());

        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .document(expenseId)
                .set(model);
        finish();


    }
}