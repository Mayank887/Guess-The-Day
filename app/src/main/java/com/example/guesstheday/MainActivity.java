package com.example.guesstheday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public  static final String FINAL="com.example.guesstheday.score";
    TextView tv,tv2,tv3;
    String[] months={"January","February","March","April","May","June","July","August","September"
    ,"October","November","December"};
    Button[] buttons=new Button[4];
    int dow;
    int i;
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    int score=0;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0]=findViewById(R.id.button);
        buttons[1]=findViewById(R.id.button2);
        buttons[2]=findViewById(R.id.button3);
        buttons[3]=findViewById(R.id.button4);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView3);
        tv3=findViewById(R.id.textView5);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
       // tv3.setText(""+score);
        shown();
    }

    public void shown() {

        Random random=new Random();
        int y=random.nextInt(2021-2011)+2011;
        int a=random.nextInt(1000);
        GregorianCalendar gc=new GregorianCalendar();
        int m=(a%12)+1;
        int d=(a%28)+1;
        gc.set(GregorianCalendar.YEAR,y);
        gc.set(GregorianCalendar.MONTH,m);
        gc.set(GregorianCalendar.DATE,d);
        String s;
        s=""+gc.get(GregorianCalendar.DATE)+" / "+months[gc.get(GregorianCalendar.MONTH)]+" / "+gc.get(GregorianCalendar.YEAR);
        tv.setText(s);
        tv2.setText("Q"+(score+1)+".");
        dow=gc.get(GregorianCalendar.DAY_OF_WEEK);


        if(dow==1||dow==2){
            buttons[0].setText(days[dow-1]+"");
            i=0;
        }
        if(dow==3||dow==4){
            buttons[1].setText(days[dow-1]+"");
            i=1;
        }
        if(dow==5||dow==6){
            buttons[2].setText(days[dow-1]+"");
            i=2;
        }
        if(dow==7){
            buttons[3].setText(days[dow-1]+"");
            i=3;
        }
        for(int j=1;j<4;j++){
            buttons[(i+j)%4].setText(""+days[(dow+j)%7]);
        }
        tv3.setText("Current Score : "+score);


    }
    public void button1(View view){
        vibrator.vibrate(200);

    if(dow==1||dow==2){
        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        score++;
        shown();
    }
    else{
        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity2.class);
        String str;
        str=""+score;
        intent.putExtra(FINAL,str);
        startActivity(intent);
        finish();
        
    }

    }
    public void button2(View view){
        vibrator.vibrate(200);

        if(dow==3||dow==4){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            score++;
            shown();
        }
        else{
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity2.class);
            String str;
            str=""+score;
            intent.putExtra(FINAL,str);
            startActivity(intent);
            finish();

        }

    }
    public void button3(View view){
        vibrator.vibrate(200);

        if(dow==5||dow==6){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            score++;
            shown();
        }
        else{
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity2.class);
            String str;
            str=""+score;
            intent.putExtra(FINAL,str);
            startActivity(intent);
            finish();

        }

    }
    public void button4(View view){
        vibrator.vibrate(200);

        if(dow==7){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            score++;
            shown();
        }
        else{
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity2.class);
            String str;
            str=""+score;
            intent.putExtra(FINAL,str);
            startActivity(intent);
            finish();

        }

    }
}
