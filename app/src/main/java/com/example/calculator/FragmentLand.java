package com.example.calculator;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FragmentLand extends Fragment {
    TextView txtMot, txtHai, txtBa, txtBon, txtNam, txtSau, txtBay,
            txtTam, txtChin, txtKhong, txtBang, txtNhan, txtChia, txtCong,
            txtTru, txtAc, txtCongTru, txtPhantram, txtCham, txtManHinh;
    int chieuDaiChu = 6;
    String sizeChuLon = "22", sizeChuNho = "22", sizeChuLucTinh = "22";
    String  chuoi, cong, tru, nhan, chia;
    Boolean dauCong = false, dauTru = false, dauChia = false, dauNhan = false,dauBang = false, phanTram = false;
    Float bienGiu, bienTam;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        return view;
    }

    public void anhXa(View view){
        txtAc = (TextView) view.findViewById(R.id.textViewAc);
        txtCongTru = (TextView) view.findViewById(R.id.textViewCongTru);
        txtPhantram = (TextView) view.findViewById(R.id.textViewPhanTram);
        txtChia = (TextView) view.findViewById(R.id.textViewChia);
        txtChin  = (TextView) view.findViewById(R.id.textViewNine);
        txtBay = (TextView) view.findViewById(R.id.textViewSeven);
        txtTam = (TextView) view.findViewById(R.id.textViewEight);
        txtSau = (TextView) view.findViewById(R.id.textViewSix);
        txtNam = (TextView) view.findViewById(R.id.textViewFive);
        txtBon = (TextView) view.findViewById(R.id.textViewFour);
        txtBa = (TextView) view.findViewById(R.id.textViewThree);
        txtHai = (TextView) view.findViewById(R.id.textViewTwo);
        txtMot = (TextView) view.findViewById(R.id.textViewOne);
        txtNhan = (TextView) view.findViewById(R.id.textViewNhan);
        txtTru = (TextView) view.findViewById(R.id.textViewTru);
        txtCong = (TextView) view.findViewById(R.id.textViewCong);
        txtBang = (TextView) view.findViewById(R.id.textViewBang);
        txtCham = (TextView) view.findViewById(R.id.textViewCham);
        txtKhong  = (TextView) view.findViewById(R.id.textViewZero);
        txtManHinh = (TextView) view.findViewById(R.id.textViewManHinh);
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
                bienGiu = Float.parseFloat(txtManHinh.getText().toString().trim());
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
                        txtManHinh.setTextSize(Float.valueOf(sizeChuLucTinh));
                    }else{
                        txtManHinh.setTextSize(Float.valueOf(sizeChuLon));
                    }

                    txtManHinh.setText(so+"");
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
            }
        });

        txtBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dieuKienTinh();
                chuoi = txtManHinh.getText().toString().trim();
                if (chuoi.length() >= chieuDaiChu){
                    txtManHinh.setTextSize(Float.valueOf(sizeChuLucTinh));
                }else{
                    txtManHinh.setTextSize(Float.valueOf(sizeChuLon));
                }
                xoaMau();
                dauBang = true;
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
        if (chuoi.length() == 0) {
            txtAc.setText("AC");
        }else {
            txtAc.setText("C");
        }
    }
    public void xuLyCoChu(){
        chuoi = txtManHinh.getText().toString().trim();
        if (chuoi.length() >= chieuDaiChu){
            txtManHinh.setTextSize(Float.valueOf(sizeChuNho));
        }else{
            txtManHinh.setTextSize(Float.parseFloat(sizeChuLon));
        }
    }

    public void resultType(String dau, Float a){
        if (bienTam == bienTam.intValue()){

            txtManHinh.setText(bienTam.intValue() +"");

//            Kết quả tính lần trước.

//            if (bienGiu.intValue() == bienGiu){
//                txtResult.setText(a.intValue() + dau + bienGiu.intValue() +" = " + bienTam.intValue());
//            }else {
//                txtResult.setText(a +dau+ bienGiu +" = " + bienTam.intValue());
//            }

        }else {
            txtManHinh.setText(bienTam +"");

//            Trả kết quả tính lần trước ra màn hình.
//            txtResult.setText(a +dau+ bienGiu +" = " + bienTam);
        }
    }
    public void tinhToan(String thucThi)
    {
        switch (thucThi)
        {
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
}
