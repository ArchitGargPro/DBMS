package com.archit.myapplication;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Action extends AppCompatActivity {

    String[] editList ;
    String editor;
    Double percenT;
    Integer yeaR;
    String dbString;
    MyDBHandler db;
    Products row;
    String statement1 = "Enter Roll No. to ";
    String statement2 = " data and click button ";
    String act = "";
    TextView head ;
    String stat;
    Button but;
    Button viewDB;
    Button saveButton;
    EditText input;
    String entry="";
    Intent i;
    LinearLayout l;
    ConstraintLayout c;
    EditText percentage;
    String percent = "00.00";
    String name = "";
    EditText Ename;
    String year = "1";
    EditText yr;
    String phone = "";
    EditText Ephone;
    String address = "";
    EditText Eaddress;
    String DOB = "0000-00-00";
    EditText Edob;
    String rollno = "";
    EditText Eroll;
    Boolean NSS = Boolean.FALSE;
    CheckBox Cnss;
    Boolean council = Boolean.FALSE;
    CheckBox Ccouncil;

    public void viewDB(View view)
    {
        Log.i("here", "1");
        db = new MyDBHandler(this,null,null,1);
        dbString = db.databaseToStringComp();

        Log.i("here", " DONE ");
        i = new Intent(this, Viewing.class);
        i.putExtra("text", dbString);
        startActivity(i);
    }

    public void go(View view)
    {
        entry = input.getText().toString();

        switch (act)
        {
            case "VIEW":
                vieW(entry);
                break;
            case "ADD":
                add();
                break;
            case "DELETE":
                delete(entry);
                Toast.makeText(this, "Row deleted from database", Toast.LENGTH_SHORT).show();
                break;
            case "EDIT":
                update();
                break;
            default:
                Toast.makeText(this, "Enter Name to "+act, Toast.LENGTH_SHORT).show();
        }
    }

    public void getData(String roll)
    {
        //retrieve data from database where roll number = roll
        db = new MyDBHandler(this,null,null,1);
        editor = db.editor(roll);
        Log.i("here", roll);
    }

    public void update()
    {
        add();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatE();
            }
        });
    }

    public void updatE()
    {
        Log.i("here", "1");
        // GET VALUES OF THIS ROLL NO AND SET VARIABLES
        getData(Eroll.getText().toString());
        editList = editor.split("X");

        for(int i = 0 ; i<9 ; i++)
        {
            Log.i("heeeeeeeeere",editList[i]);
        }

        Log.i("here","2"+editor+"2");

        rollno = editList[0];
        name = editList[1];
        address = editList[2];
        phone = editList[3];
        DOB = editList[4];
        if(editList[5].equalsIgnoreCase("true")||editList[5].equalsIgnoreCase("1")) {
            NSS = Boolean.TRUE;
        }else{
            NSS = Boolean.FALSE;
        }
        if(editList[6].equalsIgnoreCase("true")||editList[6].equalsIgnoreCase("1")) {
            council = Boolean.TRUE;
        }else{
            council = Boolean.FALSE;
        }
        year = editList[7];
        percent = editList[8];

        Log.i("here","3");
        // OVERRIDE VARIABLES WHICH ARE NOT NULL
        rollno = Eroll.getText().toString();
        if(!Ename.getText().toString().equals(""))
        name = Ename.getText().toString();
        if(!Ephone.getText().toString().equals(""))
        phone = Ephone.getText().toString();
        if(!Eaddress.getText().toString().equals(""))
        address = Eaddress.getText().toString();
        if(!Edob.getText().toString().equals(""))
        DOB = Edob.getText().toString();
        if(!Cnss.getText().toString().equals(""))
        NSS = Cnss.isChecked();
        if(!Ccouncil.getText().toString().equals(""))
        council = Ccouncil.isChecked();
        if(!percentage.getText().toString().equals(""))
        percent = percentage.getText().toString();
        if(!yr.getText().toString().equals(""))
        year = yr.getText().toString();
        //

        Log.i("here","4");
        //delete row with rollno
        delete(rollno);

        Log.i("here","5");
        //add as new entry
        try {
            Log.i("here","000000");
            yeaR = Integer.parseInt(year);
            Log.i("here","111111");
            percenT = Double.parseDouble(percent);
            Log.i("here", "222222");
        }
        catch(Exception e)
        {
            Log.i("ERROR    <<<<" , e.toString());
        }
        try {
            ad();
        }
        catch (Exception e)
        {
            Log.i("ERROR     >>>>>>" , e.toString());
            Toast.makeText(this, "Duplicate/Incorrect Entries", Toast.LENGTH_SHORT).show();
        }

        c.setVisibility(View.VISIBLE);
        l.setVisibility(View.INVISIBLE);

        Log.i("here","6");
    }

    public void swich(View view)
    {
        //
        name = Ename.getText().toString();
        phone = Ephone.getText().toString();
        address = Eaddress.getText().toString();
        DOB = Edob.getText().toString();
        rollno = Eroll.getText().toString();
        NSS = Cnss.isChecked();
        council = Ccouncil.isChecked();
        percent = percentage.getText().toString();
        year = yr.getText().toString();
        //

        try {
            yeaR = Integer.parseInt(year);
            percenT = Double.parseDouble(percent);
        }
        catch(Exception e)
        {
            Log.i("ERROR    <<<<" , e.toString());
        }
        try {
            ad();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Duplicate/Incorrect/Void Entries", Toast.LENGTH_SHORT).show();
        }

        c.setVisibility(View.VISIBLE);
        l.setVisibility(View.INVISIBLE);

        Toast.makeText(this, "Added to Database", Toast.LENGTH_SHORT).show();
    }

    public void vieW(String rollNo)
    {
        //View the database where name == value Entered
        db = new MyDBHandler(this,null,null,1);
        dbString = db.databaseToString(rollNo);

        i = new Intent(this, Viewing.class);
        i.putExtra("text", dbString);
        startActivity(i);
    }

      public void add()
    {
        //make other entries visible and add to database
        //name
        //rollno
        //address
        //phone
        //DOB
        //NSS
        //council
        //percent
        //year
        c.setVisibility(View.INVISIBLE);
        l.setVisibility(View.VISIBLE);
    }

    private void ad()
    {
        row = new Products(rollno, name, address, phone, DOB, NSS, council, percenT, yeaR);
        db.addProduct(row);
    }

    public void delete(String rollNo)
    {
        //Delete the row where name == entered value
        db = new MyDBHandler(this,null,null,1);
        db.deleteProduct(rollNo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        //
        Ename = findViewById(R.id.Name);
        Ephone = findViewById(R.id.pn);
        percentage = findViewById(R.id.percentage);
        Eaddress = findViewById(R.id.address);
        Edob = findViewById(R.id.dob);
        Eroll = findViewById(R.id.rollN);
        Cnss = findViewById(R.id.nssc);
        Ccouncil = findViewById(R.id.mosc);
        yr = findViewById(R.id.yr);
        l = findViewById(R.id.l);
        c = findViewById(R.id.c);
        saveButton = findViewById(R.id.save);
        input = findViewById(R.id.entry);
        head = findViewById(R.id.head);
        but = findViewById(R.id.button);
        viewDB = findViewById(R.id.db);
        //

        db = new MyDBHandler(this,null,null,1);

        //
        name = Ename.getText().toString();
        phone = Ephone.getText().toString();
        address = Eaddress.getText().toString();
        DOB = Edob.getText().toString();
        rollno = Eroll.getText().toString();
        NSS = Cnss.isChecked();
        council = Ccouncil.isChecked();
        percent = percentage.getText().toString();
        year = yr.getText().toString();
        //

        act = getIntent().getStringExtra("action");
        stat = statement1+act+statement2+act;
        head.setText(stat);
        but.setText(act);
        l.setVisibility(View.INVISIBLE);

        if(act.equals("EDIT")||act.equals("ADD"))
        {
            input.setVisibility(View.INVISIBLE);
        }
        else
        {
            input.setVisibility(View.VISIBLE);
        }
    }
}