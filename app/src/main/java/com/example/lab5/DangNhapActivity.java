package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangNhapActivity extends AppCompatActivity {


    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);


        EditText edtname = findViewById(R.id.edtname_signin);
        EditText edtpass = findViewById(R.id.edtpass_signin);
        Button btndangnhap = findViewById(R.id.btndangnhap);
        Button btndangky = findViewById(R.id.btndangky);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString(DangKyActivity.KEY_USERNAME);
            password = bundle.getString(DangKyActivity.KEY_PASSWORD);
        }
        edtname.setText(username);
        edtpass.setText(password);

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangNhapActivity.this,DangKyActivity.class));
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                String pass = edtpass.getText().toString();

                if (name.trim().isEmpty()) {
                    Toast.makeText(DangNhapActivity.this, "Chua nhap tai khoan", Toast.LENGTH_SHORT).show();
                } else if (pass.trim().isEmpty()) {
                    Toast.makeText(DangNhapActivity.this, "Chua nhap mat khau", Toast.LENGTH_SHORT).show();
                } else if (!name.equals(username) && !pass.equals(password)) {
                    Toast.makeText(DangNhapActivity.this, "Sai tai khoan hoac mat khau", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DangNhapActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DangNhapActivity.this, bai2.class));
                }
            }
        });
    }
}