package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button plus;
    private Button minus;
    private Button tippgomb;
    private ImageView hp1;
    private ImageView hp2;
    private ImageView hp3;
    private ImageView hp4;
    private ImageView[] eletek;
    private TextView tippertek;
    private int tipp;
    private int gondolt;
    private int elet;
    private Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addlisteners();
    }

    private void addlisteners() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp<10){
                    tipp++;
                    tippertek.setText(String.valueOf(tipp));
                }
                else {
                    Toast.makeText(MainActivity.this, "Nem lehet 10-nél nagyobb", Toast.LENGTH_SHORT).show();
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp>1){
                    tipp--;
                    tippertek.setText(String.valueOf(tipp));
                }
                else {
                    Toast.makeText(MainActivity.this, "Nem lehet kisebb mint 1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tippgomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp<gondolt){
                    eletcsokkent();
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                }
                else if (tipp>gondolt){
                    eletcsokkent();
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();
                }
                else{
                    //TODO:Győzelem
                }
            }
        });
    }

    private void eletcsokkent() {
        if (elet>0){
            elet--;
        }
        eletek[elet].setImageResource(R.drawable.heart1);
        if (elet==0){
            //TODO:Vereség
        }
    }

    private void eletcsokkentSwitchCase() {
        elet--;
        switch (elet){
            case 3:
                hp4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                hp3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                hp2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                hp1.setImageResource(R.drawable.heart1);
                break;
        }
        if (elet==0){
            //TODO:Vereség
        }
    }

    private void init(){
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        tippgomb=findViewById(R.id.tippgomb);
        hp1 =findViewById(R.id.hp_1);
        hp2 =findViewById(R.id.hp_2);
        hp3 =findViewById(R.id.hp_3);
        hp4 =findViewById(R.id.hp_4);
        eletek=new ImageView[]{hp1,hp2,hp3,hp4};
        tippertek=findViewById(R.id.tippertek);
        tipp=1;
        rnd=new Random();
        gondolt= rnd.nextInt(10)+1;
        elet=4;
    }
}