package com.example.curiosityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivitycat2 extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "Question 1 : \nWhich organization was established to promote international peace after World War II ? ",
            "Question 2 : \nWhich country is a permanent member of the UN Security Council ? ",
            "Question 3 : \nWhat is the primary focus of the International Monetary Fund (IMF) ? ",
            "Question 4 : \nWhich treaty established the European Union ? ",
            "Question 5 : \nWhich of the following is an international organization focused on health issues ? "
    };

    private String[][] options = {
            {"NATO", "UN", "EU", "IMF"},
            {"Brazil", "Japan", "Germany", "China"},
            {"Human Rights ", "Trade Agreements ", "Global Financial Stability", "Environmental Protection"},
            {"Maastricht Treaty", "Treaty of Versailles", "Treaty of Rome", "Paris Agreements"},
            {"Who", "WTO", "UNESCO", "UNHCR"}
    };

    private int[] correctAnswers = {1, 3, 2, 0, 0}; // Index of correct options

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
                    Intent intent = new Intent(QuizActivitycat2.this, ResultActivity.class);
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
