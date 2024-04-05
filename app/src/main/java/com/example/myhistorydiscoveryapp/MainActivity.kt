package com.example.myhistorydiscoveryapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateHistoryButton = findViewById<Button>(R.id.generateHistoryButton)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val infoTextView = findViewById<TextView>(R.id.infoTextView)

        generateHistoryButton.setOnClickListener {
            val ageText = ageEditText.text.toString()
            if (ageText.isNotEmpty()) {
                val age = ageText.toIntOrNull()
                if (age != null) {
                    val historicFigure = findHistoricFigure(age)
                    infoTextView.text = "Historic Figure: $historicFigure"
                } else {
                    infoTextView.text = "Please enter a valid age"
                }
            } else {
                infoTextView.text = "Please enter an age"
            }
        }
    }

    private fun findHistoricFigure(age: Int): String {
        return when {
            age in 20..40 -> "Martin Luther King Jr."
            age in 41..59 -> "Napoleon Bonaparte"
            age in 51..69 -> "Christopher Columbus"
            // Add more cases for other age ranges
            else -> "No historic figure found for this age"
        }
    }
}
