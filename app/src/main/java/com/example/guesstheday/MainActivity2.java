package com.example.guesstheday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView tv,tv2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String str2;
        str2=intent.getStringExtra(MainActivity.FINAL);
        tv=findViewById(R.id.textView2);
        tv2=findViewById(R.id.textView4);
        tv.setText("Your score is  :");
        tv2.setText(str2);
        b=findViewById(R.id.button5);
    }
    public void again(View view){
        Toast.makeText(this, "New Game", Toast.LENGTH_SHORT).show();
        Intent intent2=new Intent(this,MainActivity.class);
        startActivity(intent2);
        finish();
    }
}