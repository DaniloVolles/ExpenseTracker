package com.danilovolles.expensetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openAddExpense(view: View) {
        val intent = Intent (this, AddExpenseScreen::class.java)
        startActivity(intent)
    }

}