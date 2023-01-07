package com.danilovolles.expensetracker

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class AddExpenseScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense_screen)



//        try {
//
//            //Create Data Base
//            val dataBank = SQLiteDatabase.openOrCreateDatabase("DB_EXPENSES", null, null)
//
//            // Create table
//            dataBank.execSQL(
//                "CREATE TABLE IF NOT EXISTS despesas (valor DOUBLE (15),tag VARCHAR)")
//
//            // Insert data
//            dataBank.execSQL("INSERT INTO despesas (valor,tag) VALUES (299.99,'NVME')")
//
//            val search = "SELECT valor,tag FROM despesas"
//            val cursor = dataBank.rawQuery(search, null)
//
//            // Table index restore
//            val indexValue = cursor.getColumnIndex("valor")
//            val indexTag = cursor.getColumnIndex("tag")
//            cursor.moveToFirst()
//
//            while (cursor != null) {
//                val value = cursor.getDouble(indexValue)
//                val tag = cursor.getString(indexTag)
//                Log.i("RESULT", "/valor: $value/ tag: $tag.")
//                cursor.moveToNext()
//            }
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
    }
}