package com.danilovolles.expensetracker.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.danilovolles.expensetracker.Expense
import com.danilovolles.expensetracker.R
import com.danilovolles.expensetracker.database.DataBase
import com.danilovolles.expensetracker.database.insertExpense
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddExpenseScreen : AppCompatActivity() {

    private lateinit var editValue: EditText
    private lateinit var editTag: EditText
    private lateinit var addExpenseButton: FloatingActionButton

    private lateinit var dataBase: DataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense_screen)

        editValue = findViewById(R.id.editValue)
        editTag = findViewById(R.id.editTag)
        addExpenseButton = findViewById(R.id.addExpenseButton)

        dataBase = DataBase(this)

        addExpenseButton.setOnClickListener {
            addExpenseFunction()
        }
    }

    private fun addExpenseFunction() {

        val expense = Expense (
            value = editValue.text.toString(),
            tag = editValue.text.toString(),
            note = editValue.text.toString()
        )

        val idExpense = dataBase.insertExpense(expense)

        if (idExpense == -1L) {
            Toast.makeText(this, "Erro ao inserir", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Despesa inserida com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
}