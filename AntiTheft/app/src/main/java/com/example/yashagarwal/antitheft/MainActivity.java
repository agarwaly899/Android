package com.example.yashagarwal.antitheft;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private long timeleft=0;
    private boolean timerRunning;
    public CountDownTimer countDownTimer;
    final Intent intu=new Intent(this,MainActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void starty(View view){
        if(timerRunning){
            stopTimer();
        }
        else {
            startTimer();
        }

    }
    private void startTimer(){
        final EditText editText=(EditText)findViewById(R.id.edit_text);
        int time=Integer.parseInt(editText.getText().toString());
        timeleft=time*60000;
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.ghost);
        final ImageView imageView=(ImageView) findViewById(R.id.image_view);


     countDownTimer=new CountDownTimer(timeleft,1000) {
         @Override
         public void onTick(long millisUntilFinished) {
            timeleft=millisUntilFinished;
            updateTimer();
         }

         @Override
         public void onFinish() {
             imageView.setVisibility(View.VISIBLE);
             editText.setVisibility(View.GONE);
             editText.setEnabled(false);

             mp.start();
             startActivity(intu);

             }

     }.start();
        timerRunning=true;
    }
    private void stopTimer () {
        countDownTimer.cancel();
        timerRunning=false;
    }
    public void updateTimer(){
        TextView countdownText=(TextView) findViewById(R.id.county);
        int minutes=(int) timeleft/60000;
        int seconds=(int) timeleft%60000/1000;
        String timetext=null;
        if (minutes<10){
            timetext="0"+minutes;
        }
        else{
            timetext=""+minutes;
        }
        timetext=timetext+":";
        if(seconds<10)
        {
            timetext+="0";
        }
        timetext+=seconds;
        countdownText.setText(timetext);

    }


}


