package com.cyberbyte.mobileapplication

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.cyberbyte.mobileapplication.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private var questions: MutableList<Question> = mutableListOf()

    private var currentQuestion = 0;
    private var score = 0;

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score", score);
        outState.putInt("currentQuestion", currentQuestion);

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        score = savedInstanceState.getInt("score")
        currentQuestion = savedInstanceState.getInt("currentQuestion")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        questions.add(Question("Лондон - сталица Великобретании", true))
        questions.add(Question("Москва - сталица России", true))
        questions.add(Question("Анапа - сталица Казахстана", false))

        binding.trueButton.setOnClickListener{
            trueButtonClicked()
        }
        binding.falseButton.setOnClickListener {
            falseButtonClicked()
        }
        binding.nextButton.setOnClickListener {
            nextButtonClicked()
        }
        if(savedInstanceState != null){
            score = savedInstanceState.getInt("score")
            currentQuestion = savedInstanceState.getInt("currentQuestion")
        }

        binding.question.text = questions[currentQuestion].text;
    }
    private fun trueButtonClicked(){
        if(questions[currentQuestion].isTrue){
            score++
        }
        binding.trueButton.isVisible = false;
        binding.falseButton.isVisible = false;

        if(currentQuestion>=questions.count()-1){
            var alert = AlertDialog.Builder(this);
            alert.setTitle("КВИЗ Окончен!")
            alert.setMessage("Ваш результат: " + score.toString())
            alert.show()
        }
    }
    private fun falseButtonClicked(){
        if(!questions[currentQuestion].isTrue){
            score++
        }
        binding.trueButton.isVisible = false;
        binding.falseButton.isVisible = false;
        if(currentQuestion>=questions.count()-1){
            var alert = AlertDialog.Builder(this);
            alert.setTitle("КВИЗ Окончен!")
            alert.setMessage("Ваш результат: " + score.toString())
            alert.show()
        }
    }
    private fun nextButtonClicked(){
        currentQuestion++;
        binding.question.text = questions[currentQuestion].text;
        binding.trueButton.isVisible = true;
        binding.falseButton.isVisible = true;

        if(currentQuestion>=questions.count()-1){
            binding.nextButton.isVisible = false;
        }
    }
}

class Question(public var text: String, public var isTrue: Boolean) {

}