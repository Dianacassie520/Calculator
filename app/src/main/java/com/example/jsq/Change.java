package com.example.jsq;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        final EditText edit_c = (EditText)findViewById(R.id.edit_c);
        final EditText edit_chi = (EditText)findViewById(R.id.edit_chi);
        final EditText edit_du = (EditText)findViewById(R.id.edit_du);
        final EditText edit_f = (EditText)findViewById(R.id.edit_f);
        final EditText edit_ft = (EditText)findViewById(R.id.edit_ft);
        final EditText edit_k = (EditText)findViewById(R.id.edit_k);
        final EditText edit_kg = (EditText)findViewById(R.id.edit_kg);
        final EditText edit_lb = (EditText)findViewById(R.id.edit_lb);
        final EditText edit_m = (EditText)findViewById(R.id.edit_m);
        final EditText edit_oz = (EditText)findViewById(R.id.edit_oz);
        final EditText edit_pi = (EditText)findViewById(R.id.edit_pi);
        final EditText edit_rad = (EditText)findViewById(R.id.edit_rad);
        Button bt_doit = (Button)findViewById(R.id.doit);
        Button bt_cleanit = (Button)findViewById(R.id.cleanit);

        bt_cleanit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_c.setText("");
                edit_chi.setText("");
                edit_du.setText("");
                edit_f.setText("");
                edit_ft.setText("");
                edit_k.setText("");
                edit_kg.setText("");
                edit_lb.setText("");
                edit_m.setText("");
                edit_oz.setText("");
                edit_pi.setText("");
                edit_rad.setText("");
            }
        });

        bt_doit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(edit_du.getText().toString().length()>0||edit_pi.getText().toString().length()>0||edit_rad.getText().toString().length()>0){

                        if(edit_du.getText().toString().length()>0&&edit_pi.getText().toString().length()==0&&edit_rad.getText().toString().length()==0){
                            edit_pi.setText(String.valueOf(Double.parseDouble(edit_du.getText().toString())/180));
                            edit_rad.setText(String.valueOf(Double.parseDouble(edit_du.getText().toString())/180*Math.PI));
                        }
                        else if(edit_pi.getText().toString().length()>0&&edit_du.getText().toString().length()==0&&edit_rad.getText().toString().length()==0){
                            edit_du.setText(String.valueOf(Double.parseDouble(edit_pi.getText().toString())*180));
                            edit_rad.setText(String.valueOf(Double.parseDouble(edit_pi.getText().toString())*Math.PI));
                        }
                        else if(edit_rad.getText().toString().length()>0&&edit_du.getText().toString().length()==0&&edit_pi.getText().toString().length()==0){
                            edit_du.setText(String.valueOf(Double.parseDouble(edit_rad.getText().toString())*180/Math.PI));
                            edit_pi.setText(String.valueOf(Double.parseDouble(edit_rad.getText().toString())/Math.PI));
                        }

                    }
                    else if(edit_m.getText().toString().length()>0||edit_ft.getText().toString().length()>0||edit_chi.getText().toString().length()>0){

                        if(edit_m.getText().toString().length()>0&&edit_ft.getText().toString().length()==0&&edit_chi.getText().toString().length()==0){
                            edit_ft.setText(String.valueOf(Double.parseDouble(edit_m.getText().toString())/0.3048));
                            edit_chi.setText(String.valueOf(Double.parseDouble(edit_m.getText().toString())*3));
                        }
                        else if(edit_ft.getText().toString().length()>0&&edit_m.getText().toString().length()==0&&edit_chi.getText().toString().length()==0){
                            edit_m.setText(String.valueOf(Double.parseDouble(edit_ft.getText().toString())*0.3048));
                            edit_chi.setText(String.valueOf(Double.parseDouble(edit_ft.getText().toString())*0.3048*3));
                        }
                        else if(edit_chi.getText().toString().length()>0&&edit_ft.getText().toString().length()==0&&edit_m.getText().toString().length()==0){
                            edit_ft.setText(String.valueOf(Double.parseDouble(edit_chi.getText().toString())/3/0.3048));
                            edit_m.setText(String.valueOf(Double.parseDouble(edit_chi.getText().toString())/3));
                        }
                    }
                    else if(edit_kg.getText().toString().length()>0||edit_lb.getText().toString().length()>0||edit_oz.getText().toString().length()>0){

                        if(edit_kg.getText().toString().length()>0&&edit_lb.getText().toString().length()==0&&edit_oz.getText().toString().length()==0){
                            edit_lb.setText(String.valueOf(Double.parseDouble(edit_kg.getText().toString())*2.205));
                            edit_oz.setText(String.valueOf(Double.parseDouble(edit_kg.getText().toString())*35.2739619));
                        }
                        else if(edit_lb.getText().toString().length()>0&&edit_kg.getText().toString().length()==0&&edit_oz.getText().toString().length()==0){
                            edit_kg.setText(String.valueOf(Double.parseDouble(edit_lb.getText().toString())/2.205));
                            edit_oz.setText(String.valueOf(Double.parseDouble(edit_lb.getText().toString())/2.205*35.2739619));
                        }
                        else if(edit_oz.getText().toString().length()>0&&edit_kg.getText().toString().length()==0&&edit_lb.getText().toString().length()==0){
                            edit_kg.setText(String.valueOf(Double.parseDouble(edit_oz.getText().toString())/35.2739619));
                            edit_lb.setText(String.valueOf(Double.parseDouble(edit_oz.getText().toString())/35.2739619*2.205));
                        }
                    }
                    else if(edit_c.getText().toString().length()>0||edit_f.getText().toString().length()>0||edit_k.getText().toString().length()>0){

                        if(edit_c.getText().toString().length()>0&&edit_f.getText().toString().length()==0&&edit_k.getText().toString().length()==0){
                            edit_f.setText(String.valueOf(Double.parseDouble(edit_c.getText().toString())*1.8+32));
                            edit_k.setText(String.valueOf(Double.parseDouble(edit_c.getText().toString())+273.15));
                        }
                        else if(edit_f.getText().toString().length()>0&&edit_c.getText().toString().length()==0&&edit_k.getText().toString().length()==0){
                            edit_c.setText(String.valueOf((Double.parseDouble(edit_f.getText().toString())-32)/1.8));
                            edit_k.setText(String.valueOf((Double.parseDouble(edit_f.getText().toString())+459.67)/1.8));
                        }
                        else if(edit_k.getText().toString().length()>0&&edit_c.getText().toString().length()==0&&edit_f.getText().toString().length()==0){
                            edit_c.setText(String.valueOf(Double.parseDouble(edit_k.getText().toString())-273.15));
                            edit_f.setText(String.valueOf(Double.parseDouble(edit_k.getText().toString())*1.8-459.67));
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(Change.this,"格式错误",Toast.LENGTH_SHORT).show();
                    edit_c.setText("");
                    edit_chi.setText("");
                    edit_du.setText("");
                    edit_f.setText("");
                    edit_ft.setText("");
                    edit_k.setText("");
                    edit_kg.setText("");
                    edit_lb.setText("");
                    edit_m.setText("");
                    edit_oz.setText("");
                    edit_pi.setText("");
                    edit_rad.setText("");
                }
            }
        });
    }
}
