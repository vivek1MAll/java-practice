package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.expensetracker.databinding.ActivityMainBinding;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemsClick {

    ActivityMainBinding binding;
    public ExpenseAdapter expenseAdapter;
    Intent intent;
    public long expense = 0, income = 0;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//
//        drawerLayout = findViewById(R.id.drawerLayout);
//        navigationView = findViewById(R.id.navigationView);
////        toolbar = findViewById(R.id.toolbar);
//
//
//        setSupportActionBar(toolbar);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
//
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        loadFragment(new Afragment());
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                int id = item.getItemId();
//
//
//                if (id == R.id.optHome) {
//                    loadFragment(new Afragment());
//
//                } else if (id == R.id.note) {
//                    Toast.makeText(MainActivity.this,"notes",Toast.LENGTH_SHORT).show();
//
//                } else if (id == R.id.saveExpense) {
//                    Toast.makeText(MainActivity.this,"sett",Toast.LENGTH_SHORT).show();
//
//                } else if (id == R.id.logout) {
//                    Toast.makeText(MainActivity.this,"logout",Toast.LENGTH_SHORT).show();
//
//                } else {
//                    Toast.makeText(MainActivity.this,"loout",Toast.LENGTH_SHORT).show();
//
//                }
//                drawerLayout.closeDrawer(GravityCompat.START);
//
//                return true;
//            }
//        });


        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        expenseAdapter = new ExpenseAdapter(this, this);

        binding.r.setAdapter(expenseAdapter);
        binding.r.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);

        binding.addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type", "Income");
                startActivity(intent);
            }
        });
        binding.addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type", "Expense");
                startActivity(intent);
            }
        });
    }

//    private void loadFragment(Afragment afragment) {
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//
//        ft.add(R.id.container,afragment);
//
//        ft.commit();
//    }


    @Override
    protected void onStart() {
        super.onStart();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please");
        progressDialog.setMessage("WAIT");
        progressDialog.setCancelable(false);


        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            progressDialog.show();
            FirebaseAuth.getInstance().signInAnonymously().addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    progressDialog.cancel();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.cancel();
                }
            });


        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        income = 0;
        expense = 0;
        getData();

    }

    private void getData() {
        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .whereEqualTo("uid", FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        expenseAdapter.clear();
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot ds : dsList) {
                            ExpenseModel expenseModel = ds.toObject(ExpenseModel.class);
                            if (expenseModel.getType().equals("income")) {
                                income += expenseModel.getAmount();
                            } else {
                                expense += expenseModel.getAmount();
                            }
                            expenseAdapter.add(expenseModel);
                        }
                        setUpGraph();

                    }
                });
    }

    private void setUpGraph() {

        List<PieEntry> pieEntriesList = new ArrayList<>();
        List<Integer> pieColourList = new ArrayList<>();
        if (income != 0) {
            pieEntriesList.add(new PieEntry(income, "Income"));
            pieColourList.add(getResources().getColor(R.color.teal_700));
        }
        if (expense != 0) {
            pieEntriesList.add(new PieEntry(expense, "expense"));
            pieColourList.add(getResources().getColor(R.color.black));
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntriesList, String.valueOf(income = expense));
        pieDataSet.setColors(pieColourList);
        PieData pieData = new PieData(pieDataSet);

        binding.pieChart.setData(pieData);
        binding.pieChart.invalidate();

    }

    @Override
    public void onClick(ExpenseModel expenseModel) {
        Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
        intent.putExtra("model", expenseModel);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}