package edu.uef.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import edu.uef.entity.OrganDonor;
import edu.uef.helper.DBHelper;

public class OrganDonorDao {
    private DBHelper db;

    public OrganDonorDao(Context context)
    {
        db = new DBHelper(context);
    }

    public int insertOD(OrganDonor organDonor) {
        SQLiteDatabase db =this.db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", organDonor.getFirstName() + "");
        contentValues.put("lastName", organDonor.getLastName() + "");
        contentValues.put("gender", organDonor.isGender() + "");
        contentValues.put("birthday", organDonor.getBirthday()+"");
        contentValues.put("address", organDonor.getAddress() + "");
        contentValues.put("phoneNumber", organDonor.getPhoneNumber() + "");
        contentValues.put("email", organDonor.getEmail()+ "");

        int res = (int) db.insert("organ_donor", null, contentValues);
        db.close();
        return res;
    }

    public List<OrganDonor> findAll() throws ParseException {
        String sql= "Select * From organ_donor";
        List<OrganDonor> organDonorList= new ArrayList<OrganDonor>();
        SQLiteDatabase database= db.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql,null);
        SimpleDateFormat df = new SimpleDateFormat("EE MMM dd HH:mm:ss yyyy");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int idOD= cursor.getInt(0);
                String firstNameOD =cursor.getString(1);
                String lastNameOD =cursor.getString(2);
                int genderNameOD = cursor.getInt(3);
                Date birthdayOD = new Date(cursor.getLong(4)*1000);
                String addressOD =cursor.getString(5);
                String phoneNumberOD =cursor.getString(6);
                String emailOD =cursor.getString(7);
                OrganDonor organDonor = new OrganDonor(idOD,firstNameOD,lastNameOD,genderNameOD,birthdayOD,addressOD,phoneNumberOD,emailOD);
                organDonorList.add(organDonor);
                cursor.moveToNext();
            }
        }
        return organDonorList;
    }
}
