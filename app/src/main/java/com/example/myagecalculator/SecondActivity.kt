package com.example.myagecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myagecalculator.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val value = intent.getIntExtra("result", 0)
        binding.ageResult.text = value.toString()
        binding.customView.percent = value
    }

}
