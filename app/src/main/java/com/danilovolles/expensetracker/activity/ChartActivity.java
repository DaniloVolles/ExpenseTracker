package com.danilovolles.expensetracker.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.danilovolles.expensetracker.R;
import com.danilovolles.expensetracker.database.*;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    DataBase dataBase;
    SQLiteDatabase sqLiteDatabase;

    PieDataSet pieDataSet = new PieDataSet(null, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);



        PieChart pieChart = findViewById(R.id.pieChart);

        dataBase = new DataBase(this);
        sqLiteDatabase = dataBase.getWritableDatabase();

        pieDataSet.setValues(selectExpenseByTag());
        pieDataSet.setLabel("Despesas");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Despesas");
        pieChart.animate();

        pieDataSet.setFormLineWidth(4);

    }

    private ArrayList<PieEntry> selectExpenseByTag() {
        ArrayList<PieEntry> tag = new ArrayList<>();
        Cursor cursor = dataBase.selectExpenseByTag();

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            tag.add(new PieEntry(cursor.getFloat(0), String.valueOf(cursor.getString(1))));
        }
        return tag;
    }
}