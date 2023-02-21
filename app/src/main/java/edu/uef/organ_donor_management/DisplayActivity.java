package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
    Button btOrganDonor;
    Button btViscera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        btOrganDonor = (Button) findViewById(R.id.buttonOrganDonor);
        btOrganDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(DisplayActivity.this, OrganDonorActivity.class);
                startActivity(send);
            }
        });
        btViscera = (Button) findViewById(R.id.buttonViscera);
        btViscera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(DisplayActivity.this, VisceraActivity.class);
                startActivity(send);
            }
        });
    }
}