package com.example.faltu_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Level3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView timeView;
    private float Max_X;
    private float Max_Y;
    private float Min_X = (float) (200.0);
    private float Min_Y = (float) (300.0);
    private Random random;
    private CountDownTimer countDownTimer;
    private CountDownTimer timer;
    private int timeleftinmillis;
    private int interval = 700;
    private int level = 3;
    private int threshold = 35;
    public static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        random = new Random();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Toast.makeText(getApplicationContext(), "Width " + width, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "Height " + height, Toast.LENGTH_LONG).show();

        timeleftinmillis = 30000;
        Max_X = width - 2 * Min_X;
        Max_Y = height - 2 * Min_Y;
        button = findViewById(R.id.buttonId3);
        button.setOnClickListener(this);


        countDownTimer = new CountDownTimer(timeleftinmillis, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                setButton();
                }

            @Override
            public void onFinish() {
                //nothing
            }
        };
        timer = new CountDownTimer(timeleftinmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Integer time = (int)(millisUntilFinished*1.0/1000);
                timeView.setText("level : "+level+"   rem : "+time.toString()+"\nscore : "+score+"   threshold : "+threshold);
                timeleftinmillis = (int) millisUntilFinished;
            }

            @Override
            public void onFinish() {
                Level1Activity.player.setScore(Level1Activity.player.getScore()+score);
                Level1Activity.player.setHighScore(Level1Activity.player.getScore());
                Intent intent = new Intent(Level3Activity.this, EndGameActivity.class);
                startActivity(intent);
                finish();
            }
        };

        timer.start();

        countDownTimer.start();

        timeView = findViewById(R.id.timeId3);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonId3){
            score++;
        }
    }

    public void setButton(){

        float X = random.nextInt((int)Max_X)+100;
        float Y = random.nextInt((int)Max_Y)+200;

        button.setX((float) (X));
        button.setY((float) (Y));

        Toast.makeText(getApplicationContext(), "X "+X, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "Y "+Y, Toast.LENGTH_LONG).show();
    }
}
