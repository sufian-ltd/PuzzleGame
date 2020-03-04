package com.example.pavilion.puzzlegame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class LevelSelect extends AppCompatActivity {

    Animation animation;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    Boolean effect;
    SoundPool sp;
    int sound1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_select);
        effect=getIntent().getBooleanExtra("effect",false);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_down);
        setAnimationButton();
        sp=new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        sound1=sp.load(getApplicationContext(),R.raw.click,1);
    }
    public void setAnimationButton(){
        b1=findViewById(R.id.buttonLvl1);
        b2=findViewById(R.id.buttonLvl2);
        b3=findViewById(R.id.buttonLvl3);
        b4=findViewById(R.id.buttonLvl4);
        b5=findViewById(R.id.buttonLvl5);
        b6=findViewById(R.id.buttonLvl6);
        b7=findViewById(R.id.buttonLvl7);
        b8=findViewById(R.id.buttonLvl8);
        b9=findViewById(R.id.buttonLvl9);
        b10=findViewById(R.id.buttonLvl10);

        b1.startAnimation(animation);
        b2.startAnimation(animation);
        b3.startAnimation(animation);
        b4.startAnimation(animation);
        b5.startAnimation(animation);
        b6.startAnimation(animation);
        b7.startAnimation(animation);
        b8.startAnimation(animation);
        b9.startAnimation(animation);
        b10.startAnimation(animation);
    }
    public void selectLevel(View v)
    {
        if (effect){
            sp.play(sound1,1.0f,1.0f,0,0,10f);
        }
        if(v==b1)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"a1","a2"," ","a4","a5","a6","a7","a8","a9"};
            int img[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
                    R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9};
            goNext(str,img);
        }
        else if(v==b2)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"b1","b2"," ","b4","b5","b6","b7","b8","b9"};
            int img[]={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,
                    R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9};
            goNext(str,img);
        }
        else if(v==b3)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"c1"," ","c3","c4","c5","c6","c7","c8","c9"};
            int img[]={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9};
            goNext(str,img);
        }
        else if(v==b4)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"d1","d2","d3","d4","d5","d6"," ","d8","d9"};
            int img[]={R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9};
            goNext(str,img);
        }
        else if(v==b5)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"e1","e2"," ","e4","e5","e6","e7","e8","e9"};
            int img[]={R.drawable.e1,R.drawable.e2,R.drawable.e3,R.drawable.e4,R.drawable.e5,
                    R.drawable.e6,R.drawable.e7,R.drawable.e8,R.drawable.e9};
            goNext(str,img);
        }
        else if(v==b6)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"f1","f2"," ","f4","f5","f6","f7","f8","f9"};
            int img[]={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,
                    R.drawable.f6,R.drawable.f7,R.drawable.f8,R.drawable.f9};
            goNext(str,img);
        }
        else if(v==b7)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"g1","g2"," ","g4","g5","g6","g7","g8","g9"};
            int img[]={R.drawable.g1,R.drawable.g2,R.drawable.g3,R.drawable.g4,R.drawable.g5,
                    R.drawable.g6,R.drawable.g7,R.drawable.g8,R.drawable.g9};
            goNext(str,img);
        }
        else if(v==b8)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {"h1","h2","h3","h4","h5","h6","h7","h8"," "};
            int img[]={R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9};
            goNext(str,img);
        }
        else if(v==b9)
        {
            Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
            String str[]= {" ","k2","k3","k4","k5","k6","k7","k8","k9"};
            int img[]={R.drawable.k1,R.drawable.k2,R.drawable.k3,R.drawable.k4,R.drawable.k5,
                    R.drawable.k6,R.drawable.k7,R.drawable.k8,R.drawable.k9};
            goNext(str,img);
        }
        else if(v==b10)
        {
            String str[]= {"l1","l2","l3","l4","l5","l6","l7"," ","l9"};
            int img[]={R.drawable.l1,R.drawable.l2,R.drawable.l3,R.drawable.l4,R.drawable.l5,
                    R.drawable.l6,R.drawable.l7,R.drawable.l8,R.drawable.l9};
            goNext(str,img);
        }

    }
    public void goNext(String str[],int img[]){
        Intent intent=new Intent(LevelSelect.this,PuzzleBoard.class);
        intent.putExtra("str",str);
        intent.putExtra("img",img);
        intent.putExtra("effect",effect);
        startActivity(intent);
    }
}
