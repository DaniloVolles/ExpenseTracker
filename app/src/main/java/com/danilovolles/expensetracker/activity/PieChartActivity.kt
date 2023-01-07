package com.danilovolles.expensetracker.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danilovolles.expensetracker.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class PieChartActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)

        setPieChart()
    }

    private fun setPieChart() {

        pieChart=findViewById(R.id.pie_chart)

        val list: ArrayList<PieEntry> = ArrayList()

        list.add(PieEntry(100f, "Alimentação"))
        list.add(PieEntry(101f, "Lazer"))
        list.add(PieEntry(102f, "Jogos"))
        list.add(PieEntry(103f, "Saúde"))
        list.add(PieEntry(104f, "Boletos"))

        val pieDataSet = PieDataSet(list, null)

        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS, 255)
        pieDataSet.valueTextSize = 15f
        pieDataSet.valueTextColor = Color.BLACK

        val pieData = PieData (pieDataSet)

        pieChart.data = pieData
        pieChart.description.text = "Gráfico de Despesas"
        pieChart.centerText = "Despesas"
        pieChart.animateY (1200)
    }
}