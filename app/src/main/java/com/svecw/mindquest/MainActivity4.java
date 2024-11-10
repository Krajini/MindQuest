package com.svecw.mindquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    Button bx;
    Button bd;
    Button bs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        bx=findViewById(R.id.button7);
        bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(MainActivity4.this,MainActivity2.class);
                startActivity(i4);
            }
        });
        bd=findViewById(R.id.button3);
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(MainActivity4.this,MainActivity7.class);
                startActivity(i7);
            }
        });
        bs=findViewById(R.id.button6);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(MainActivity4.this,MainActivity8.class);
                startActivity(i8);
            }
        });
    }
}