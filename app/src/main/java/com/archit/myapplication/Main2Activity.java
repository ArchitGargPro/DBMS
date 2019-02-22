package com.archit.myapplication;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Spinner stream;
    String str;
    //String streams[][] = {{"CSE"}, {"ECE1"}, {"ECE2"}};
    TextView t;
    String s = "Going to database of ";
    Button go;
    Intent i;
    ImageView bg;
    String stat;

    public void go(View view)
    {
        i = new Intent(this ,Main3Activity.class);
        i.putExtra("stream",str);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bg = findViewById(R.id.imageView2);
        stream = findViewById(R.id.spinner);
        t = findViewById(R.id.t);
        go = findViewById(R.id.button);

        stream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str = stream.getSelectedItem().toString();
                stat=s+str;
                t.setText(stat);
                if(str.equals("CSE"))
                {
                    //bg.animate().rotationBy(180).setDuration(500);
                    bg.setImageResource(R.drawable.cse);
                    bg.animate().rotationBy(360).setDuration(800);
                }
                else{
                    //bg.animate().rotationBy(180).setDuration(500);
                    bg.setImageResource(R.drawable.ece);
                    bg.animate().rotationBy(360).setDuration(800);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                str = "CSE";
                t.setVisibility(View.INVISIBLE);
                go.setVisibility(View.INVISIBLE);
            }
        });


    }
}
