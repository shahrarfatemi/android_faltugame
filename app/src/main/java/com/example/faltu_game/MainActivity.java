package com.example.faltu_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button playButton,ruleButton,scoreButton;
    private EditText nameText;
    public static String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameId);
        playButton = findViewById(R.id.playButtonId);
        playButton.setOnClickListener(this);
        ruleButton = findViewById(R.id.rulesButtonId);
        ruleButton.setOnClickListener(this);
        scoreButton = findViewById(R.id.scoresButtonId);
        scoreButton.setOnClickListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences("names",Context.MODE_PRIVATE);
        if(sharedPreferences.contains("nameKey")){
            String name = sharedPreferences.getString("nameKey","not found");
            nameText.setText(name);
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.playButtonId) {
            String username = nameText.getText().toString();
            if(username.isEmpty()){
                nameText.setError("Please Enter a valid name");
                nameText.requestFocus();
                return;
            }
            else {
                SharedPreferences sharedPreferences = getSharedPreferences("names", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nameKey",username);
                editor.commit();
                playerName = username;
                Intent intent = new Intent(MainActivity.this, Level1Activity.class);
                startActivity(intent);
            }
        }
        else if(v.getId() == R.id.scoresButtonId) {
            Intent intent = new Intent(MainActivity.this, ScoresActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.rulesButtonId) {
            Intent intent = new Intent(MainActivity.this, RulesActivity.class);
            startActivity(intent);
        }
    }


}
