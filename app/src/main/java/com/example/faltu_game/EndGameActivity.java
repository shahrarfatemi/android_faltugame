package com.example.faltu_game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EndGameActivity extends AppCompatActivity {

    private TextView scoreView;
    private DatabaseReference databaseReference;
    private String name;
    private int score,highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        name = Level1Activity.player.getName();
        score = Level1Activity.player.getScore();
        highScore = Level1Activity.player.getHighScore();

        databaseReference = FirebaseDatabase.getInstance().getReference("Players");
        scoreView = findViewById(R.id.scoreId);
        scoreView.setText(Level1Activity.player.getName()+"'s Score : "+Level1Activity.player.getScore());
        addData();
//        database e save/update

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EndGameActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }



    public void addData(){
        Player player = new Player(name,score,highScore);
        String key = databaseReference.push().getKey();

        databaseReference.child(key).setValue(player);
        Toast.makeText(getApplicationContext(),"added successfully",Toast.LENGTH_SHORT).show();
    }

    public void updateData(){
        Player player = new Player(name,score,highScore);
        databaseReference.setValue(player);
        Toast.makeText(getApplicationContext(),"updated successfully",Toast.LENGTH_SHORT).show();
    }
}
