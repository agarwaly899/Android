package com.example.yashagarwal.smarty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DevicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Air Conditioner", R.drawable.ac));
        words.add(new Word("Water Cooler", R.drawable.aircooler));
        words.add(new Word("Light Bulb", R.drawable.bulb));
        words.add(new Word("Tubelight", R.drawable.tubelight));
        words.add(new Word("Table Lamp", R.drawable.lamp));
        words.add(new Word("Television", R.drawable.tv));
        words.add(new Word("Ceiling Fan", R.drawable.fan));
        words.add(new Word("3 Pin Socket", R.drawable.socket3));
        words.add(new Word("2 Pin Socket", R.drawable.socket2));
        WordAdapter wordAdapter =
                new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                Intent i = new Intent(DevicesActivity.this, FunctionActivity.class);
                i.putExtra("Name", word.getMiwokTranslation());
                startActivity(i);
                finish();

            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(DevicesActivity.this, FunctionActivity.class);
        startActivity(i);
        super.onBackPressed();


    }
}

