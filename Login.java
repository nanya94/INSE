package com.example.library_app_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Intent intent = getIntent();
        TextView output = (TextView) findViewById(R.id.Output_Text);
        output.setText("Unsuccessful Login");
    }

    public void back(View view) {
        Intent exit = new Intent(this, MainActivity.class);
        startActivity(exit);
    }
}

