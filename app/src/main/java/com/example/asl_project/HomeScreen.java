package com.example.asl_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    CardView cardText;
    CardView cardWords;
    CardView cardNum;
    CardView newModule;
    Dialog underDevelopment;
    AppCompatButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        cardText = findViewById(R.id.letters_to_ASl);
        cardWords = findViewById(R.id.words_to_ASL);
        cardNum = findViewById(R.id.numbers_to_ASL);
        newModule = findViewById(R.id.new_module);

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

        cardNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,NumberSearch.class);
                startActivity(intent);
            }
        });
        newModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(underDevelopment!=null){
                    underDevelopment.dismiss();
                    underDevelopment = null;
                }
                underDevelopment = new Dialog(HomeScreen.this);
                underDevelopment.setContentView(R.layout.under_development);
                underDevelopment.getWindow();
                underDevelopment.show();
                back = underDevelopment.findViewById(R.id.the_back_btn);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HomeScreen.this,HomeScreen.class);
                        startActivity(intent);
                    }
                });

                if(!underDevelopment.isShowing())
                    underDevelopment.show();
            }
        });

    }
}