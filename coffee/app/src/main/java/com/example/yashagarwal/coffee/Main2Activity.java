package com.example.yashagarwal.coffee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String SearchQueryTerm=null,Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Recheck");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            SearchQueryTerm = extras.getString("SearchQueryTerm");
            Name = extras.getString("Name");
        }
        TextView textView=(TextView) findViewById(R.id.order_summary) ;
        textView.setText(SearchQueryTerm);
    }
    public void confirm(View v){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:yagarwal687@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for " + Name);
        intent.putExtra(Intent.EXTRA_TEXT, SearchQueryTerm);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

