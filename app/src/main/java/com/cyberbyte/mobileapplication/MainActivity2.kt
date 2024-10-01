package com.cyberbyte.mobileapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cyberbyte.mobileapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{
            var x = binding.xVariable.text.toString().toDouble();
            var order = 1;
            var add = calcAdd(x, order);
            var sum = 0.0;
            var persiction = 0.01;

            while(add>persiction){
                sum += add;
                add = calcAdd(x, ++order)
            }

            binding.sum.text = sum.toString();
            binding.lastAdd.text = add.toString();
        }
    }

    fun calcAdd(x: Double, order: Int) : Double{
        return 1/(order*Math.pow(x, order.toDouble()))
    }
}