package com.example.library_app_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class menuButton2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_button2);
    }

    Intent intent = getIntent();


    String user = intent.getStringExtra(MainActivity.EXTRA_Username);
    TextView output = (TextView) findViewById(R.id.UserInfoOut);
    output.setText("welcome " + user);


}
