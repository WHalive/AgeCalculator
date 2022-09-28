package com.example.myagecalculator

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myagecalculator.databinding.ActivityMainBinding
import java.util.*
import kotlin.math.round


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var inputText: EditText
    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener {
            val result = showResult()
            binding.ageResult.text = result.toString()
            val myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("result", result)
            startActivity(myIntent)
        }
        binding.Year.setOnClickListener {
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]


            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    binding.Year.setText("$dayOfMonth/$monthOfYear/$year")
                    binding.realAge.text = getAge(year, monthOfYear, dayOfMonth)
                },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }

    }

    private fun showResult(): Int {
        val num1 = binding.realAge.text.toString().toDouble()
        val num2 = binding.middleAge.text.toString().toDouble()
        val resultNum = num1 * 100 / num2
        return round(resultNum).toInt()
    }

    private fun getAge(year: Int, month: Int, day: Int): String {

        val birthDate = Calendar.getInstance()
        val currentDate = Calendar.getInstance()

        birthDate.set(year, month, day)
        var age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)

        if (currentDate.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        val ageInt = age
        return ageInt.toString()
    }


}