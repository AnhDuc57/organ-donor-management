package edu.uef.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import edu.uef.entity.Manager;
import edu.uef.entity.OrganDonor;
import edu.uef.helper.DBHelper;

public class UserDao {
    private DBHelper db;

    public UserDao(Context context) {
        db = new DBHelper(context);
//        Manager manager = new Manager("Anh", "Duc", 1, new Date(), "BT", "0900990900", "aduc@gmail.com", "aduc", "aduc");
//        insertUser(manager);
    }

    public int insertUser(Manager manager) {
        SQLiteDatabase db = this.db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", manager.getFirstName() + "");
        contentValues.put("lastName", manager.getLastName() + "");
        contentValues.put("gender", manager.isGender() + "");
        contentValues.put("birthday", manager.getBirthday() + "");
        contentValues.put("address", manager.getAddress() + "");
        contentValues.put("phoneNumber", manager.getPhoneNumber() + "");
        contentValues.put("email", manager.getEmail() + "");
        contentValues.put("userName", manager.getUserName() + "");
        contentValues.put("password", manager.getPassword() + "");

        int res = (int) db.insert("managers", null, contentValues);
        db.close();
        return res;
    }

    public Manager getAuthorById(String username) {
        Manager manager = null;
        String sql = "select * from managers where userName=?";
        SQLiteDatabase db = this.db.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{username + ""});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int idOD = cursor.getInt(0);
                String firstName = cursor.getString(1);
                String lastName = cursor.getString(2);
                int genderName = cursor.getInt(3);
                Date birthday = new Date(cursor.getLong(4) * 1000);
                String address = cursor.getString(5);
                String phoneNumber = cursor.getString(6);
                String email = cursor.getString(7);
                String userName = cursor.getString(8);
                String password = cursor.getString(9);
                manager = new Manager(idOD, firstName, lastName, genderName, birthday, address, phoneNumber, email, userName, password);
                cursor.moveToNext();

            }
        }
        db.close();
        return manager;
    }

    public List<Manager> findAll() throws ParseException {
        String sql = "Select * From mamagers";
        List<Manager> users = new ArrayList<Manager>();
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int idOD = cursor.getInt(0);
                String firstName = cursor.getString(1);
                String lastName = cursor.getString(2);
                int genderName = cursor.getInt(3);
                Date birthday = new Date(cursor.getLong(4) * 1000);
                String address = cursor.getString(5);
                String phoneNumber = cursor.getString(6);
                String email = cursor.getString(7);
                String userName = cursor.getString(7);
                String password = cursor.getString(7);
                Manager manager = new Manager(idOD, firstName, lastName, genderName, birthday, address, phoneNumber, email, userName, password);
                users.add(manager);
                cursor.moveToNext();
            }
        }
        return users;
    }
}
