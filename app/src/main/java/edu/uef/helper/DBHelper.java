package edu.uef.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "OrganDonerManagement.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table managers(\n" +
                "\tmanagerID integer primary key AUTOINCREMENT,\n" +
                "\tfirstName NVARCHAR(50),\n" +
                "\tlastName NVARCHAR(50),gender TINYINT,\n" +
                "\tbirthday date,address NVARCHAR(50),\n" +
                "\tphoneNumber NVARCHAR(50),\n" +
                "\temail NVARCHAR(50),\n" +
                "userName NVARCHAR(50),password NVARCHAR(50))");
        sqLiteDatabase.execSQL("create table organ_donor(\n" +
                "\t organDonorID integer primary key AUTOINCREMENT,\n" +
                "\t firstName NVARCHAR(50),\n" +
                "\t lastName NVARCHAR(50),\n" +
                "\t gender TINYINT,\n" +
                "\t birthday date,\n" +
                "\t address NVARCHAR(50),\n" +
                "\t phoneNumber NVARCHAR(50),\n" +
                "\t email NVARCHAR(50)\n" +
                ")");
        sqLiteDatabase.execSQL("create table viscera(\n" +
                "\tvisceraID integer primary key AUTOINCREMENT,\n" +
                "\tname NVARCHAR(50),\n" +
                "\torganType NVARCHAR(50),\n" +
                "\tquantity int\n" +
                ")");
        sqLiteDatabase.execSQL("create table organ_donor_viscera(\n" +
                "\torganDonorID integer not null, \n" +
                "\tvisceraID integer not null,\n" +
                "\tCONSTRAINT PK_organDonorID_visceraID PRIMARY KEY (organDonorID,visceraID),\n" +
                "\tCONSTRAINT FK_organ_donor FOREIGN KEY (organDonorID) REFERENCES organ_donor (organDonorID),\n" +
                "\tCONSTRAINT FK_viscera FOREIGN KEY (visceraID) REFERENCES viscera (visceraID)\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists managers");
        sqLiteDatabase.execSQL("drop table if exists organ_donor");
        sqLiteDatabase.execSQL("drop table if exists viscera");
        sqLiteDatabase.execSQL("drop table if exists organ_donor_viscera");
        onCreate(sqLiteDatabase);
    }
}
