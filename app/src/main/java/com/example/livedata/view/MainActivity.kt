package com.example.livedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.R
import com.example.livedata.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var submit: Button

    private var num1 = 0
    private var num2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.etnumber1)
        number2 = findViewById(R.id.etnumber2)
        submit = findViewById(R.id.submit)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        submit.setOnClickListener {
            if(!number1.text.toString().isNullOrEmpty()) {
                num1 = Integer.parseInt(number1.text.toString())
            }
            if(!number2.text.toString().isNullOrEmpty()) {
                num2 = Integer.parseInt(number2.text.toString())
            }


            viewModel.computation(num1,num2)
        }
        //observe LiveData changes to the main activity view
        viewModel.resultLiveData.observe(this) {
            if(it) {
                Toast.makeText(this,"$it", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"$it", Toast.LENGTH_SHORT).show()

            }
        }


    }
}