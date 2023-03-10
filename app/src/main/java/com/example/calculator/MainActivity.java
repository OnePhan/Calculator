package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtMot, txtHai, txtBa, txtBon,
    txtNam, txtSau, txtBay, txtTam, txtChin, txtKhong, txtBang, txtNhan, txtChia,
    txtCong, txtTru, txtAc, txtCongTru, txtPhantram, txtCham, txtManHinh;
    int chieuDaiChu = 6;
    String sizeChuLon = "90", sizeChuNho = "66", sizeChuLucTinh = "50", sizeChuLandScape = "40";
    String  chuoi, cong, tru, nhan, chia;
    Boolean dauCong = false, dauTru = false, dauChia = false, dauNhan = false,dauBang = false, phanTram = false;
    Float bienGiu, bienTam;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        txtManHinh.setText(sharedPreferences.getString("so",""));
        bienGiu = sharedPreferences.getFloat("bienGiu", 0);
        bienTam = sharedPreferences.getFloat("bienTam", 0);
        String dau = sharedPreferences.getString("dau", null);

        if (dau == "+"){
            cong = "+";
        }
        if (dau == "-"){
            tru = "-";
        }
        if (dau == "*"){
            nhan = "*";
        }
        if (dau == "/"){
            chia = "/";
        }
        xuLyPhim_AC();
        xuLyCoChu();
        ChucNang();
    }

    public void ChucNang(){
        txtAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyPhim_AC();
                if (txtAc.getText().toString() == "AC"){
                    cong = null; tru = null; nhan = null; chia = null;
                    dauCong = false; dauTru = false; dauChia = false; dauNhan = false;
                    bienTam = Float.valueOf(0); bienGiu = Float.valueOf(0);
                    phanTram = false;
                    txtManHinh.setText(null);
                    xoaMau();
                } else if (txtAc.getText().toString() == "C") {
                    txtManHinh.setText(null);
                    lenMau();
                }
                xuLyPhim_AC();
                Luudiem();
            }
        });
        txtMot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "1";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim() +"");
                Luudiem();
            }
        });
        txtHai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "2";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "3";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtBon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "4";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "5";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtSau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "6";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtBay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "7";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtTam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "8";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtChin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                String so = "9";
                xuLyCoChu();
                xuLySo(so);
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }

        });
        txtKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLy_Input();
                xuLyCoChu();
                if (chuoi.length() != 0){
                    if (chuoi.length() != 1 || chuoi.indexOf("0") != 0){
                        if (chuoi.length() < 9){
                            txtManHinh.append("0");
                        }
                    }
                }else {
                    txtManHinh.append("0");
                }
                xuLyPhim_AC();
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
                Luudiem();
            }
        });
        txtPhantram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi = txtManHinh.getText().toString().trim();
                if (chuoi.length() !=0){
                    Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                    Float so = number/100;
                    phanTram = true;
                    chuoi = so+"";
                    if (chuoi.length() >= chieuDaiChu){
                        Configuration configuration = getResources().getConfiguration();
                        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                            txtManHinh.setTextSize(Float.valueOf(sizeChuLandScape));
                        }else {
                            txtManHinh.setTextSize(Float.valueOf(sizeChuLucTinh));
                        }
                    }else{
                        Configuration configuration = getResources().getConfiguration();
                        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                            txtManHinh.setTextSize(Float.valueOf(sizeChuLandScape));
                        }else {
                            txtManHinh.setTextSize(Float.valueOf(sizeChuLon));
                        }
                    }
                    txtManHinh.setText(so+"");
                    Luudiem();
                }
            }
        });
        txtCongTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi = txtManHinh.getText().toString().trim();
                if (chuoi.length() !=0){
                    xuLyAbs();
                }
                Luudiem();
            }
        });
        txtCham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi = txtManHinh.getText().toString().trim();
                int index = chuoi.indexOf(".");
                if ( index < 0){
                    txtManHinh.append(".");
                }
                Luudiem();
            }
        });
        txtCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi = txtManHinh.getText().toString().trim();
                if (chuoi.length() != 0){
                    bienTam = Float.parseFloat(txtManHinh.getText().toString().trim());
                }
                cong = "+"; tru = null; nhan = null; chia = null;
                dauCong = true; dauChia = false; dauNhan = false; dauTru = false;
                lenMau();
                Luudiem();
            }
        });
        txtTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi = txtManHinh.getText().toString().trim();
                if (chuoi.length() != 0){
                    bienTam = Float.parseFloat(txtManHinh.getText().toString().trim());
                }
                tru = "-"; cong = null; nhan = null; chia = null;
                dauCong = false; dauChia = false; dauNhan = false; dauTru = true;
                lenMau();
                Luudiem();
            }
        });
        txtNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi = txtManHinh.getText().toString().trim();
                if (chuoi.length() != 0){
                    bienTam = Float.parseFloat(txtManHinh.getText().toString().trim());
                }
                cong = null; tru = null; nhan = "*"; chia = null;
                dauCong = false; dauChia = false; dauNhan = true; dauTru = false;
                lenMau();
                Luudiem();
            }
        });
        txtChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoi = txtManHinh.getText().toString().trim();
                if (chuoi.length() != 0){
                    bienTam = Float.parseFloat(txtManHinh.getText().toString().trim());
                }
                cong = null; tru = null; nhan = null; chia = "/";
                dauCong = false; dauChia = true; dauNhan = false; dauTru = false;
                lenMau();
                Luudiem();
            }
        });
        txtBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dieuKienTinh();
                chuoi = txtManHinh.getText().toString().trim();
                Configuration configuration = getResources().getConfiguration();
                if (chuoi.length() >= chieuDaiChu){
                    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                        txtManHinh.setTextSize(Float.valueOf(sizeChuLandScape));
                    }else {
                        txtManHinh.setTextSize(Float.valueOf(sizeChuLucTinh));
                    }
                }else{
                    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                        txtManHinh.setTextSize(Float.valueOf(sizeChuLandScape));
                    }else {
                        txtManHinh.setTextSize(Float.valueOf(sizeChuLon));
                    }
                }
                xoaMau();
                dauBang = true;
                Luudiem();
            }
        });
    }
    public void xoaMau(){
        txtCong.setBackgroundResource(R.drawable.custom_pheptinh);
        txtCong.setTextColor(Color.WHITE);
        txtChia.setBackgroundResource(R.drawable.custom_pheptinh);
        txtChia.setTextColor(Color.WHITE);
        txtNhan.setBackgroundResource(R.drawable.custom_pheptinh);
        txtNhan.setTextColor(Color.WHITE);
        txtTru.setBackgroundResource(R.drawable.custom_pheptinh);
        txtTru.setTextColor(Color.WHITE);
    }
    public void xuLy_Input() {
        if (phanTram == true) {
            txtManHinh.setText(null);
            phanTram = false;
        }
        if (dauBang == true) {
            txtManHinh.setText(null);
            dauBang = false;
        }

        if (dauCong == true){
            txtManHinh.setText(null);
            dauCong = false;
            txtCong.setBackgroundResource(R.drawable.custom_pheptinh);
            txtCong.setTextColor(Color.WHITE);
        }

        if (dauTru == true){
            txtManHinh.setText(null);
            dauTru = false;
            txtTru.setBackgroundResource(R.drawable.custom_pheptinh);
            txtTru.setTextColor(Color.WHITE);
        }

        if (dauNhan == true){
            txtManHinh.setText(null);
            dauNhan = false;
            txtNhan.setBackgroundResource(R.drawable.custom_pheptinh);
            txtNhan.setTextColor(Color.WHITE);
        }

        if (dauChia == true){
            txtManHinh.setText(null);
            dauChia = false;
            txtChia.setBackgroundResource(R.drawable.custom_pheptinh);
            txtChia.setTextColor(Color.WHITE);
        }
    }
    public void lenMau(){
        if (cong == "+"){
            txtCong.setBackgroundResource(R.drawable.custom_color);
            txtCong.setTextColor(Color.parseColor("#FFAB40"));
            txtChia.setBackgroundResource(R.drawable.custom_pheptinh);
            txtChia.setTextColor(Color.WHITE);
            txtNhan.setBackgroundResource(R.drawable.custom_pheptinh);
            txtNhan.setTextColor(Color.WHITE);
            txtTru.setBackgroundResource(R.drawable.custom_pheptinh);
            txtTru.setTextColor(Color.WHITE);
        }
        if (tru == "-"){
            txtTru.setBackgroundResource(R.drawable.custom_color);
            txtTru.setTextColor(Color.parseColor("#FFAB40"));

            txtChia.setBackgroundResource(R.drawable.custom_pheptinh);
            txtChia.setTextColor(Color.WHITE);
            txtNhan.setBackgroundResource(R.drawable.custom_pheptinh);
            txtNhan.setTextColor(Color.WHITE);
            txtCong.setBackgroundResource(R.drawable.custom_pheptinh);
            txtCong.setTextColor(Color.WHITE);
        }

        if (nhan == "*"){
            txtNhan.setBackgroundResource(R.drawable.custom_color);
            txtNhan.setTextColor(Color.parseColor("#FFAB40"));

            txtChia.setBackgroundResource(R.drawable.custom_pheptinh);
            txtChia.setTextColor(Color.WHITE);
            txtTru.setBackgroundResource(R.drawable.custom_pheptinh);
            txtTru.setTextColor(Color.WHITE);
            txtCong.setBackgroundResource(R.drawable.custom_pheptinh);
            txtCong.setTextColor(Color.WHITE);
        }

        if (chia == "/"){
            txtChia.setBackgroundResource(R.drawable.custom_color);
            txtChia.setTextColor(Color.parseColor("#FFAB40"));

            txtTru.setBackgroundResource(R.drawable.custom_pheptinh);
            txtTru.setTextColor(Color.WHITE);
            txtNhan.setBackgroundResource(R.drawable.custom_pheptinh);
            txtNhan.setTextColor(Color.WHITE);
            txtCong.setBackgroundResource(R.drawable.custom_pheptinh);
            txtCong.setTextColor(Color.WHITE);
        }
    }
    public void xuLyAbs(){
        chuoi = txtManHinh.getText().toString().trim();
        if (chuoi.indexOf(".") < 0){
            int number = Integer.parseInt(txtManHinh.getText().toString().trim());
            if (number < 0){
                txtManHinh.setText(Math.abs(number) + "");
            }else {
                txtManHinh.setText("-"+number);
            }
        }else {
            Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
            if (number < 0){
                txtManHinh.setText(Math.abs(number) + "");
            }else {
                txtManHinh.setText("-"+number);
            }
        }
    }
    public void xuLySo(String so){
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            txtManHinh.append(so);
        }else{
            if (chuoi.length() != 0){
                if (chuoi.length() < 9){
                    if (chuoi.length() == 1 && chuoi.indexOf("0") == 0) {
                        txtManHinh.setText("");
                        txtManHinh.append(so);
                    }else {
                        txtManHinh.append(so);
                    }
                }
            }else {
                txtManHinh.append(so);
            }
        }

    }
    public void xuLyPhim_AC(){
        chuoi = txtManHinh.getText().toString().trim();
        if (chuoi.length() == 0) {
            txtAc.setText("AC");
        }else {
            txtAc.setText("C");
        }
    }
    public void xuLyCoChu(){
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            txtManHinh.setTextSize(Float.valueOf(sizeChuLandScape));
        }else {
            chuoi = txtManHinh.getText().toString().trim();
            if (chuoi.length() >= chieuDaiChu){
                txtManHinh.setTextSize(Float.valueOf(sizeChuNho));
            }else{
                txtManHinh.setTextSize(Float.parseFloat(sizeChuLon));
            }
        }


    }
    public void resultType(String dau, Float a){
        if (bienTam == bienTam.intValue()){
            txtManHinh.setText(bienTam.intValue() +"");
        }else {
            txtManHinh.setText(bienTam +"");
        }
    }
//   Tinh Toan Phep tinh ( + - * / )
    public void tinhToan(String thucThi) {
        switch (thucThi) {
            case "+":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam + bienGiu;
                Float a = bienTam - bienGiu;
                resultType(" + ", a);
                break;
            case "-":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam - bienGiu;
                Float b = bienTam + bienGiu;
                resultType(" - ", b);
                break;
            case "*":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam * bienGiu;
                Float c = bienTam / bienGiu;
                resultType(" * ", c);
                break;
            case "/":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam / bienGiu;
                Float d = bienTam * bienGiu;
                resultType(" / ", d);
                break;
        }
    }
//   Kiem tra phep tinh do la phep ( +,  -,  *  hay  /  )
    public void dieuKienTinh(){
        if (cong != null){
            tinhToan(cong);
        }
        if (tru != null){
            tinhToan(tru);
        }
        if (nhan != null){
            tinhToan(nhan);
        }
        if (chia != null){
            tinhToan(chia);
        }
    }
    public void anhXa(){
        txtAc = (TextView) findViewById(R.id.textViewAc);
        txtCongTru = (TextView) findViewById(R.id.textViewCongTru);
        txtPhantram = (TextView) findViewById(R.id.textViewPhanTram);
        txtChia = (TextView) findViewById(R.id.textViewChia);
        txtChin  = (TextView) findViewById(R.id.textViewNine);
        txtBay = (TextView) findViewById(R.id.textViewSeven);
        txtTam = (TextView) findViewById(R.id.textViewEight);
        txtSau = (TextView) findViewById(R.id.textViewSix);
        txtNam = (TextView) findViewById(R.id.textViewFive);
        txtBon = (TextView) findViewById(R.id.textViewFour);
        txtBa = (TextView) findViewById(R.id.textViewThree);
        txtHai = (TextView) findViewById(R.id.textViewTwo);
        txtMot = (TextView) findViewById(R.id.textViewOne);
        txtNhan = (TextView) findViewById(R.id.textViewNhan);
        txtTru = (TextView) findViewById(R.id.textViewTru);
        txtCong = (TextView) findViewById(R.id.textViewCong);
        txtBang = (TextView) findViewById(R.id.textViewBang);
        txtCham = (TextView) findViewById(R.id.textViewCham);
        txtKhong  = (TextView) findViewById(R.id.textViewZero);
        txtManHinh = (TextView) findViewById(R.id.textViewManHinh);
    }
     public void Luudiem(){
         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putString("so", txtManHinh.getText().toString());
         editor.putFloat("bienGiu", bienGiu);
         editor.putFloat("bienTam", bienTam);
         String dau = null;
         if (cong != null){
             dau = cong;
         }
         if (tru != null) {
             dau = tru;
         }
         if(nhan != null){
             dau = nhan;
         }
         if(chia != null){
             dau = chia;
         }
         editor.putString("dau", dau);
         editor.commit();
     }
}