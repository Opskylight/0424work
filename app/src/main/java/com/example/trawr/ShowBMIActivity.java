package com.example.trawr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ShowBMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_b_m_i);

        TextView a = (TextView) findViewById(R.id.textView5);
        ImageView view1 = (ImageView) findViewById(R.id.imageView);
        TextView show_bmi = (TextView) findViewById(R.id.textView6);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String h  = bundle.getString("height");
        String w = bundle.getString("weight");
        double bmi = Double.parseDouble(w)/(Double.parseDouble(h)/100.0*Double.parseDouble(h)/100.0);
        DecimalFormat df = new DecimalFormat("#.#");
        String msg;
        if(bmi<18.5){
            msg = "體重過輕";
            view1.setImageResource(R.drawable.a1);
        } else if (bmi >24){
            msg = "體重過重";
            view1.setImageResource(R.drawable.a2);
        } else{
            msg = "正常體重";
            view1.setImageResource(R.drawable.a3);
        }
//        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
//        TextView b = findViewById(R.id.textView2);
        a.setText(name);
        show_bmi.setText("你的BMI是" + df.format(bmi)+msg);

    }
}
