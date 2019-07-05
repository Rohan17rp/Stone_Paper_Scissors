package com.example.gamehub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }
    public void onClick(View page2){
        Intent view = new Intent(this,game_interface.class);
        startActivity(view);
        MainActivity.this.finish();
        }
    public void exit(View exit){
        finish();
    }
}