package com.example.asl_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WordSearchLists extends AppCompatActivity {
    AppCompatButton btn_common_words,btn_fruits,btn_veggies,btn_family;
    String word_list_clicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_search_2);

        //Initializing the buttons
        btn_common_words = findViewById(R.id.common_words_btn);
        btn_fruits = findViewById(R.id.fruits_btn);
        btn_veggies = findViewById(R.id.vegetables_btn);
        btn_family = findViewById(R.id.family_btn);

        btn_common_words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordSearchLists.this, WordSearch.class);
                word_list_clicked = "common words";
                intent.putExtra("Word List Clicked",word_list_clicked);
                startActivity(intent);
            }
        });
        btn_fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordSearchLists.this, WordSearch.class);
                word_list_clicked = "fruits";
                intent.putExtra("Word List Clicked",word_list_clicked);
                startActivity(intent);
            }
        });

        btn_veggies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordSearchLists.this, WordSearch.class);
                word_list_clicked = "vegetables";
                intent.putExtra("Word List Clicked",word_list_clicked);
                startActivity(intent);
            }
        });

        btn_family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WordSearchLists.this, WordSearch.class);
                word_list_clicked = "family";
                intent.putExtra("Word List Clicked",word_list_clicked);
                startActivity(intent);
            }
        });

    }
}