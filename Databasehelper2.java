package com.example.a4buttons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "Student.db";
    public static final String TABLE_NAME= "Student_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "NAME";
    public static final String COL_3= "SURNAME";
    public static final String COL_4= "MARKS";


    public Databasehelper2(Context context) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    public Databasehelper2(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER , NAME TEXT, SURNAME TEXT, MARKS INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, "1");
        contentValues.put(COL_2, "21");
        contentValues.put(COL_3, "0");
        contentValues.put(COL_4, "29");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL_1, "2");
        contentValues.put(COL_2, "27");
        contentValues.put(COL_3, "0");
        contentValues.put(COL_4, "33");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL_1, "3");
        contentValues.put(COL_2, "35");
        contentValues.put(COL_3, "20");
        contentValues.put(COL_4, "37");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL_1, "4");
        contentValues.put(COL_2, "41");
        contentValues.put(COL_3, "0");
        contentValues.put(COL_4, "18");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL_1, "5");
        contentValues.put(COL_2, "23");
        contentValues.put(COL_3, "0");
        contentValues.put(COL_4, "24");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL_1, "6");
        contentValues.put(COL_2, "29");
        contentValues.put(COL_3, "15");
        contentValues.put(COL_4, "9");

        db.insert(TABLE_NAME, null, contentValues);

        contentValues.put(COL_1, "7");
        contentValues.put(COL_2, "44");
        contentValues.put(COL_3, "0");
        contentValues.put(COL_4, "20");

        db.insert(TABLE_NAME, null, contentValues);





    }
    public void updateData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, "1");
        contentValues.put(COL_2, "blah");
        contentValues.put(COL_3, "blah");
        contentValues.put(COL_4, "blah");

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{"1"});

        contentValues.put(COL_1, "2");
        contentValues.put(COL_2, "blah");
        contentValues.put(COL_3, "blah");
        contentValues.put(COL_4, "blah");

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{"2"});

        contentValues.put(COL_1, "3");
        contentValues.put(COL_2, "blah");
        contentValues.put(COL_3, "blah");
        contentValues.put(COL_4, "blah");

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{"3"});

        contentValues.put(COL_1, "4");
        contentValues.put(COL_2, "blah");
        contentValues.put(COL_3, "blah");
        contentValues.put(COL_4, "blah");

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{"4"});

        contentValues.put(COL_1, "5");
        contentValues.put(COL_2, "blah");
        contentValues.put(COL_3, "blah");
        contentValues.put(COL_4, "blah");

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{"5"});

        contentValues.put(COL_1, "6");
        contentValues.put(COL_2, "blah");
        contentValues.put(COL_3, "blah");
        contentValues.put(COL_4, "blah");

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{"6"});

        contentValues.put(COL_1, "7");
        contentValues.put(COL_2, "blah");
        contentValues.put(COL_3, "blah");
        contentValues.put(COL_4, "blah");

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{"7"});





    }

    public Cursor getAllData () {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updatedata (String id, String name, String surname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
}
