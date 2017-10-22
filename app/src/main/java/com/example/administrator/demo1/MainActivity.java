package com.example.administrator.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1 = 0;
    private int num2 = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void pickNumber() {
        Button leftbtn = (Button)findViewById(R.id.leftButton);
        Button rightbtn = (Button)findViewById(R.id.rightButton);
        Random random = new Random();
        while (true) {
            num1 = random.nextInt(10);
            num2 = random.nextInt(10);
            if (num1 != num2)   break;
        }
        Log.i("pickNumber", "num1 : " + num1 + ", and num2 : " + num2);
        leftbtn.setText("" + num1);
        rightbtn.setText("" + num2);

    }

    private void showScore() {
        TextView scoreView = (TextView)findViewById(R.id.scoreView);
        scoreView.setText("score:" + score);
    }

    public void leftButtonClick(View view) {
        if (num1 > num2) {
            Toast.makeText(this, "Correct!!", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(this, "Wrong~~", Toast.LENGTH_SHORT).show();
            score--;
        }
        showScore();
        pickNumber();

    }

    public void rightButtonClick(View view) {
        if (num1 < num2) {
            Toast.makeText(this, "Correct!!", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(this, "Wrong~~", Toast.LENGTH_SHORT).show();
            score--;
        }
        showScore();
        pickNumber();
    }
}
