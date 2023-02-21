package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import edu.uef.helper.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper=new DBHelper(this.getApplicationContext());
        Intent send = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(send);
    }
}