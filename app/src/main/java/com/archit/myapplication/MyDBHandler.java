package com.archit.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {

    String query;
    SQLiteDatabase database;
    String dbString = "";
    Cursor c;

    //rollno
    //name
    //address
    //phone
    //DOB
    //NSS
    //council
    //percent
    //year

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_CSE = "cse";
    public static final String TABLE_ECE1 = "ece1";
    public static final String TABLE_FACULTY = "faculty";
    public static final String COLUMN_rollno = "_rollno";
    public static final String COLUMN_name = "_name";
    public static final String COLUMN_address = "_address";
    public static final String COLUMN_phone = "_phone";
    public static final String COLUMN_DOB = "_DOB";
    public static final String COLUMN_NSS = "_NSS";
    public static final String COLUMN_council = "_council";
    public static final String COLUMN_percent = "_percent";
    public static final String COLUMN_year = "_year";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query = "CREATE TABLE " + TABLE_CSE + " (" +
                COLUMN_rollno + " INTEGER PRIMARY KEY, " +
                COLUMN_name + " VARCHAR(20), " +
                COLUMN_address + " TEXT, " +
                COLUMN_phone + " VARCHAR(10), " +
                COLUMN_DOB + " DATE, " +
                COLUMN_NSS + " BOOLEAN," +
                COLUMN_council + " BOOLEAN, " +
                COLUMN_percent + " INTEGER, " +
                COLUMN_year + " SMALLINT );" ;
        db.execSQL(query);

        query = "INSERT INTO " + TABLE_CSE + " VALUES (" +
                " '01210102716', " +
                " 'Archit Garg', " +
                " '17,Naya Ganj,Ghaziabad', " +
                " '9891192474', " +
                " '1999-03-17', " +
                " '1', " +
                " '0', " +
                " '64.73', " +
                " '2' );" ;
        db.execSQL(query);

        query = "INSERT INTO " + TABLE_CSE + " VALUES (" +
                " '01110102716', " +
                " 'Anubhav', " +
                " '1 loni', " +
                " '9891133474', " +
                " '1999-05-17', " +
                " '0', " +
                " '0', " +
                " '64.74', " +
                " '2' );" ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CSE + " ;");
        onCreate(db);
    }

    // Add new row
    public void addProduct(Products product)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_name,product.get_name());
        values.put(COLUMN_rollno,product.get_rollno());
        values.put(COLUMN_address,product.get_address());
        values.put(COLUMN_phone,product.get_phone());
        values.put(COLUMN_DOB,product.get_DOB());
        values.put(COLUMN_NSS,product.get_NSS());
        values.put(COLUMN_council,product.get_council());
        values.put(COLUMN_percent,product.get_percent());
        values.put(COLUMN_year,product.get_year());
        database = getWritableDatabase();
        database.insert(TABLE_CSE, null, values);
        database.close();
    }

    // Delete row
    public void deleteProduct(String rollno)
    {
        database = getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_CSE + " WHERE " + COLUMN_rollno + "=\"" + rollno + "\" ;");
        database.close();
    }

    // Print database
    public String databaseToString(String roll)
    {
        dbString="";
        database = getWritableDatabase();
        query = "SELECT * FROM " + TABLE_CSE + " WHERE " + COLUMN_rollno + "=\'" + roll + "\' ;";

        //CURSOR POINT TO A LOCATION IN RESULT
        c = database.rawQuery(query, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("_rollno"))!= null)
            {
                dbString+="Roll no. : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_rollno));
                dbString+="\t  Name : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_name));
                dbString+="\nAddress: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_address));
                dbString+="\nPh.no.: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_phone));
                dbString+="\t      DOB: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_DOB));
                dbString+="\nNSS: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_NSS));
                dbString+="\t                Council: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_council));
                dbString+="\nYear : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_year));
                dbString+="\t                Percentage :";
                dbString+=c.getString(c.getColumnIndex(COLUMN_percent));
                dbString+="%\n.................................................................................\n\n";
                c.moveToNext();
            }
        }
        database.close();
        return dbString;
    }

    public String databaseToStringComp()
    {
        dbString="";
        database = getWritableDatabase();

        query = "SELECT * FROM " + TABLE_CSE + " WHERE 1=1 ;";

        //CURSOR POINT TO A LOCATION IN RESULT
        c = database.rawQuery(query, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("_rollno"))!= null)
            {
                dbString+="Roll no. : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_rollno));
                dbString+="\t  Name : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_name));
                dbString+="\nAddress: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_address));
                dbString+="\nPh.no.: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_phone));
                dbString+="\t      DOB: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_DOB));
                dbString+="\nNSS: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_NSS));
                dbString+="\t                Council: ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_council));
                dbString+="\nYear : ";
                dbString+=c.getString(c.getColumnIndex(COLUMN_year));
                dbString+="\t                Percentage :";
                dbString+=c.getString(c.getColumnIndex(COLUMN_percent));
                dbString+="%\n.................................................................................\n\n";
                c.moveToNext();
            }
        }
        database.close();
        return dbString;
    }

    public String editor(String roll)
    {
        dbString="";
        database = getWritableDatabase();
        query = "SELECT * FROM " + TABLE_CSE + " WHERE " + COLUMN_rollno + "=\'" + roll + "\' ;";

        //CURSOR POINT TO A LOCATION IN RESULT
        c = database.rawQuery(query, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("_rollno"))!= null)
            {
                //dbString+="";
                dbString+=c.getString(c.getColumnIndex(COLUMN_rollno));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_name));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_address));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_phone));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_DOB));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_NSS));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_council));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_year));
                dbString+="X";
                dbString+=c.getString(c.getColumnIndex(COLUMN_percent));
                c.moveToNext();
            }
        }
        database.close();
        return dbString;
    }

}
