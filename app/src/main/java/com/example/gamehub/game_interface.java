package com.example.gamehub;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;




public class game_interface extends AppCompatActivity {
    SharedPreferences highScore_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stone_paper_scissors);
        highScore_save = this.getSharedPreferences("highScoreKey" , Context.MODE_PRIVATE);
        highScore = highScore_save.getInt("highScoreKey" , 0);
        getHighScore();
    }
    String comp;
    int streak = 0 , highScore = 0;
    String streak_display = "0" , highScore_display = "0";

    public void comp(View cho) {
        TextView text = findViewById(R.id.textView_compChoice);
        getStreak();
        
        Random r = new Random();
        String t = String.format("%d", r.nextInt(3));
        switch (t) {
            case "0":
                comp = "Stone";
                break;
            case "1":
                comp = "Paper";
                break;
            case "2":
                comp = "Scissor";
                break;
        }
        text.setText(comp);

        switch (cho.getId()) {

            case R.id.button_stone:
                switch (t){
                    case "0":
                        Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show();
                        break;
                    case "1":
                        Toast.makeText(this,"Lost",Toast.LENGTH_LONG).show();
                        streak = 0;
                        break;
                    case "2":
                        Toast.makeText(this,"Win",Toast.LENGTH_LONG).show();
                        streak++;
                        break;
                }
                break;
            case R.id.button_paper:
                switch (t){
                    case "0":
                        Toast.makeText(this,"Win",Toast.LENGTH_LONG).show();
                        streak++;
                        break;
                    case "1":
                        Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show();
                        break;
                    case "2":
                        Toast.makeText(this,"Lost",Toast.LENGTH_LONG).show();
                        streak = 0;
                        break;
                }
                break;
            case R.id.button_sissor:
                switch (t){
                    case "0":
                        Toast.makeText(this,"Lost",Toast.LENGTH_LONG).show();
                        streak = 0;
                        break;
                    case "1":
                        Toast.makeText(this,"Win",Toast.LENGTH_LONG).show();
                        streak++;
                        break;
                    case "2":
                        Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show();
                        break;
                }
                break;
        }

        setHighScore();
        getStreak();
        getHighScore();

    }
    public void exit(View exit){
        setPreference();
        finish();
    }
    public void getStreak(){
        streak_display = Integer.toString(streak);
        TextView streakCount = findViewById(R.id.textView_streakCounter);
        streakCount.setText(streak_display);
    }
    public void setHighScore(){
        if(streak > highScore){
            highScore = streak;
        }
    }
    public void getHighScore(){
        highScore_display = Integer.toString(highScore);
        TextView streakCount = findViewById(R.id.textView_highScoreCounter);
        streakCount.setText(highScore_display);
    }
    public  void setPreference(){
                highScore_save.edit().putInt("highScoreKey" , highScore).commit();
    }
}
