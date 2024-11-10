package com.svecw.mindquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    Button bf;
    Button bp;
    Button b11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bf=findViewById(R.id.button13);
        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i3=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(i3);
            }
        });
        bp=findViewById(R.id.button12);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(MainActivity3.this,MainActivity5.class);
                startActivity(i5);
            }
        });
        b11=findViewById(R.id.button11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(MainActivity3.this,MainActivity6.class);
                startActivity(i6);
            }
        });
    }
}