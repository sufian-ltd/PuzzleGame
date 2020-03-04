package com.example.pavilion.puzzlegame;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainMenu extends AppCompatActivity {

    MediaPlayer player;
    ToggleButton toggleBtn,toggleBtn2;
    Animation animation;
    Button b2,b3;
    TextView b1;
    Boolean  effect=true;
    SoundPool sp;
    int sound1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.main_menu);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_down);
        toggleBtn=findViewById(R.id.toggleButton);
        toggleBtn2=findViewById(R.id.toggleButton2);
        player=new MediaPlayer();
        b1=findViewById(R.id.btnName);
        b2=findViewById(R.id.btnStart);
        b3=findViewById(R.id.buttonDev);
        b1.startAnimation(animation);
        b2.startAnimation(animation);
        b3.startAnimation(animation);
        toggleBtn.startAnimation(animation);
        toggleBtn2.startAnimation(animation);
        sp=new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        sound1=sp.load(getApplicationContext(),R.raw.click,1);
    }
    public void startClick(View v)
    {
        startEffect();
        Intent intent=new Intent(MainMenu.this,LevelSelect.class);
        if(toggleBtn.isChecked() && !player.isPlaying()) {
            player=MediaPlayer.create(this, R.raw.backgroundmusic);
            player.start();
            player.setLooping(true);
        }
        intent.putExtra("effect",effect);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        if(player.isLooping() || player.isPlaying()) {
            player.stop();
            player=null;
        }
        finish();
    }
    public void toggleBtnClick(View v) {
        if(!toggleBtn.isChecked()) {
            if(player.isPlaying()) {
                player.stop();
            }
        }
    }

    public void devBtnClick(View view) {
        startEffect();
        Intent intent=new Intent(MainMenu.this,AboutDeveloper.class);
        startActivity(intent);
    }

    public void startEffect(){
        if(toggleBtn2.isChecked()) {
            sp.play(sound1,1.0f,1.0f,0,0,10f);
        }
    }

    public void effectClick(View view) {
        if(toggleBtn2.isChecked()){
            effect=true;
        }
        else{
            effect=false;
        }
    }
}
