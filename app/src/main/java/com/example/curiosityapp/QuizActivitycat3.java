package com.example.curiosityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivitycat3 extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "Question 1 : \nWhich country won the 2018 FIFA World Cup ? " ,
            "Question 2 : \nWhat sport is known as \"the beautiful game\" ? ",
            "Question 3 : \nWhich athlete is famous for winning 8 Olympic gold medals ? ",
            "Question 4 : \nIn tennis, what is the term for a score of 40-40 ? ",
            "Question 5 : \nWhich city hosted the 2020 Summer Olympics ? "
    };

    private String[][] options = {
            {"Brazil", "Germany", "France", "Argentina"},
            {"Baseball", "Basketball", "Soccer", "Tennis"},
            {"Michael Phelps", "Usain Bolt", "Simone Biles", "Serena Williams"},
            {"Deuce", "Advantage", "Set", "Match"},
            {"Tokyo", "Beijing", "Rio de Janeiro", "London"}
    };

    private int[] correctAnswers = {2, 2, 0, 0, 0}; // Index of correct options

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
                    Intent intent = new Intent(QuizActivitycat3.this, ResultActivity.class);
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
