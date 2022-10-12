package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;


    ArrayList<ContactModel> arrContacts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
//        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView finalRecyclerView = recyclerView;
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);

                EditText edtNumber = dialog.findViewById(R.id.edtNumber);

                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", number = "";
                        if (!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "please enter the number", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtName.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "please enter the number", Toast.LENGTH_SHORT).show();
                        }
                        arrContacts.add(new ContactModel(name, number));

                        adapter.notifyItemInserted(arrContacts.size() - 1);

                        recyclerView.scrollToPosition(arrContacts.size() - 1);

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        // layout Manager setting
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345"));

        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_contact_mail_24, "vivek", "9876"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234545678"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345096"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234465"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12347645"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234675"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "123459876"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345iu"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12346785"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345987"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234455"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "9876"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234545678"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345096"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234465"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12347645"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234675"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "123459876"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345j"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345iu"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12346785"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "12345987"));
        arrContacts.add(new ContactModel(R.drawable.contact, "vivek", "1234455"));


        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);


    }
}