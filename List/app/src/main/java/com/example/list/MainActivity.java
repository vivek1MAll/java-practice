package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ListView listView;
    AutoCompleteTextView autoCompleteTextView;
    ArrayList<String> arrName = new ArrayList<>();
    ArrayList<String> arrId = new ArrayList<>();
    ArrayList<String> auto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        arrName.add("java");
        arrName.add("c");
        arrName.add("c#");
        arrName.add("python");
        arrName.add("c++");
        arrName.add("rust");
        arrName.add("java Script");
        arrName.add("java");
        arrName.add("c");
        arrName.add("c#");
        arrName.add("python");
        arrName.add("c++");
        arrName.add("rust");
        arrName.add("java Script");
        arrName.add("java");
        arrName.add("c");
        arrName.add("c#");
        arrName.add("python");
        arrName.add("c++");
        arrName.add("rust");
        arrName.add("java Script");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {

            if (i == 0) {
                Toast.makeText(MainActivity.this, "you chose java", Toast.LENGTH_SHORT).show();
            }

        });


        arrId.add("adhar card");
        arrId.add("adhar card");
        arrId.add("voting card");
        arrId.add("school Id card");
        arrId.add("pan card");

        ArrayAdapter<String>spin= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrId);
        spinner.setAdapter(spin);

        auto.add("hive");
        auto.add("pig");
        auto.add("scoop");
        auto.add("zookeeper");
        auto.add("scala");
        auto.add("spark");
        ArrayAdapter<String> auto=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,auto);
        autoCompleteTextView.setAdapter(auto);
        autoCompleteTextView.setThreshold(1);


    }

}