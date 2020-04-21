package com.example.app4act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    TextView t;
    TextView randomt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        int x =(int)(Math.random()*100);
        t =(TextView)findViewById(R.id.messageCounter);
        randomt=(TextView)findViewById(R.id.random);
        randomt.setText(String.valueOf(x));
        timer.start();
    }
    CountDownTimer timer = new CountDownTimer(5 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            // this method will be executed every second ( 1000 ms : the second parameter in the CountDownTimer constructor)
            String counter = (millisUntilFinished/1000) +"...";
            t.setText(counter);
        }

        @Override
        public void onFinish() {
            //Intent intent = new Intent(getBaseContext(), MainActivity.class);
            // Log.d("testApp", "testing");
            //startActivity(intent);
            //retour();
            String randomNumberStr = randomt.getText().toString();
            Log.d("returnString", "randomNumberStr:"+randomNumberStr);
            Intent returnIntent = new Intent();
            returnIntent.putExtra("random", "Random number from Activity 4: "+ randomNumberStr);
            setResult(10,returnIntent);
            finish();
        }

    };

}
