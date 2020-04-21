package com.example.app4act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t;
    CountDownTimer timer = new CountDownTimer(10 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            // this method will be executed every second ( 1000 ms : the second parameter in the CountDownTimer constructor)
            String counter = (millisUntilFinished/1000) +"...";
            t.setText(counter);
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            // Log.d("testApp", "testing");
            startActivity(intent);
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t =(TextView)findViewById(R.id.messageCounter);
        timer.start();
    }

}
