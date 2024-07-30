package com.example.curiosityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivitycat4 extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "Question 1 : \nWho directed \"Titanic\" ? ",
            "Question 2 : \nWhich movie features the character Jack Sparrow ? ",
            "Question 3 : \nWhich film won the Oscar for Best Picture in 1994 ? ",
            "Question 4 : \nWho played the role of Joker in \"The Dark Knight\" ? ",
            "Question 5 : \nWhich film features the song \"My Heart Will Go On\" ? "
    };

    private String[][] options = {
            {"Steven Spielberg", "James Cameron", "Martin Scorsese", "Quentin Tarantino"},
            {"The Lord of the Rings", "Pirates of the Caribbean", "Harry Potter ", "The Matrix"},
            {"Forrest Gump", "Pulp Fiction", "Shawshank Redemption", "The Lion King"},
            {"Jared Leto", "Heath Ledger", "Joaquin Phoenix", "Jack Nicholson"},
            {"Avatar", "Titanic", "The Greatest Showman", "La La Land"}
    };

    private int[] correctAnswers = {1, 1, 0, 1, 1}; // Index of correct options

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
                    Intent intent = new Intent(QuizActivitycat4.this, ResultActivity.class);
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
