package com.example.app4act;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonChangeActivity(View view) {
        Button b = (Button) view;
        String activityName = b.getText().toString();
        activityName = "Main" + activityName.substring(activityName.length() - 1)+"Activity";
        switch(activityName){
            case "Main2Activity":
                process(Main2Activity.class);
                break;
            case "Main3Activity":
                process(Main3Activity.class);
                break;
            case "Main4Activity":
                process(Main4Activity.class);
                break;
        }
    }

    public void process(Class activity){
        Intent intent = new Intent(getBaseContext(), activity);
        // Log.d("testApp", "testing");
        startActivity(intent);
    }
}
