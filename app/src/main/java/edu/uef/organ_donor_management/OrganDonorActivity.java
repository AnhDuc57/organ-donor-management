package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import edu.uef.adapter.OrganDonorAdapter;
import edu.uef.dao.OrganDonorDao;
import edu.uef.entity.OrganDonor;
import edu.uef.entity.Person;

public class OrganDonorActivity extends AppCompatActivity {
    Button btAddPeople;
    Button btBackDisplayFromOrganDonor;
    private ListView lvOrganDonor;
    private List<OrganDonor> organDonorList;
    private OrganDonorAdapter adapter;
    private OrganDonorDao odDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organ_donor);
        btAddPeople = (Button) findViewById(R.id.buttonAddPeople);
        lvOrganDonor= findViewById(R.id.listViewOrganDonor);

        odDao= new OrganDonorDao(OrganDonorActivity.this);
        try {
            organDonorList =odDao.findAll();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        adapter = new OrganDonorAdapter(getApplicationContext(), organDonorList);
        lvOrganDonor.setAdapter(adapter);

        btAddPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(OrganDonorActivity.this, AddActivity.class);
                startActivity(send);
            }
        });
        btBackDisplayFromOrganDonor = (Button) findViewById(R.id.buttonBackDisplay);
        btBackDisplayFromOrganDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(OrganDonorActivity.this, DisplayActivity.class);
                startActivity(send);
            }
        });
        String[] arraySpinner = new String[] {
                "All", "Hands", "Face", "Kidneys", "Liver", "Lungs", "Heart", "Pancreas", "Eyes", "Tissues", "Stem cells"
                , "Cords", "Bone marrow", "Blood", "Platelets"
        };
        Spinner s = (Spinner) findViewById(R.id.spinnerType);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}