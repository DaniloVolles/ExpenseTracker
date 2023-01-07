package com.danilovolles.expensetracker

data class Expense(
    val value: String,
    val tag: String,
    val note: String ? = null,
    val id: Int ? = null
    )