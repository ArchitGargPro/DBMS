package com.archit.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Viewing extends AppCompatActivity {

    FloatingActionButton fab;
    TextView data;
    String db = "";

    void viu()
    {
        //view whole database
        Log.i("here", ",,,,,,,,,,,,,,,");
        data.setText(db);
        Log.i("here", "data set");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing);

        Log.i("here", "kjhgabkuhvdbk");
        data = findViewById(R.id.texxt);
        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.about, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        db = getIntent().getStringExtra("text");
        Log.i("here", ".....................");
        viu();
    }
}
