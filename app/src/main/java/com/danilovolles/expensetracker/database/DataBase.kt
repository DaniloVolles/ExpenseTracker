package com.danilovolles.expensetracker.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

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

}