package com.example.yashagarwal.smarty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yashagarwal.smarty.R;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    private long backTime;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        TextView login=(TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new ProgressDialog(MainActivity.this);
                dialog.setTitle("Smarty");
                dialog.setMessage("Connecting to Bluetooth...");
                countDownTimer=new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        dialog.show();
                    }

                    @Override
                    public void onFinish() {

                        dialog.dismiss();
                        Intent i=new Intent(MainActivity.this,FunctionActivity.class);
                        startActivity(i);
                        finish();
                    }
                }.start();

            }
        });
        TextView rejister=(TextView) findViewById(R.id.textview_register);
        rejister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
        if(backTime+2000>System.currentTimeMillis()){
            System.exit(1);
            }
        else {
            Toast.makeText(this,"Press Again to Exit!",Toast.LENGTH_SHORT).show();
        }
        backTime=System.currentTimeMillis();
    }
}
