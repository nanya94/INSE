package com.example.library_app_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    Intent newScreen = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Intent intent = getIntent();
        String user = intent.getStringExtra(MainActivity.EXTRA_Username);
        TextView output = (TextView) findViewById(R.id.UserInfoOut);
        output.setText("welcome " + user);
    }

    public void logout(View view){
        Intent exit = new Intent(this, MainActivity.class);
        startActivity(exit);

    }


    public void changeScreen(View view){
        newScreen = new Intent(this, menuButton2.class);
        startActivity(newScreen);




    }
}
