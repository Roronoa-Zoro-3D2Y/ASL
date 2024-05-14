package com.example.asl_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    CardView cardText,cardWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        cardText = findViewById(R.id.text_to_asl);
        cardWords = findViewById(R.id.words_to_asl);

        cardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        cardWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,WordSearch.class);
                startActivity(intent);
            }
        });
    }
}