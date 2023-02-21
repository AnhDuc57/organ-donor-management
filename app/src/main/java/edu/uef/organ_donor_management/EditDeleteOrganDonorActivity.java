package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditDeleteOrganDonorActivity extends AppCompatActivity {
    Button btAddAccept;
    Button btBackOrganDonor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_organ_donor);
        btAddAccept = (Button) findViewById(R.id.buttonAddAccept);
        btAddAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(EditDeleteOrganDonorActivity.this, OrganDonorActivity.class);
                startActivity(send);
                Toast.makeText(EditDeleteOrganDonorActivity.this, "Edit Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });
        btBackOrganDonor = (Button) findViewById(R.id.buttonBackOrganDonor);
        btBackOrganDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(EditDeleteOrganDonorActivity.this, OrganDonorActivity.class);
                startActivity(send);
            }
        });
    }
}