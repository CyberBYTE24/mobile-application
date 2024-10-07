package com.cyberbyte.mobileapplication

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cyberbyte.mobileapplication.databinding.ActivityCheatBinding

internal class CheatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheatBinding
    private var questionText :String = "";
    private var questionIsTrue = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.questionText.text = intent.getStringExtra("questionText")
        if(intent.getBooleanExtra("questionIsTrue", true)) {
            binding.questionAnswer.text = "Истина"
            binding.questionAnswer.setTextColor(Color.rgb(0, 200, 0))
        }else{
            binding.questionAnswer.text = "Ложь"
            binding.questionAnswer.setTextColor(Color.rgb(128, 0, 0))
        }

        binding.androidApi.text = "Android API: " + android.os.Build.VERSION.SDK_INT.toString();

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}