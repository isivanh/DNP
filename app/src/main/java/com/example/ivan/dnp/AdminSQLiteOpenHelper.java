package com.example.ivan.dnp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, nombre, factory, version);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table user(UserCode integer primary key UNIQUE, UserNAme CHAR(60) NOT NULL, UserImage CHAR(60), UserCategoria CHAR(60))");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists user");

        db.execSQL("create table usuario(dni integer primary key, nombre text, ciudad text, numero integer)");

    }
}
