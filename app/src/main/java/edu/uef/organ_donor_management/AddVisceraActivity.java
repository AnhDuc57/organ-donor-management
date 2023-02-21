package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AddVisceraActivity extends AppCompatActivity {
    Button btBackVisera;
    Button btAcceptVisera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_viscera);
        String[] arraySpinner = new String[] {
                "All", "Hands", "Face", "Kidneys", "Liver", "Lungs", "Heart", "Pancreas", "Eyes", "Tissues", "Stem cells"
                , "Cords", "Bone marrow", "Blood", "Platelets"
        };
        Spinner s = (Spinner) findViewById(R.id.spinnerViscera);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        btAcceptVisera = (Button) findViewById(R.id.buttonAddAcceptVisera);
        btAcceptVisera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(AddVisceraActivity.this, VisceraActivity.class);
                startActivity(send);
                Toast.makeText(AddVisceraActivity.this, "Add Sucessfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}