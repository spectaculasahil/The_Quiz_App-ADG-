package com.example.curiosityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    private Button categoryButton1;
    private Button categoryButton2;
    private Button categoryButton3;
    private Button categoryButton4;
    private Button categoryButton5;
    private TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryButton1 = findViewById(R.id.categoryButton1);
        categoryButton2 = findViewById(R.id.categoryButton2);
        categoryButton3 = findViewById(R.id.categoryButton3);
        categoryButton4 = findViewById(R.id.categoryButton4);
        categoryButton5 = findViewById(R.id.categoryButton5);
        String userName = getIntent().getStringExtra("userName");
        greetingTextView = findViewById(R.id.greetingTextView);
        greetingTextView.setText("Hello, " + userName + "!");


        categoryButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, QuizActivitycat1.class);
                startActivity(intent);
            }
        });

        categoryButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, QuizActivitycat2.class);
                startActivity(intent);
            }
        });

        categoryButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, QuizActivitycat3.class);
                startActivity(intent);
            }
        });

        categoryButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, QuizActivitycat4.class);
                startActivity(intent);
            }
        });
        categoryButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, QuizActivitycat5.class);
                startActivity(intent);
            }
        });
    }
}
