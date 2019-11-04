package com.example.jsq;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Science extends AppCompatActivity {
    TextView textView;
    static String record="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        textView = findViewById(R.id.text);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.mul);
        Button point = findViewById(R.id.point);
        Button percent = findViewById(R.id.percent);
        Button clear = findViewById(R.id.clear);
        Button equ = findViewById(R.id.equ);
        Button delete = findViewById(R.id.delete);
        Button reciprocal = findViewById(R.id.reciprocal);
        Button square = findViewById(R.id.square);
        Button cube = findViewById(R.id.cube);
        Button factorial = findViewById(R.id.factorial);
        Button e = findViewById(R.id.e);
        Button ln =findViewById(R.id.ln);
        Button log = findViewById(R.id.log);
        Button sin = findViewById(R.id.sin);
        Button cos = findViewById(R.id.cos);
        Button tan = findViewById(R.id.tan);
        Button pi = findViewById(R.id.pi);
        Button root = findViewById(R.id.root);
        Button left_bracket = findViewById(R.id.left_bracket);
        Button right_bracket = findViewById(R.id.right_bracket);

        num0.setOnClickListener(new myClickListener());
        num1.setOnClickListener(new myClickListener());
        num2.setOnClickListener(new myClickListener());
        num3.setOnClickListener(new myClickListener());
        num4.setOnClickListener(new myClickListener());
        num5.setOnClickListener(new myClickListener());
        num6.setOnClickListener(new myClickListener());
        num7.setOnClickListener(new myClickListener());
        num8.setOnClickListener(new myClickListener());
        num9.setOnClickListener(new myClickListener());
        add.setOnClickListener(new myClickListener());
        sub.setOnClickListener(new myClickListener());
        div.setOnClickListener(new myClickListener());
        mul.setOnClickListener(new myClickListener());
        point.setOnClickListener(new myClickListener());
        left_bracket.setOnClickListener(new myClickListener());
        right_bracket.setOnClickListener(new myClickListener());

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                record = "";
            }
        });
        reciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = 1/num;
                textView.setText(record +"1/"+getLastLineText().trim()+"\n"+result+"\n");
                setRecord();
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = num * num;
                textView.setText(record +getLastLineText().trim()+"^2"+"\n"+result+"\n");
                setRecord();
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = num * num;
                textView.setText(record +getLastLineText().trim()+"^2"+"\n"+result+"\n");
                setRecord();
            }
        });

        cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = num * num * num;
                textView.setText(record +getLastLineText().trim()+"^3"+"\n"+result+"\n");
                setRecord();
            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num = Integer.parseInt(getLastLineText().trim());
                int result=1;
                for(int i=1;i<=num;i++){
                    result*=i;
                }
                textView.setText(record +getLastLineText().trim()+"!"+"\n"+result+"\n");
                setRecord();
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(record + Math.exp(1));
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = Math.log10(num);
                textView.setText(record + "ln"+ getLastLineText().trim()+"\n"+result+"\n");
                setRecord();
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = Math.log(num);
                textView.setText(record +"log"+getLastLineText().trim()+"\n"+result+"\n");
                setRecord();
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = Math.sin(num);
                textView.setText(record +"sin"+getLastLineText().trim()+"\n"+result+"\n");
                setRecord();
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = Math.cos(num);
                textView.setText(record +"cos"+getLastLineText().trim()+"\n"+result+"\n");
                setRecord();
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = Math.tan(num);
                textView.setText(record +"tan"+getLastLineText().trim()+"\n"+result+"\n");
                setRecord();
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(record + Math.PI);
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = Math.sqrt(num);
                textView.setText(record +"√"+getLastLineText().trim()+"\n"+result+"\n");
                setRecord();
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(getLastLineText().trim());
                double result = num/100;
                textView.setText(record +getLastLineText().trim()+"%"+"\n"+result+"\n");
                setRecord();
            }
        });

        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expr = getLastLineText();
                Calculate cal = new Calculate(expr);
                if(cal.isLegal()) {
                    double result = cal.getResult();
                    textView.setText(record + getLastLineText().trim() + "\n" + result + "\n");
                }
                else{
                    Toast.makeText(Science.this,"表达式非法",Toast.LENGTH_SHORT).show();
                    textView.setText(record + getLastLineText().trim() + "\n"  + "\n");
                }
                setRecord();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(delete());
            }
        });

    }

    class myClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Button bt = findViewById(v.getId());
            textView.setText(textView.getText() + bt.getText().toString());
        }
    }

    public String getLastLineText(){
        String text = textView.getText().toString();
        int line = textView.getLayout().getLineCount();
        int start = textView.getLayout().getLineStart(line-1);
        int end = textView.getLayout().getLineEnd(line-1);
        String result = text.substring(start,end);
        return result;
    }

    public void setRecord(){
        String text = textView.getText().toString();
        String temp = "";
        int line = textView.getLayout().getLineCount();
        for(int i=0;i<line;i++) {
            int start = textView.getLayout().getLineStart(i);
            int end = textView.getLayout().getLineEnd(i);
            temp = text.substring(start,end);
            record = record + temp ;
        }
        int offset=textView.getLineCount()*textView.getLineHeight();
        if (offset > textView.getHeight()) {
            textView.scrollTo(0,offset - textView.getHeight());
        }
        Log.d("this", "getRecord: "+record);
    }

    public String delete(){
        String recordTemp = textView.getText().toString();
        int line = textView.getLayout().getLineCount();
        int start = textView.getLayout().getLineStart(0);
        int end = textView.getLayout().getLineEnd(line - 1);
        if(end-1 == -1){
            return "";
        }
        recordTemp = recordTemp.substring(start, end - 1);
        return recordTemp;
    }

    }

