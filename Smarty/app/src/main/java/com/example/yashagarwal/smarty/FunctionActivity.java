package com.example.yashagarwal.smarty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FunctionActivity extends AppCompatActivity {
    private String deviceName = null;
    private String roomName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_function);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            deviceName = extras.getString("Name");
            roomName = extras.getString("namo");
            if (deviceName != null)
                Toast.makeText(this, deviceName + " Added !", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, roomName + " Added !", Toast.LENGTH_SHORT).show();

        }
        TextView device = (TextView) findViewById(R.id.add);
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FunctionActivity.this, DevicesActivity.class);
                startActivity(i);
                finish();

            }
        });
        TextView done = (TextView) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FunctionActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog alertDialog;

        new AlertDialog.Builder(this)
                .setTitle("Exit :")
                .setMessage("Are you sure you want to logout ?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new Dialog.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent i = new Intent(FunctionActivity.this, MainActivity.class);
                        startActivity(i);
                        FunctionActivity.super.onBackPressed();
                    }
                }).create().show();

    }
}
