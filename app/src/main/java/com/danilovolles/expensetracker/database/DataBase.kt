package com.danilovolles.expensetracker.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.danilovolles.expensetracker.Expense

class DataBase (context: Context):SQLiteOpenHelper (context, "expenses.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val sql = """
            CREATE TABLE TB_EXPENSES (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                VALUE DOUBLE,
                TAG TEXT,
                NOTE TEXT
            );
        """.trimIndent()

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS TB_EXPENSES")
        onCreate(db)
    }

    fun insertExpense(item: Expense): Long {
        val idExpense = writableDatabase.insert("TB_EXPENSES", null, ContentValues().apply {
            put("VALUE", item.value)
            put("TAG", item.tag)
            put("NOTE", item.note)
        })
        return idExpense
    }

    fun selectExpenseByTag(): Cursor? {
        val sql = "SELECT TAG FROM TB_EXPENSES"
        return readableDatabase.rawQuery(sql, null)
    }

}