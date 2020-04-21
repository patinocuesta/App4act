package com.example.app4act;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int RESULT_OK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RESULT_OK = 10;
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
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("returnString", "onActivityResult start");
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            Log.d("returnString", "requestCode ok");
            Log.d("returnString", "resultCode: "+resultCode);
            Log.d("returnString", "RESULT_OK: "+RESULT_OK);
            if(resultCode == RESULT_OK){
                Log.d("returnString", "resultCode: ok");
                String returnString =  data.getStringExtra("random");
                if (returnString != null) {
                    Toast.makeText(this, returnString, Toast.LENGTH_LONG).show();
                } else {
                    Log.d("returnString", "returnString null");
                }
            }
        }
    }
}
