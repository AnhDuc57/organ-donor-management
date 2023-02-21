package edu.uef.organ_donor_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Thread;
import java.util.Date;

import edu.uef.dao.UserDao;
import edu.uef.entity.Manager;

public class LoginActivity extends AppCompatActivity {
    Button btlogin;
    EditText txtUsername;
    EditText txtPass;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
//        Manager manager = new Manager("Anh", "Duc", 1, new Date(), "BT", "0900990900", "aduc@gmail.com", "aduc", "aduc");
//        userDao.insertUser(manager);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username= txtUsername.getText().toString();
                String pass= txtPass.getText().toString();

                Manager manager= userDao.getAuthorById(username);
                if(manager!= null && manager.getPassword().equals(pass)){
                    Intent send = new Intent(LoginActivity.this, DisplayActivity.class);
                    startActivity(send);
                    Toast.makeText(LoginActivity.this, "Login Sucessfully",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Login fail!",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private void init(){
        btlogin = (Button) findViewById(R.id.buttonLogin);
        userDao= new UserDao(this.getApplicationContext());
        txtUsername= findViewById(R.id.txtUsername);
        txtPass= findViewById(R.id.txtPass);
    }
}