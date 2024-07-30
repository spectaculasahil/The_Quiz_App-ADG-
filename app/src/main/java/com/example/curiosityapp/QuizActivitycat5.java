package com.example.curiosityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivitycat5 extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "Question 1 : \nWho was the first President of the United States ? ",
            "Question 2 : \nWhich year did World War II end ? ",
            "Question 3 : \nWho was the British Prime Minister during most of World War II ? ",
            "Question 4 : \nWhich empire was known as \"the Empire on which the sun never sets\" ? ",
            "Question 5 : \nWhere did the Industrial Revolution begin ? "
    };

    private String[][] options = {
            {"Thomas Jefferson", "John Adams", "George Washington", "James Madison"},
            {"1939", "1941", "1945", "1950"},
            {"Neville Chamberlain", "Winston Churchill", "Clement Attlee", "Harold Macmillan"},
            {"Ottoman Empire", "Roman Empire", "British Empire", "Mongol Empire"},
            {"France", "Germany", "United States", "Great Britain"}
    };

    private int[] correctAnswers = {0, 1, 2, 3, 0}; // Index of correct options

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
                    Intent intent = new Intent(QuizActivitycat5.this, ResultActivity.class);
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
