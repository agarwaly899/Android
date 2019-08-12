package com.example.yashagarwal.sgb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class SweetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sweet_list);
        final ArrayList<Sweet> Sweets=new ArrayList<Sweet>();
        Sweets.add(new Sweet("Kaju katli","₹ 800/kg",R.mipmap.kaju,800));
        Sweets.add(new Sweet("Kaju mix sweet","₹ 920/kg",R.mipmap.kajumix,920));
        Sweets.add(new Sweet("Mava mix sweet","₹ 400/kg",R.mipmap.mava,400));
        Sweets.add(new Sweet("Traditional mix sweet","₹ 480/kg",R.mipmap.traditional,480));
        Sweets.add(new Sweet("Mohanthal","₹ 480/kg",R.mipmap.mohanthal,480));
        Sweets.add(new Sweet("Maisur","₹ 480/kg",R.mipmap.maisur,480));
        Sweets.add(new Sweet("Magas","₹ 480/kg",R.mipmap.magas,480));
        Sweets.add(new Sweet("Kesar peda","₹ 480/kg",R.mipmap.kesar,480));
        Sweets.add(new Sweet("Rajaadi peda","₹ 360/kg",R.mipmap.rajaadi,360));
        Sweets.add(new Sweet("Ghari","₹ 480/kg",R.mipmap.ghari,480));
        Sweets.add(new Sweet("Milk cake","₹ 440/kg",R.mipmap.milk,440));
        Sweets.add(new Sweet("Angir barfi","₹ 480/kg",R.mipmap.angir,480));
        Sweets.add(new Sweet("Butterscotch barfi","₹ 400/kg",R.mipmap.butterscotch,400));
        Sweets.add(new Sweet("Oreo barfi","₹ 400/kg",R.mipmap.oreo,400));
        Sweets.add(new Sweet("Bombay halvo","₹ 400/kg",R.mipmap.bombay,400));
        SweetAdapter sweetAdapter =
                new SweetAdapter (this,Sweets);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(sweetAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sweet sweet=Sweets.get(position);
                Intent intu=new Intent(SweetActivity.this,OrderActivity.class);
                intu.putExtra("price",sweet.getintPrice());
                intu.putExtra("item",sweet.getSweet());
                startActivity(intu);
            }
        });
    }
}
