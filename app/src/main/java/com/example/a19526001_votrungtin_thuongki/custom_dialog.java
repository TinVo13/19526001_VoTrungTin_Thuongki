package com.example.a19526001_votrungtin_thuongki;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class custom_dialog extends Dialog implements View.OnClickListener {

    EditText editText;
    Button buttonOK;
    Button buttonCancel;
    Activity c;
    static int thoigian;

    protected custom_dialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_custom_dialog);

        this.editText = findViewById(R.id.editText_fullName);
        this.buttonOK = findViewById(R.id.button_ok);
        this.buttonCancel  = findViewById(R.id.button_cancel);

        buttonOK.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ok:
                if(editText.getText().toString().equals("")){
                    Toast.makeText(c, "Vui lòng nhập vào ô!", Toast.LENGTH_SHORT).show();
                }else{
                    thoigian = Integer.parseInt(editText.getText().toString());
                    dismiss();
                }
                break;
            case R.id.button_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }
}
