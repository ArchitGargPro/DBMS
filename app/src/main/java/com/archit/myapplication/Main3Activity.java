package com.archit.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Intent i;
    String head;
    TextView h;
    Button view;
    Button add;
    Button delete;
    Button edit;
    Button exit;

    public void view(View view)
    {
        i = new Intent(this, Action.class);
        i.putExtra("action", "VIEW");
        startActivity(i);
    }

    public void Exit(View view)
    {
        i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void add(View view)
    {
        i = new Intent(this, Action.class);
        i.putExtra("action", "ADD");
        startActivity(i);
    }

    public void edit(View view)
    {
        i = new Intent(this, Action.class);
        i.putExtra("action", "EDIT");
        startActivity(i);
    }

    public void del(View view)
    {
        i = new Intent(this, Action.class);
        i.putExtra("action", "DELETE");
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        h = findViewById(R.id.Head);
        head = getIntent().getStringExtra("stream");
        h.setText(head);

        view = findViewById(R.id.view);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.del);
        exit = findViewById(R.id.exit);
        edit = findViewById(R.id.editButton);

    }
}
