package com.danilovolles.expensetracker

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase (context: Context):SQLiteOpenHelper (context, "despesas.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val sql = """
            CREATE TABLE TB_DESPESAS (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                VALOR DOUBLE,
                TAG TEXT,
                NOTA TEXT
            );
        """.trimIndent()

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS TB_DESPESAS")
        onCreate(db)
    }

}