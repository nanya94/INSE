package com.example.library_app_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.lang.Boolean.*;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_Username = "com.example.myfirstapp.U";
    boolean authorisation = FALSE;
    String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View view){
        Intent success = new Intent(this, Menu.class);
        Intent failure = new Intent(this, Login.class);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.Password);
        user = username.getText().toString();
        String pass = password.getText().toString();
        checkLogin(user, pass);
        if(authorisation == TRUE){
            success.putExtra(EXTRA_Username, user);
            startActivity(success);
        }
        else{
            startActivity(failure);
        }

    }

    public void checkLogin(String username, String password) {
        if (username.equals("Test") && password.equals("password")) {
            authorisation = TRUE;
        } else if (username.equals("John") && password.equals("Password")) {
            authorisation = TRUE;
        } else {
            authorisation = FALSE;
        }
    }
}
