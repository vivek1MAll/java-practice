package com.example.chartapp;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class bardemo extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bardemo);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        barChart=findViewById(R.id.barchart);

        ArrayList<BarEntry> information=new ArrayList<>();
        information.add(new BarEntry(8,100));
        information.add(new BarEntry(7,120));
        information.add(new BarEntry(6,130));
        information.add(new BarEntry(5,140));
        information.add(new BarEntry(4,150));
        information.add(new BarEntry(3,106));
        information.add(new BarEntry(2,107));

        BarDataSet dataSet=new BarDataSet(information,"report");
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        dataSet.setValueTextColor(android.R.color.black);
        dataSet.setValueTextSize(20f);


        BarData barData= new BarData(dataSet);



    }


}
