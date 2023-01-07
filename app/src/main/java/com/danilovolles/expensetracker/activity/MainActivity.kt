package com.danilovolles.expensetracker.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.danilovolles.expensetracker.R

class MainActivity : AppCompatActivity() {

    private lateinit var goPieChart:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goPieChart = findViewById(R.id.go_pie_chart)

        goPieChart.setOnClickListener {
            startActivity(Intent (this, PieChartActivity::class.java))
        }
    }

    fun openAddExpense(view: View) {
        startActivity(Intent (this, AddExpenseScreen::class.java))
    }

}