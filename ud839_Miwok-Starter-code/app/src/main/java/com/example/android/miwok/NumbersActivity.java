package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        final ArrayList <Word> words=new ArrayList<Word>();
        words.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("otiiko","two",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("tolookosu","three",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("oyisa","four",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("massoka","five",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("temokka","six",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("kenekaku","seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("kawinta","eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("wo'e","nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("na'aacha","ten",R.drawable.number_ten,R.raw.number_ten));
        WordAdapter wordAdapter =
                new WordAdapter (this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releasePlayer();
                Word word=words.get(position);
                mediaPlayer=MediaPlayer.create(NumbersActivity.this,word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releasePlayer();
                         }
                    });
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }
    private void releasePlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

}
