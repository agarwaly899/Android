package com.example.safe_earn;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private EditText mTextEmail;
    private EditText mTextPass;
    private TextView Log2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        progressDialog=new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(LoginActivity.this,VehicleActivity.class));
        }
        mTextEmail = findViewById(R.id.logemail);
        mTextPass = findViewById(R.id.logpass);
        Log2 = findViewById(R.id.log2);

        Log2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mTextEmail.getText().toString().trim();
                String pwd = mTextPass.getText().toString().trim();
                progressDialog.setMessage("Login in Progress...");
                progressDialog.show();
                login(email,pwd);
            }
        });
    }
    public void login(String e,String p){
        firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    startActivity(new Intent(LoginActivity.this,VehicleActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }
}

