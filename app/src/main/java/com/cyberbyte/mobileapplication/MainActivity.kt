package com.cyberbyte.mobileapplication

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cyberbyte.mobileapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val triangleSelector : Spinner = findViewById(R.id.triangle_part_selector);
        val inputNumeric : EditText = findViewById(R.id.input_numeric);
        val calcButton : Button = findViewById(R.id.calc_button);
        val resultCatText : TextView = findViewById(R.id.result_cat_text);
        val resultGipText : TextView = findViewById(R.id.result_gip_text);
        val resultSqrText : TextView = findViewById(R.id.result_sqr_text);

        val df = DecimalFormat("0.000");
        calcButton.setOnClickListener{
            val a : Double = inputNumeric.text.toString().toDouble();
            when(triangleSelector.selectedItem){
                "Катет" -> {
                    resultCatText.text = df.format(a);
                    resultGipText.text = df.format(Math.sqrt(a*a+a*a));
                    resultSqrText.text = df.format(a*a/2);
                }
                "Гипотенуза"-> {
                    val c : Double = Math.sqrt(a*a/2);
                    resultCatText.text = df.format(c);
                    resultGipText.text = df.format(a);
                    resultSqrText.text = df.format(c*c/2);
                }
                "Площадь"-> {
                    val c : Double = Math.sqrt(a*2);
                    resultCatText.text = df.format(c);
                    resultGipText.text = df.format(Math.sqrt(c*c+c*c));
                    resultSqrText.text = df.format(a);
                }
            }
        }

    }
}