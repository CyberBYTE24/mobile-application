package com.cyberbyte.mobileapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cyberbyte.mobileapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private var numbers: CharArray = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{

            var count = 0;
            var input = binding.editTextText.text.toString();

            input.forEach{
                if(numbers.contains(it))
                    count++
            }

            binding.result.text = "Количество цифр: " + count.toString();
        }
    }
}