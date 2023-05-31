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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Lab5_bai2 extends AppCompatActivity {

    ListView lvSinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai2);
        lvSinhVien = findViewById(R.id.lvSinhVien);
        Button btnThem = findViewById(R.id.btnThemMoi);

        Intent intent = this.getIntent();

        String name = intent.getStringExtra(Lab5_bai1.KEY_NAME);
        String diaChi = intent.getStringExtra(Lab5_bai1.KEY_DIACHI);
        String title = intent.getStringExtra(Lab5_bai1.KEY_TITLE);

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Fpoly Hà Nội", "hieu", "ca mau"));
        list.add(new Student("Fpoly Hà Nội", "hieu", "hcm"));
        list.add(new Student("Fpoly Hà Nội", "hieu", "hai phong"));
        list.add(new Student("Fpoly Hà Nội", "hieu", "Nam Định"));
        list.add(new Student(title, name, diaChi));


        StudentAdapter adapter = new StudentAdapter(this, list);
        lvSinhVien.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lab5_bai2.this, Lab5_bai1.class));
            }
        });
    }

    public class Student {
        private String title;
        private String name;
        private String diaChi;

        public Student(String title, String name, String diaChi) {
            this.title = title;
            this.name = name;
            this.diaChi = diaChi;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDiaChi() {
            return diaChi;
        }

        public void setDiaChi(String diaChi) {
            this.diaChi = diaChi;
        }
    }

    public class StudentAdapter extends BaseAdapter {

        private Context ctx;
        private ArrayList<Student> list;

        public StudentAdapter(Context ctx, ArrayList<Student> list) {
            this.ctx = ctx;
            this.list = list;
        }

        public Context getCtx() {
            return ctx;
        }

        public void setCtx(Context ctx) {
            this.ctx = ctx;
        }

        public ArrayList<Student> getList() {
            return list;
        }

        public void setList(ArrayList<Student> list) {
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
            convertView = inflater.inflate(R.layout.thong_tin, parent, false);

            Student thongTin = list.get(position);
            TextView txttitle = convertView.findViewById(R.id.txttitle);
            TextView txtname = convertView.findViewById(R.id.username);
            TextView txtdiaChi = convertView.findViewById(R.id.txtdiachi);
            Button btnXoa = convertView.findViewById(R.id.btnDelete);
            Button btnUpdate = convertView.findViewById(R.id.btnUpdate);

            if (thongTin != null) {
                txttitle.setText(thongTin.getTitle());
                txtname.setText(thongTin.getName());
                txtdiaChi.setText(thongTin.diaChi);
            }

            btnXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = lvSinhVien.getPositionForView((View) v.getParent());
                    if (position >= 0) {
                        list.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(Lab5_bai2.this, "Da Xoa thanh cong !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Lab5_bai2.this, "Chua chon ptu can xoa", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Lab5_bai2.this, sua_thong_tin.class);
                    startActivity(intent);

                    Intent intent1 = getIntent();
                    String name_sua = intent1.getStringExtra(sua_thong_tin.KEY_NAME);
                    String diaChi_sua = intent1.getStringExtra(sua_thong_tin.KEY_DIACHI);
                    String title_sua = intent1.getStringExtra(sua_thong_tin.KEY_TITLE);

                    int position = lvSinhVien.getPositionForView((View) v.getParent());
                    Student student = list.get(position);

                    student.setTitle(title_sua);
                    student.setName(name_sua);
                    student.setDiaChi(diaChi_sua);

                    notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }
}