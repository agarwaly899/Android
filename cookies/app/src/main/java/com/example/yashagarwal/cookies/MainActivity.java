package com.example.yashagarwal.cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View v){
        full1();
        full2();
    }
    public void reset(View v){
        empty1();
        empty2();
    }
    private void full1(){
        TextView textView=(TextView) findViewById(R.id.text_view);
        textView.setText("I'm so full");
    }
    private void full2(){
        ImageView imageView=(ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.after_cookie);
    }
    private void empty1(){
        TextView textView=(TextView) findViewById(R.id.text_view);
        textView.setText("I'm so hungry");
    }
    private void empty2(){
        ImageView imageView=(ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.before_cookie);
    }
}
