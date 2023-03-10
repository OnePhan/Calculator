package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

//    Landscape
    TextView txtNgoacP, txtNgoacT, txtMc, txtMplus, txtMtru,
        txtMr, txtTwoNd, txtXmuTwo, txtXmuThree, txtXmuY, txtEmuX, txtTenmuX,
        txtMotChiaX, txtCan2x, txtCan3x, txtCanYX, txtLn, txtLog10, txtXgiaiThua,
        txtSin, txtCos, txtTan, txtE, txtEE, txtDeg, txtSinh, txtCosh, txtTanh, txtPi, txtRand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        getDataShare();
        ChucNang();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LandScape_Left();
        }
    }

    public void getDataShare(){
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        txtManHinh.setText(sharedPreferences.getString("so","0"));
        bienGiu = sharedPreferences.getFloat("bienGiu", 0);
        bienTam = sharedPreferences.getFloat("bienTam", 0);
        String dau = sharedPreferences.getString("dau", null);
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
                    cong = null; tru = null; nhan = null; chia = null;
                    dauCong = false; dauTru = false; dauChia = false; dauNhan = false;
                    bienTam = Float.valueOf(0); bienGiu = Float.valueOf(0);
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
            txtManHinh.setText(bienTam + "");
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

              }
          });
          txtMplus.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

              }
          });
          txtMtru.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

              }
          });
          txtMr.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

              }
          });
//      ------------------------------ Dong 2------------------------------
          txtTwoNd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

              }
          });
          txtXmuTwo.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  chuoi = txtManHinh.getText().toString().trim();
                  if (chuoi.length() != 0) {
                      Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                      double so = Math.pow(number, 2);
                      resultType((float) so);
                      Luudiem();
                  }
              }
          });
          txtXmuThree.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                  double so = Math.pow(number, 3);
                  resultType((float) so);
                  Luudiem();
              }
          });
          txtXmuY.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

              }
          });
          txtEmuX.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  chuoi = txtManHinh.getText().toString().trim();
                  if (chuoi.equals("0")) {
                      txtManHinh.setText("1");
                  } else {
                      Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                      double so = Math.pow(Math.E, number);
                      resultType((float) so);
                      Luudiem();
                  }
              }
          });
          txtTenmuX.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  chuoi = txtManHinh.getText().toString().trim();
                  if (chuoi.equals("0")) {
                      txtManHinh.setText("1");
                  } else {
                      Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                      double so = Math.pow(10, number);
                      txtManHinh.setText(so + "");
                      Luudiem();
                  }

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
             }
         });
         txtCan2x.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                     Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                     double so = Math.sqrt(number);
                     resultType((float) so);
                     Luudiem();
                 }
         });
         txtCan3x.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Float number = Float.parseFloat(txtManHinh.getText().toString().trim());
                 double so = Math.cbrt(number);
                 resultType((float) so);
                 Luudiem();
             }
         });
         txtCanYX.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

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
                     double so = Math.log(number);
                     resultType((float) so);
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
                     double so = Math.log10(number);
                     resultType((float) so);
                     Luudiem();
                 }
             }
         });
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
                         double so = factorial(number);
                         resultType((float) so);
                         Luudiem();
                     }

                 }
             }
         });
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