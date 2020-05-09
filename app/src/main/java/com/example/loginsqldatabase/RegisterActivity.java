package com.example.loginsqldatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button login, register;
    EditText username, password, passwordKonfirmasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.et_usernameRegist);
        password = (EditText)findViewById(R.id.et_passwordRegist);
        passwordKonfirmasi = (EditText) findViewById(R.id.et_passwordkonfirmasiRegist);
        login = (Button)findViewById(R.id.btn_loginRegist);
        register = (Button)findViewById(R.id.btn_registerRegist);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, Login.class);
                startActivity(loginIntent);
                finish();
            }
        });

        //Register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strpasswordKonfirmasi = passwordKonfirmasi.getText().toString();
                if(strPassword.equals(strpasswordKonfirmasi)){
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if(daftar = true){
                        Toast.makeText(getApplicationContext(),"Daftar Berhasil", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
