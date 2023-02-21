package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VisceraActivity extends AppCompatActivity {
    Button btAddViscera;
    Button btBackDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viscera);
        btAddViscera = (Button) findViewById(R.id.buttonAddViscera);
        btAddViscera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(VisceraActivity.this, AddVisceraActivity.class);
                startActivity(send);
            }
        });
        btBackDisplay = (Button) findViewById(R.id.buttonBackDisplayFromVisera);
        btBackDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(VisceraActivity.this, DisplayActivity.class);
                startActivity(send);
            }
        });
    }
}