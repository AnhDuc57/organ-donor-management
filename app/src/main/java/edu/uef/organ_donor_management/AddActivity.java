package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.uef.dao.OrganDonorDao;
import edu.uef.entity.OrganDonor;

public class AddActivity extends AppCompatActivity {
    Button btAddAccept;
    Button btBackOrganDonor;
    EditText txtName;
    RadioButton ronGender;
    EditText txtBirth;
    EditText txtAdd;
    EditText txtPhone;
    EditText txtEmail;
    private OrganDonorDao donorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        connectUi();
        btAddAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrganDonor organDonor= null;
                try {
                    organDonor = getOrganDonorFromUi();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                int res= donorDao.insertOD(organDonor);
                if(res>0){
                    Intent send = new Intent(AddActivity.this, OrganDonorActivity.class);
                    startActivity(send);
                    Toast.makeText(AddActivity.this, "Add Sucessfully", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(AddActivity.this, "Add fail!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btBackOrganDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(AddActivity.this, OrganDonorActivity.class);
                startActivity(send);
            }
        });
    }
    private OrganDonor getOrganDonorFromUi() throws ParseException {

           DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
           OrganDonor organDonor= new OrganDonor();
           organDonor.setAddress(txtAdd.getText().toString());
           organDonor.setBirthday(df.parse(txtBirth.getText().toString()));
           organDonor.setEmail(txtEmail.getText().toString());
           organDonor.setPhoneNumber(txtPhone.getText().toString());
           organDonor.setGender(ronGender.isChecked()?0:1);
           organDonor.setLastName(" ");
           organDonor.setFirstName(txtName.getText().toString());
           System.out.println(organDonor);

           return organDonor;


    }
    private void connectUi(){
        donorDao= new OrganDonorDao(this.getApplicationContext());
        btAddAccept = (Button) findViewById(R.id.buttonAddAccept);
        btBackOrganDonor = (Button) findViewById(R.id.buttonBackOrganDonor);
        txtName= findViewById(R.id.txtFirstName);
        ronGender= findViewById(R.id.radioButton6);
        txtBirth= findViewById(R.id.editTextDate2);
        txtAdd= findViewById(R.id.editTextUser14);
        txtPhone= findViewById(R.id.editTextUser11);
        txtEmail= findViewById(R.id.editTextUser12);

    }
}