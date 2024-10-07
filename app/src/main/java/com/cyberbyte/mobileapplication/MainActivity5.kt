package com.cyberbyte.mobileapplication

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cyberbyte.mobileapplication.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sale.setOnSeekBarChangeListener (
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seek: SeekBar,
                                               progress: Int, fromUser: Boolean) {
                    binding.saleText.text = String.format("%.1f", seek.progress * 0.20) + "%";
                }
                override fun onStartTrackingTouch(seek: SeekBar) {
                }
                override fun onStopTrackingTouch(seek: SeekBar) {
                }
            }
        )

        binding.resultButton.setOnClickListener {
            binding.result.text = "Результат: " + String.format("%.2f", (1 - binding.sale.progress * 0.002) * 2000 * binding.hoursCount.text.toString().toDouble())+"руб."
        }
    }
}