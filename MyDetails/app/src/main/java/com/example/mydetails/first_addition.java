package com.example.mydetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class first_addition extends AppCompatActivity {

    Button ok,nextquestion;
    TextView score,life,time,question;
    EditText answer;

    int number1,number2,useranswer,realanswer,userscore=0,userlife = 3;
    Random random = new Random();
    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS = 20000;
    Boolean timer_running;
    long time_left_in_milis = START_TIMER_IN_MILIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_addition);
        ok = findViewById(R.id.okbutton);
        nextquestion = findViewById(R.id.nextbutton);
        score = findViewById(R.id.textViewscore);
        life = findViewById(R.id.textViewlife);
        time = findViewById(R.id.textViewtime);
        question = findViewById(R.id.textViewquestion);
        answer = findViewById(R.id.textViewanswer);
        game_continue();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                useranswer = Integer.valueOf(answer.getText().toString());
                pause_timer();
                if(useranswer == realanswer)
                {
                    userscore = userscore + 10;
                    score.setText("" + userscore);
                    question.setText("Congratulations,Your answer is true.");
                }
                else
                {
                    userlife = userlife - 1;
                    life.setText("" + userlife);
                    question.setText("Sorry,Your answer is wrong");
                }
            }
        });

        nextquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("");
                reset_timer();
                if(userlife <= 0)
                {
                    Intent intent = new Intent(first_addition.this,first_result.class);
                    intent.putExtra("score",userscore);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    game_continue();
                }
            }
        });
    }

    public void game_continue()
    {
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);

        realanswer = number1+number2;
        question.setText(number1 + "+" + number2);
        start_timer();

    }

    public void start_timer()
    {
        timer = new CountDownTimer(time_left_in_milis,1000) {
            @Override
            public void onTick(long l) {
                time_left_in_milis = l;
                update_timer();
            }

            @Override
            public void onFinish() {
                timer_running = false;
                pause_timer();
                reset_timer();
                update_timer();
                userlife = userlife - 1;
                life.setText(""+userlife);
                question.setText("Sorry!, Time is Over");
            }
        }.start();
        timer_running = true;
    }
    public void  update_timer()
    {
        int second = (int)(time_left_in_milis/1000) % 60;
        String time_left = String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }
    public void pause_timer()
    {
        timer.cancel();
        timer_running = false;
    }
    public void reset_timer()
    {
        time_left_in_milis = START_TIMER_IN_MILIS;
        update_timer();
    }
}