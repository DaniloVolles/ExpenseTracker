package com.danilovolles.expensetracker.database

import android.content.ContentValues
import com.danilovolles.expensetracker.Expense

fun DataBase.insertExpense(item: Expense): Long {

    val idExpense = writableDatabase.insert("TB_EXPENSES", null, ContentValues().apply {
        put("VALUE", item.value)
        put("TAG", item.tag)
        put("NOTE", item.note)
    })

    return idExpense

}