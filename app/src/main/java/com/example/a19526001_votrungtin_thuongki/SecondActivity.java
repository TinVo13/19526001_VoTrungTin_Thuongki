package com.example.a19526001_votrungtin_thuongki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    int manghinhbai[] = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};
    ImageView iv1,iv2,iv3,iv4,iv5,iv6;
    Button btn_chiabai;
    TextView tv_ketqua,tv_ketqua1,tv_thangthua,tv_thangthua1;
    int sotrandau = 0,maythang = 0, nguoithang = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        iv1 = findViewById(R.id.ImageView_1);
        iv2 = findViewById(R.id.ImageView_2);
        iv3 = findViewById(R.id.ImageView_3);
        iv4 = findViewById(R.id.ImageView_4);
        iv5 = findViewById(R.id.ImageView_5);
        iv6 = findViewById(R.id.ImageView_6);
        btn_chiabai = findViewById(R.id.Button_chiabai);
        tv_ketqua = findViewById(R.id.TextView_ketqua);
        tv_ketqua1 = findViewById(R.id.TextView_ketqua1);
        tv_thangthua = findViewById(R.id.tv_thangthua);
        tv_thangthua1 = findViewById(R.id.tv_thangthua1);
        btn_chiabai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int[] saulabai = laySauSoNgauNhien(0, 51);
                    int []array1 = new int[3];
                    int []array2 = new int[3];
                    sotrandau ++;
                    System.arraycopy(saulabai,0,array1,0,array1.length);
                    System.arraycopy(saulabai, array2.length,array2,0,array2.length);
                    DemNut nut1 = demNut(array1);
                    DemNut nut2 = demNut(array2);
                    iv1.setImageResource(manghinhbai[saulabai[0]]);
                    iv2.setImageResource(manghinhbai[saulabai[1]]);
                    iv3.setImageResource(manghinhbai[saulabai[2]]);
                    tv_ketqua.setText(nut1.getChuoi().toString());
                    iv4.setImageResource(manghinhbai[saulabai[3]]);
                    iv5.setImageResource(manghinhbai[saulabai[4]]);
                    iv6.setImageResource(manghinhbai[saulabai[5]]);
                    tv_ketqua1.setText(nut2.getChuoi().toString());

                    if(nut1.getNut()>nut2.getNut()){
                        tv_thangthua.setText("M??y Th???ng!");
                        tv_thangthua1.setText("Thua!");
                        maythang++;
                    }else if(nut1.getNut()<nut2.getNut()){
                        tv_thangthua.setText("Thua!");
                        tv_thangthua1.setText("Ng?????i ch??i Th???ng!");
                        nguoithang++;
                    }else{
                        tv_thangthua.setText("H??a");
                        tv_thangthua1.setText("H??a");
                    }
                    Toast.makeText(SecondActivity.this, "V??n "+sotrandau+" b???t ?????u!", Toast.LENGTH_SHORT).show();
                    if(sotrandau==10){
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(SecondActivity.this);
                        builder1.setMessage("Ng?????i ch??i th???ng "+nguoithang+" tr???n! M??y th???ng "+maythang+" tr???n!\nB???n c?? mu???n ti???p t???c ch??i kh??ng?");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        sotrandau = 0;
                                    }
                                });

                        builder1.setNegativeButton(
                                "No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                }
            });
        }
        private static int random(int min, int max){
            return min + (int)(Math.random()*(max-min)+1);
        }
        private static boolean kiemTraTrung(int k, int[]arr){
            for (int i = 0; i < arr.length; i++){
                if(arr[i]==k){
                    return true;
                }
            }
            return false;
        }
        public int[] laySauSoNgauNhien(int min, int max){
            int[] sauso = new int[6];
            int i = 0;
            sauso[i++] = random(min,max);
            do{
                int k = random(min,max);
                if(kiemTraTrung(k,sauso)==false){
                    sauso[i++] = k;
                }
            }while(i<6);
            return sauso;
        }
        private int demConTay(int []arr){
            int tong = 0;
            for (int i = 0;i < arr.length; i++){
                if(arr[i]%13>=10&&arr[i]<13){
                    tong++;
                }
            }
            return tong;
        }
        private DemNut demNut(int []arr){
            DemNut demnut = new DemNut();
            String ketqua = "";
            if(demConTay(arr)==3){
                ketqua = "Ba c??o lu??n! Gh?? ???";
                demnut.setChuoi(ketqua);
                demnut.setNut(11);
            }else{
                int nut = 0;
                int nut1 = 0;
                for (int i =0; i< arr.length; i++){
                    if(arr[i]%13<10){
                        nut += arr[i]%13+1;
                        nut1 = nut;
                    }
                }
                if(nut%10==0){
                    ketqua = "B?? r???i! H??i ??en";
                    nut1 = 0;
                }else if(nut%10==9){
                    ketqua = nut%10+" n??t! ???? ????? v???y ba";
                    nut1 = 9;
                }else if(nut%10==1){
                    ketqua = nut%10+" n??t! haha";
                    nut1 = 1;
                }else{
                    ketqua = nut%10+" n??t! Kh??ng t???";
                    nut1 = nut%10;
                }
                demnut.setNut(nut1);
                demnut.setChuoi(ketqua);
            }
            return demnut;
        }
    }