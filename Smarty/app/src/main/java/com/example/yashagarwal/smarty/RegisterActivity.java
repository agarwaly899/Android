package com.example.yashagarwal.smarty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getSupportActionBar().setTitle("Register");
        TextView login=(TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    public void onBackPressed() {

        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();


    }
}

