package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.BoringLayout;
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
    String bienGiu;
    Float bienTam;
    SharedPreferences sharedPreferences;
    int khoichay = 0;
//    Landscape ---------------------------------------------------------------------------
    TextView txtNgoacP, txtNgoacT, txtMc, txtMplus, txtMtru,
        txtMr, txtTwoNd, txtXmuTwo, txtXmuThree, txtXmuY, txtEmuX, txtTenmuX,
        txtMotChiaX, txtCan2x, txtCan3x, txtCanYX, txtLn, txtLog10, txtXgiaiThua,
        txtSin, txtCos, txtTan, txtE, txtEE, txtDeg, txtSinh, txtCosh, txtTanh, txtPi, txtRand;
        Boolean check = true, xCany = false, xMuy = false, xCan2 = false, xCan3 = false, xMu2 = false, xMu3 = false;
        String  XcanY, XmuY, Xcan2, Xcan3, Xmu2, Xmu3;
        Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        getDataShare();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            database = new Database(this, "luuDuLieu", null, 1);
            database.QueryData("CREATE TABLE IF NOT EXISTS mc(id INTEGER PRIMARY KEY AUTOINCREMENT, luu VARCHAR(200))");
            ChucNang();
            LandScape_Left();
        }else {
            ChucNang();
        }
    }
    public void checkKhoiChay(int k){
        if(khoichay == 0){
            txtManHinh.setText(null);
            khoichay++;
        }
    }
    public void Luudiem(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("so", txtManHinh.getText().toString());
        editor.putString("bGiu", bienGiu);
        editor.commit();
    }
    public void getDataShare(){
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        txtManHinh.setText(sharedPreferences.getString("so","0"));
        bienGiu = sharedPreferences.getString("bGiu", "0");
        String dau = sharedPreferences.getString("dauPhepTinh", null);
        if (dau == "+"){
            cong = "+";
            dauCong = true;
        }
        if (dau == "-"){
            tru = "-";
            dauTru = true;
        }
        if (dau == "*"){
            nhan = "*";
            dauNhan = true;
        }
        if (dau == "/"){
            chia = "/";
            dauChia = true;
        }
        if (dau == "powy"){
            XmuY = "powy";
            xMuy = true;
        }
        if (dau == "pow2"){
            Xmu2 = "pow2";
            xMu2 = true;
        }
        lenMau();
        xuLyPhim_AC();
        xuLyCoChu();
    }
    public void ChucNang(){
        txtAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyPhim_AC();
                if (txtAc.getText().toString() == "AC"){
                    cong = null; tru = null; nhan = null; chia = null; XmuY = null; Xmu2 = null; Xmu3 = null; Xcan2 = null; Xcan3 = null; XcanY = null;
                    dauCong = false; dauTru = false; dauChia = false; dauNhan = false; xMuy = false; xMu2 = false; xMu3 = false; xCany = false; xCan2 = false; xCan3= false;
                    bienTam = Float.valueOf(0); bienGiu = null;
                    phanTram = false;
                    txtManHinh.setText("0");
                    xoaMau();
                } else if (txtAc.getText().toString() == "C") {
                    txtManHinh.setText("0");
                    lenMau();
                }
                xuLyPhim_AC();
                Luudiem();
            }
        });
        txtMot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "1";
                phimSo(so);
            }
        });
        txtHai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "2";
                phimSo(so);
            }
        });
        txtBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "3";
                phimSo(so);
            }
        });
        txtBon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "4";
                phimSo(so);
            }
        });
        txtNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "5";
                phimSo(so);
            }
        });
        txtSau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "6";
                phimSo(so);
            }
        });
        txtBay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "7";
                phimSo(so);
            }
        });
        txtTam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "8";
                phimSo(so);
            }
        });
        txtChin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so = "9";
                phimSo(so);
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
                bienGiu = txtManHinh.getText().toString().trim();
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
                    resultType(so);
                    bienGiu = txtManHinh.getText().toString().trim();
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
                bienGiu = txtManHinh.getText().toString().trim();
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
                cong = "+"; tru = null; nhan = null; chia = null; XmuY = null; XcanY = null; Xmu3 = null; Xcan2 = null; Xcan3 = null; Xmu2 = null;
                dauCong = true; dauChia = false; dauNhan = false; dauTru = false; xMuy = false;
                xCany = false; xMu3 = false; xCan2 = false; xCan3 = false; xMu2 = false;
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
                cong = null; tru = "-"; nhan = null; chia = null; XmuY = null; XcanY = null; Xmu3 = null; Xcan2 = null; Xcan3 = null; Xmu2 = null;
                dauCong = false; dauChia = false; dauNhan = false; dauTru = true; xMuy = false;
                xCany = false; xMu3 = false; xCan2 = false; xCan3 = false; xMu2 = false;
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
                cong = null; tru = null; nhan = "*"; chia = null; XmuY = null; XcanY = null; Xmu3 = null; Xcan2 = null; Xcan3 = null; Xmu2 = null;
                dauCong = false; dauChia = false; dauNhan = true; dauTru = false; xMuy = false; xCany = false; xMu3 = false; xCan2 = false; xCan3 = false; xMu2 = false;
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
                cong = null; tru = null; nhan = null; chia = "/"; XmuY = null; XcanY = null; Xmu3 = null; Xcan2 = null; Xcan3 = null; Xmu2 = null;
                dauCong = false; dauChia = true; dauNhan = false; dauTru = false; xMuy = false; xCany = false; xMu3 = false; xCan2 = false; xCan3 = false; xMu2 = false;
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
    public void phimSo(String so){
        checkKhoiChay(khoichay);
        xuLy_Input();
        xuLyCoChu();
        xuLySo(so);
        xuLyPhim_AC();
        bienGiu = txtManHinh.getText().toString().trim();
        Luudiem();
    }
//    XOA MAU CUA PHIM + - * /
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
        if (xMu3 == true){
            txtManHinh.setText(null);
            xMu3 = false;
        }
        if (xMu2 == true){
            txtManHinh.setText(null);
            xMu2 = false;
        }
        if (xMuy == true){
            txtManHinh.setText(null);
            xMuy = false;
        }
        if (xCan2 == true ){
            txtManHinh.setText(null);
            xCan2 = false;
        }
        if (xCan3 == true){
            txtManHinh.setText(null);
            xCan3 = false;
        }
        if (xCany == true){
            txtManHinh.setText(null);
            xCany = false;
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
        if (nhan == "*") {
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
                txtManHinh.setText("-" + number);
            }
        }else {
            Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
            if (number < 0){
                txtManHinh.setText(Math.abs(number) + "");
            }else {
                txtManHinh.setText("-" + number);
            }
        }
    }
    public void xuLySo(String so){
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
    public void xuLyPhim_AC(){
        chuoi = txtManHinh.getText().toString().trim();
        if (chuoi.length() == 1 && chuoi.equals("0")) {
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
            txtManHinh.setText(bienTam + "");
        }
    }
//   Tinh Toan Phep tinh ( + - * / )
    public void tinhToan(String thucThi) {
        Float a = Float.parseFloat(bienGiu);
        switch (thucThi) {
            case "+":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam + a;
                resultType(" + ", bienTam);
                break;
            case "-":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam - a;
                resultType(" - ", bienTam);
                break;
            case "*":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam * a;
                resultType(" * ", bienTam);
                break;
            case "/":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                bienTam = bienTam / a;
                resultType(" / ", bienTam);
                break;
            case "powy":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                double pow = Math.pow(bienTam, a);
                bienTam = Float.parseFloat(String.valueOf(pow));
                resultType((float) bienTam);
                break;
            case "can":
                if (bienTam == null){
                    bienTam = Float.valueOf(0);
                }
                double can = Math.exp(Math.log(bienTam) * 1/a);
                bienTam = Float.parseFloat(String.valueOf(can));
                resultType((float) bienTam);
                break;
            case "pow2":
                Float pow2 = Float.parseFloat(txtManHinh.getText().toString().trim());
                resultType((float) Math.pow(pow2, 2));
                break;
            case "pow3":
                Float pow3 = Float.parseFloat(txtManHinh.getText().toString().trim());
                resultType((float) Math.pow(pow3, 3));
                break;
            case "can2":
                Float can2 = Float.parseFloat(txtManHinh.getText().toString().trim());
                resultType((float) Math.sqrt(can2));
                break;
            case "can3":
                Float can3 = Float.parseFloat(txtManHinh.getText().toString().trim());
                resultType((float) Math.sqrt(can3));
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
        if (XmuY != null){
            tinhToan(XmuY);
        }
        if (XcanY != null){
            tinhToan(XcanY);
        }
        if (Xmu2 != null){
            tinhToan(Xmu2);
        }
        if (Xmu3 != null){
            tinhToan(Xmu3);
        }
        if (Xcan2 != null){
            tinhToan(Xcan2);
        }
        if (Xcan3 != null){
            tinhToan(Xcan3);
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
//        ANH xa LANDSCAPE ---------------------------
        txtNgoacP = (TextView) findViewById(R.id.textViewNgoacPhai);
        txtNgoacT = (TextView) findViewById(R.id.textViewNgoacTrai);
        txtMc = (TextView) findViewById(R.id.textViewMc);
        txtMplus = (TextView) findViewById(R.id.textViewMcong);
        txtMtru = (TextView) findViewById(R.id.textViewMtru);
        txtMr = (TextView) findViewById(R.id.textViewMr);

        txtTwoNd = (TextView) findViewById(R.id.textView2nd);
        txtXmuTwo = (TextView) findViewById(R.id.textViewXmu2);
        txtXmuThree = (TextView) findViewById(R.id.textViewXmu3);
        txtXmuY = (TextView) findViewById(R.id.textViewXmuY);
        txtEmuX = (TextView) findViewById(R.id.textViewEmuX);
        txtTenmuX = (TextView) findViewById(R.id.textView10muX);

        txtMotChiaX = (TextView) findViewById(R.id.textView1chiaX);
        txtCan2x = (TextView) findViewById(R.id.textViewCanbac2);
        txtCan3x = (TextView) findViewById(R.id.textViewCanbac3);
        txtCanYX = (TextView) findViewById(R.id.textViewYcanX);
        txtLn = (TextView) findViewById(R.id.textViewLn);
        txtLog10 = (TextView) findViewById(R.id.textViewLog10);

        txtXgiaiThua = (TextView) findViewById(R.id.textViewXgiaithua);
        txtSin = (TextView) findViewById(R.id.textViewSin);
        txtCos = (TextView) findViewById(R.id.textViewCos);
        txtTan = (TextView) findViewById(R.id.textViewTan);
        txtE = (TextView) findViewById(R.id.textViewE);
        txtEE = (TextView) findViewById(R.id.textViewEE);

        txtDeg = (TextView) findViewById(R.id.textViewDeg);
        txtSinh = (TextView) findViewById(R.id.textViewSinh);
        txtCosh = (TextView) findViewById(R.id.textViewCosh);
        txtTanh = (TextView) findViewById(R.id.textViewTanh);
        txtPi = (TextView) findViewById(R.id.textViewPi);
        txtRand = (TextView) findViewById(R.id.textViewRand);
    }
//     ------------------ CODE Fragment LANDSCAPE------------------------------
     public void LandScape_Left(){
//      ------------------------------ Dong 1------------------------------
          txtNgoacP.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              }
          });
          txtNgoacT.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              }
          });
          txtMc.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  database.QueryData("DELETE FROM mc");
              }
          });
          txtMplus.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String bien = "0";
                  Cursor dulieu = database.getData("SELECT * FROM mc");
                  while (dulieu.moveToNext()){
                      bien = dulieu.getString(1);
                  }
                  Float so = Float.parseFloat(bien) + Float.parseFloat(txtManHinh.getText().toString().trim());
                  String s = String.valueOf(so);
                  database.QueryData("INSERT INTO mc VALUES(null,'"+ s +"')");
              }
          });
          txtMtru.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String bien = "0";
                  Cursor dulieu = database.getData("SELECT * FROM mc");
                  while (dulieu.moveToNext()){
                      bien = dulieu.getString(1);
                  }
                  Float so = Float.parseFloat(bien) - Float.parseFloat(txtManHinh.getText().toString().trim());
                  String s = String.valueOf(so);
                  database.QueryData("INSERT INTO mc VALUES(null,'"+ s +"')");
              }
          });
          txtMr.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Cursor dulieu = database.getData("SELECT * FROM mc");
                  while (dulieu.moveToNext()){
                      resultType(Float.valueOf(dulieu.getString(1)));
                  }
              }
          });
//      ------------------------------ Dong 2------------------------------
          txtTwoNd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (check == true){
                      txtEmuX.setText("Y^x");
                      txtTenmuX.setText("2^x");
                      txtLn.setText("Logy");
                      txtLog10.setText("Log2");
                      txtSin.setText("sin-1");
                      txtCos.setText("cos-1");
                      txtTan.setText("tan-1");
                      txtSinh.setText("sinh-1");
                      txtCosh.setText("cosh-1");
                      txtTanh.setText("tanh-1");
                      lenMau2nd();
                      check = false;
                  }else {
                      txtEmuX.setText("e^x");
                      txtTenmuX.setText("10^x");
                      txtLn.setText("Ln");
                      txtLog10.setText("Log10");
                      txtSin.setText("sin");
                      txtCos.setText("cos");
                      txtTan.setText("tan");
                      txtSinh.setText("sinh");
                      txtCosh.setText("cosh");
                      txtTanh.setText("tanh");
                      xoaMau2nd();
                      check = true;
                  }
              }
          });
          txtXmuTwo.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  cong = null; tru = null; nhan = null; chia = null; XmuY = null; XcanY = null; Xmu3 = null; Xcan2 = null; Xcan3 = null; Xmu2 = "pow2";
                  dauCong = false; dauChia = false; dauNhan = false; dauTru = false; xMuy = false; xCany = false; xMu3 = false; xCan2 = false; xCan3 = false; xMu2 = true;
                  Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                  double so = Math.pow(number, 2);
                  resultType((float) so);
                  Luudiem();
              }
          });
          txtXmuThree.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  cong = null; tru = null; nhan = null; chia = null; XmuY = null; XcanY = null; Xmu3 = "pow3"; Xcan2 = null; Xcan3 = null; Xmu2 = null;
                  dauCong = false; dauChia = false; dauNhan = false; dauTru = false; xMuy = false; xCany = false; xMu3 = true; xCan2 = false; xCan3 = false; xMu2 = false;
                  Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                  double so = Math.pow(number, 3);
                  resultType((float) so);
                  Luudiem();
              }
          });
          txtXmuY.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  chuoi = txtManHinh.getText().toString().trim();
                  if (chuoi.length() != 0){
                      bienTam = Float.parseFloat(txtManHinh.getText().toString().trim());
                  }
                  cong = null; tru = null; nhan = null; chia = null; XmuY = "powy"; XcanY = null; Xmu3 = null; Xcan2 = null; Xcan3 = null; Xmu2 = null;
                  dauCong = false; dauChia = false; dauNhan = false; dauTru = false; xMuy = true; xCany = false; xMu3 = false; xCan2 = false; xCan3 = false; xMu2 = false;
                  Luudiem();
              }
          });
          txtEmuX.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                  resultType((float) Math.pow(Math.E, number));
                  Luudiem();
              }
          });
          txtTenmuX.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (txtTenmuX.getText().equals("10^x")) {
                      Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                      resultType((float) Math.pow(10, number));
                  }else {
                      Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                      resultType((float) Math.pow(2, number));
                  }
                  Luudiem();
              }
          });
//        ------------------------------ Dong 3------------------------------
         txtMotChiaX.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String chuoi = txtManHinh.getText().toString().trim();
                 Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                 double so = 1 / number;
                 if (chuoi.equals("Infinity") == false){
                     resultType((float) so);
                 }
                 Luudiem();
             }
         });
         txtCan2x.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 cong = null; tru = null; nhan = null; chia = null; XmuY = null; XcanY = null; Xmu3 = null; Xcan2 = "can2"; Xcan3 = null; Xmu2 = null;
                 dauCong = false; dauChia = false; dauNhan = false; dauTru = false; xMuy = false; xCany = false; xMu3 = false; xCan2 = true ; xCan3 = false; xMu2 = false;
                 Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                 resultType((float) Math.sqrt(number));
                 Luudiem();
             }
         });
         txtCan3x.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 cong = null; tru = null; nhan = null; chia = null; XmuY = null; XcanY = null; Xmu3 = null; Xcan2 = null; Xcan3 = "can3"; Xmu2 = null;
                 dauCong = false; dauChia = false; dauNhan = false; dauTru = false; xMuy = false; xCany = false; xMu3 = false; xCan2 = false ; xCan3 = true; xMu2 = false;
                 Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                 resultType((float) Math.cbrt(number));
                 Luudiem();
             }
         });
         txtCanYX.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 cong = null; tru = null; nhan = null; chia = null; XmuY = null; XcanY = "can"; Xmu3 = null; Xcan2 = null; Xcan3 = null; Xmu2 = null;
                 dauCong = false; dauChia = false; dauNhan = false; dauTru = false; xMuy = false; xCany = true; xMu3 = false; xCan2 = false ; xCan3 = false; xMu2 = false;
                 chuoi = txtManHinh.getText().toString().trim();
                 if (chuoi.length() != 0){
                     bienTam = Float.parseFloat(txtManHinh.getText().toString().trim());
                 }
             }
         });

         txtLn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String man = txtManHinh.getText().toString().trim();
                 if (man.equals("0")){
                     txtManHinh.setText("Infinity");
                 }else {
                     Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                     resultType((float) Math.log(number));
                     Luudiem();
                 }
             }
         });
         txtLog10.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String textManHinh = txtManHinh.getText().toString().trim();
                 if (textManHinh.equals("0")){
                     txtManHinh.setText("Infinity");
                 }else {
                     Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                     resultType((float) Math.log10(number));
                     Luudiem();
                 }
             }
         });
//        --------------------------------DONG 4 --------------------------------
         txtXgiaiThua.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 chuoi = txtManHinh.getText().toString().trim();
                 if (chuoi.equals("0")) {
                     txtManHinh.setText("1");
                 } else {
                     if (chuoi.length() >= 3){
                         txtManHinh.setText("Infinity");
                     }else {
                         int number = Integer.parseInt(txtManHinh.getText().toString().trim());
                         resultType((float) factorial(number));
                         Luudiem();
                     }

                 }
             }
         });
         txtSin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (txtSin.getText().equals("sin")){
                     chuoi = txtManHinh.getText().toString().trim();
                     if (chuoi.equals("0") == false) {
                         Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                         resultType((float) Math.sin(number));
                         Luudiem();
                     }
                 }else {
                     chuoi = txtManHinh.getText().toString().trim();
                     Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                     resultType((float) (1 / Math.sin(number)));
                     Luudiem();
                 }

             }
         });
         txtCos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (txtCos.getText().equals("cos")) {
                     chuoi = txtManHinh.getText().toString().trim();
                     if (chuoi.equals("0") == false) {
                         Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                         resultType((float) Math.cos(number));
                         Luudiem();
                     }
                 }else {
                     chuoi = txtManHinh.getText().toString().trim();
                     Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                     resultType((float) (1 / Math.cos(number)));
                     Luudiem();
                 }
             }
         });
         txtTan.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (txtTan.getText().equals("tan")){
                     chuoi = txtManHinh.getText().toString().trim();
                     if (chuoi.equals("0") == false) {
                         Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                         resultType((float) Math.tan(number));
                         Luudiem();
                     }
                 }else {
                     chuoi = txtManHinh.getText().toString().trim();
                     Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                     resultType((float) (1 / Math.tan(number)));
                     Luudiem();
                 }

             }
         });
         txtE.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 txtManHinh.setText(Math.E + "");
                 Luudiem();
             }
         });
         txtEE.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             }
         });
//        -----------------------DONG 5 ---------------------------------------
         txtDeg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (txtDeg.getText() == "Rad"){
                     txtDeg.setText("Deg");
                 }else {
                     txtDeg.setText("Rad");
                 }
             }
         });
         txtSinh.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 chuoi = txtManHinh.getText().toString().trim();
                 if (chuoi.equals("0") == false) {
                     resultType((float) Math.sinh(Double.parseDouble(chuoi)));
                     Luudiem();
                 }
             }
         });
         txtCosh.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 chuoi = txtManHinh.getText().toString().trim();
                 Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                 resultType((float) Math.cosh(number));
                 Luudiem();
             }
         });
         txtTanh.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 chuoi = txtManHinh.getText().toString().trim();
                 if (chuoi.equals("0") == false) {
                     Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                     resultType((float) Math.tanh(number));
                     Luudiem();
                 }
             }
         });
         txtPi.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 txtManHinh.setText(Math.PI + "");
                 Luudiem();
             }
         });
         txtRand.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 resultType((float) Math.random());
                 Luudiem();
             }
         });
     }
     public void lenMau2nd(){
        txtTwoNd.setBackgroundResource(R.drawable.custom_2nd);
        txtTwoNd.setTextColor(Color.BLACK);
     }
     public void xoaMau2nd() {
         txtTwoNd.setBackgroundResource(R.drawable.custom_textview);
         txtTwoNd.setTextColor(Color.WHITE);
     }
     public int factorial(int number) {
        int so = 1;
        for (int  i = 1; i <= number; i++){
            so *= i;
        }
        return so;
    }
     public void resultType(Float a){
        if (a == a.intValue()){
            txtManHinh.setText(a.intValue() +"");
        }else {
            txtManHinh.setText(a + "");
        }
    }
}