package com.example.lab5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class bai1 extends AppCompatActivity {


    public static String KEY_NAME = "name";
    public static String KEY_DIACHI = "diaChi";
    public static String KEY_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai1);

        Spinner spinner = findViewById(R.id.spinner_queQuan);
        EditText edtname = findViewById(R.id.edt_username);
        EditText edtdiachi = findViewById(R.id.edt_diaChi);
        Button btnSubmit = findViewById(R.id.btnsubmit);


        ArrayList<noi_Hoc> list = new ArrayList<>();
        list.add(new noi_Hoc("Fpoly Hà Nội", R.drawable.france));
        list.add(new noi_Hoc("Fpoly Đà Nẵng", R.drawable.japan));
        list.add(new noi_Hoc("Fpoly Tây Nguyên", R.drawable.vietnam));
        list.add(new noi_Hoc("Fpoly Cần Thơ", R.drawable.england));

        noiHocAdapter adapter = new noiHocAdapter(this,list);
        spinner.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                String diaChi = edtdiachi.getText().toString();
//                String title = spinner.getSelectedItem().toString();
                noi_Hoc noi_hoc = (noi_Hoc) spinner.getSelectedItem();
                String title = noi_hoc.getName();
//                String cs = coso.getText().toString();
                Intent intent = new Intent(bai1.this, bai2.class);
                intent.putExtra(KEY_NAME,name);
                intent.putExtra(KEY_DIACHI,diaChi);
                intent.putExtra(KEY_TITLE,title);
                startActivity(intent);
            }
        });
    }

    public static class noi_Hoc {
        private String name;
        private int imglogo;

        public noi_Hoc() {
        }

        public noi_Hoc(String name, int imglogo) {
            this.name = name;
            this.imglogo = imglogo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getImglogo() {
            return imglogo;
        }

        public void setImglogo(int imglogo) {
            this.imglogo = imglogo;
        }
    }

    public static class noiHocAdapter extends BaseAdapter {

        private Context ctx;
        private ArrayList<noi_Hoc> list;

        public noiHocAdapter(Context ctx, ArrayList<noi_Hoc> list) {
            this.ctx = ctx;
            this.list = list;
        }

        public Context getCtx() {
            return ctx;
        }

        public void setCtx(Context ctx) {
            this.ctx = ctx;
        }

        public ArrayList<noi_Hoc> getList() {
            return list;
        }

        public void setList(ArrayList<noi_Hoc> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
            convertView = inflater.inflate(R.layout.spinner_que_quan, parent, false);

            noi_Hoc thongtin = list.get(position);
            TextView txtname = convertView.findViewById(R.id.txtname);
            ImageView imageView = convertView.findViewById(R.id.imglogo);

            if (thongtin != null) {
                txtname.setText(thongtin.getName());
                imageView.setImageResource(thongtin.getImglogo());
            }
            return convertView;
        }
    }
}