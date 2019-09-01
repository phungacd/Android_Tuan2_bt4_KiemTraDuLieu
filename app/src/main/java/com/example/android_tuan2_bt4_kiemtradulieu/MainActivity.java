package com.example.android_tuan2_bt4_kiemtradulieu;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText hoten,cmnd,bosung;
    Button gui;
    CheckBox ckdocbao,ckdocsach,ckdoccode;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hoten = findViewById(R.id.txthoten);
        cmnd = findViewById(R.id.txtcmnd);
        gui = findViewById(R.id.btngui);
        bosung = findViewById(R.id.txtbs);

        ckdocbao = findViewById(R.id.chbdocbao);
        ckdocsach = findViewById(R.id.chbdocsach);
        ckdoccode = findViewById(R.id.chbcode);
        gui = findViewById(R.id.btngui);




        /*if (TextUtils.isEmpty((hoten).getText().toString())) {
            hoten.setError("Không được để trống");
            return;
        } else if(hoten.getText().toString().trim().length() < 3)
        {
        hoten.setError("Họ Tên phải từ 3 ký tự ");
        return;
        }*/






        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 /*if (TextUtils.isEmpty((hoten).getText().toString())) {
                    hoten.setError("Không được để trống");
                    return;
                }else if(hoten.getText().toString().trim().length() < 3) {
                     hoten.setError("Họ Tên phải từ 3 ký tự ");
                     return;
                 }*/

        kiemtradulieu();



            }
        });

    }

    public void kiemtradulieu () {

        String ten = hoten.getText() + "";
        ten = ten.trim();

        if (ten.length() < 3) {
            hoten.requestFocus();
            hoten.selectAll();
            Toast.makeText(this, "Tên phải có 3 kí tự trở lên", Toast.LENGTH_LONG).show();
            return;
        }
        String cmndd = cmnd.getText() + "";

        String bang = "";
        RadioGroup group = findViewById(R.id.radiog);
        int id = group.getCheckedRadioButtonId();
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText() + "";


        String sothich = "";

        if (ckdoccode.isChecked()) {
            sothich += ckdoccode.getText() + "";
        }
        if (ckdocsach.isChecked()) {
            sothich += ckdocsach.getText() + "";
        }
        if (ckdocbao.isChecked()) {
            sothich += ckdocbao.getText() + "";
        }

        String bosungtxt = bosung.getText() + "";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        String trongphung = ten += "\n";
        trongphung += cmndd += "\n";
        trongphung += bang += "\n";
        trongphung += sothich += "\n";

        trongphung += "----------------------\n";

        trongphung += "Thông tin bổ sung \n";
        trongphung += bosungtxt += "\n";
        trongphung += "----------------------\n";
        builder.setMessage(trongphung);
        builder.create().show();


    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        this.menu = menu;
        getMenuInflater().inflate(R.menu.activity_main, menu);

        return true;
    }
}
