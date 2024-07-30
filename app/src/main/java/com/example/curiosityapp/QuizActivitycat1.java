package com.example.curiosityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivitycat1 extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "Question 1 : \nWhich continent is the Sahara Desert located in ?",
            "Question 2 : \nMount Everest is part of which mountain range ? ",
            "Question 3 : \nWhich river is the longest in the world? ",
            "Question 4 : \nWhat is the largest ocean on Earth ? ",
            "Question 5 : \nWhat is the capital city of France ? "
    };

    private String[][] options = {
            {"Asia", "Europe", "Africa", "Australia"},
            {"The Alps", "The Rockies", "The Andes", "Himalayas"},
            {"Nile", "Amazon", "Yangtze", "The Ganges"},
            {"Atlantic", "Indian", "Arctic", "Pacific"},
            {"Berlin", "Madrid", "Paris", "Rome"}
    };

    private int[] correctAnswers = {2, 3, 0, 3, 2}; // Index of correct options

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextButton = findViewById(R.id.nextButton);

        loadQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionIndex = optionsRadioGroup.indexOfChild(findViewById(optionsRadioGroup.getCheckedRadioButtonId()));
                if (selectedOptionIndex == correctAnswers[currentQuestionIndex]) {
                    score++;
                }

                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuizActivitycat1.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        option1.setText(options[currentQuestionIndex][0]);
        option2.setText(options[currentQuestionIndex][1]);
        option3.setText(options[currentQuestionIndex][2]);
        option4.setText(options[currentQuestionIndex][3]);
        optionsRadioGroup.clearCheck();
    }
}
