package com.example.trawr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText a;
    private EditText heig;
    private EditText weig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        a = findViewById(R.id.editText);
        heig = (EditText) findViewById(R.id.ed_height);
        weig = (EditText) findViewById(R.id.ed_weight);
    }

    public void show(View view) {
        ImageView view1 = (ImageView) findViewById(R.id.ok);
        double w_value = Double.parseDouble(weig.getText().toString());
        double h_value = Double.parseDouble(heig.getText().toString());
        double bmi = w_value / (h_value/100.0 * h_value/100.0);
        DecimalFormat df = new DecimalFormat("#.#");
        String msg;
        if(bmi<18.5){
            msg = getString(R.string.strweightless);
            view1.setImageResource(R.drawable.a1);
        } else if (bmi >24){
            msg = getString(R.string.stroverweight);
            view1.setImageResource(R.drawable.a2);
        } else{
            msg = getString(R.string.strnormalweight);
            view1.setImageResource(R.drawable.a3);
        }
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        TextView b = findViewById(R.id.textView2);
        b.setText(a.getText().toString() + getString(R.string.strbmi) + df.format(bmi) + msg);
    }

    public void nextP(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("height",heig.getText().toString());
        bundle.putString("weight",weig.getText().toString());
        bundle.putString("name",a.getText().toString());

        Intent intent = new Intent(this,ShowBMIActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
