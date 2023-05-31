package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class sua_thong_tin extends AppCompatActivity {


    public static String KEY_NAME = "name_sua";
    public static String KEY_DIACHI = "diaChi_sua";
    public static String KEY_TITLE = "title_sua";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin);

        Spinner spinner = findViewById(R.id.spinner_sua);
        TextInputEditText edtname_sua = findViewById(R.id.edt_username_sua);
        TextInputEditText edtdiaChi_sua = findViewById(R.id.edt_diaChi_sua);
        Button button = findViewById(R.id.btnsubmit_sua);

        ArrayList<Lab5_bai1.noi_Hoc> list = new ArrayList<>();
        list.add(new Lab5_bai1.noi_Hoc("Fpoly Hà Nội", R.drawable.england));
        list.add(new Lab5_bai1.noi_Hoc("Fpoly Đà Nẵng", R.drawable.vietnam));
        list.add(new Lab5_bai1.noi_Hoc("Fpoly Tây Nguyên", R.drawable.japan));
        list.add(new Lab5_bai1.noi_Hoc("Fpoly Cần Thơ", R.drawable.france));

        Lab5_bai1.noiHocAdapter adapter = new Lab5_bai1.noiHocAdapter(this, list);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname_sua.getText().toString();
                String diaChi = edtdiaChi_sua.getText().toString();
                String title = spinner.getSelectedItem().toString();

                Intent intent = new Intent(sua_thong_tin.this, Lab5_bai2.class);
                intent.putExtra(KEY_NAME, name);
                intent.putExtra(KEY_DIACHI, diaChi);
                intent.putExtra(KEY_TITLE, title);
                startActivity(intent);
            }
        });

    }
}