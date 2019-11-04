package com.example.jsq;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Jinzhi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);
        final EditText etOct = (EditText)findViewById(R.id.etOct);
        final EditText etDec = (EditText)findViewById(R.id.etDec);
        Button queren = (Button)findViewById(R.id.queren);
        Button qingchu = (Button)findViewById(R.id.qingchu);
        qingchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etOct.setText("");
                etDec.setText("");
            }
        });
        queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(etOct.getText().toString().length()>0) {
                    try {
                        etOct.setText("十转换成二进制"+"="+(Double.parseDouble(etOct.getText().toString())));
                    }catch (Exception e){
                        etOct.setText("格式错误");
                    }

                }
                else{
                    etOct.setText("输入为空");
                }

                    if(etDec.getText().toString().length()>0) {
                        try {
                            etDec.setText("十转换成八进制"+"="+Integer.toOctalString( Integer.parseInt(etDec.getText().toString())));
                        }catch (Exception e){
                            etDec.setText("格式错误");
                        }

                    }
                    else{
                        etDec.setText("输入为空");
                    }
                }catch (Exception e){
                    Toast.makeText(Jinzhi.this,"格式错误",Toast.LENGTH_SHORT).show();
                    etOct.setText("");
                    etDec.setText("");
                }
            }
        });

    }

}
