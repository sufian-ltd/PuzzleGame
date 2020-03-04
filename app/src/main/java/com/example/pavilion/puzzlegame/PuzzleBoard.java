package com.example.pavilion.puzzlegame;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleBoard extends AppCompatActivity implements View.OnClickListener{


    ArrayList<String> list;
    String str[];
    int img[];
    String shuffleStr[][];
    Button a1,a2,a3,a4,a5,a6,a7,a8,a9;
    Button btn[][];
    int n=3;
    Boolean effect;
    SoundPool sp;
    int sound1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_board);
        str=getIntent().getStringArrayExtra("str");
        img=getIntent().getIntArrayExtra("img");
        effect=getIntent().getBooleanExtra("effect",false);
        a1=findViewById(R.id.b1);
        a2=findViewById(R.id.b2);
        a3=findViewById(R.id.b3);
        a4=findViewById(R.id.b4);
        a5=findViewById(R.id.b5);
        a6=findViewById(R.id.b6);
        a7=findViewById(R.id.b7);
        a8=findViewById(R.id.b8);
        a9=findViewById(R.id.b9);
        btn=new Button[n][n];
        shuffleStr=new String[n][n];
        list=new ArrayList<String>();

        btn[0][0]=a1;
        btn[0][1]=a2;
        btn[0][2]=a3;
        btn[1][0]=a4;
        btn[1][1]=a5;
        btn[1][2]=a6;
        btn[2][0]=a7;
        btn[2][1]=a8;
        btn[2][2]=a9;
        sp=new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        sound1=sp.load(getApplicationContext(),R.raw.click,1);
        shuffleImage();
    }

    public void shuffleImage()
    {
        for(int i=0;i<n*n;i++)
        {
            list.add(str[i]);
        }
        Collections.shuffle(list);
        int k=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                btn[i][j].setOnClickListener(this);
                setImageAndText(i, j,list.get(k));
                ++k;
            }
        }
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!shuffleStr[i][j].equals(" ") && btn[i][j]==v) {
                    checkForEmptyButton(i, j);
                }
            }
        }

    }
    public void checkForEmptyButton(int row,int col)
    {
        String tempChar=shuffleStr[row][col];
        int a=row-1,b=row+1,c=col-1,d=col+1;
        try
        {
            if(a>=0 && shuffleStr[a][col].equals(" "))
            {
                shuffleStr[row][col]=" ";
                btn[row][col].setBackgroundResource(0);
                setImageAndText(a, col,tempChar);
            }
            else if(b<n && shuffleStr[b][col].equals(" "))
            {
                shuffleStr[row][col]=" ";
                btn[row][col].setBackgroundResource(0);
                setImageAndText(b, col,tempChar);
            }
            else if(c>=0 && shuffleStr[row][c].equals(" "))
            {
                shuffleStr[row][col]=" ";
                btn[row][col].setBackgroundResource(0);
                setImageAndText(row, c, tempChar);
            }
            else if(d<n && shuffleStr[row][d].equals(" "))
            {
                shuffleStr[row][col]=" ";
                btn[row][col].setBackgroundResource(0);
                setImageAndText(row, d,tempChar);
            }
            checkForWin();
            if(effect){
                sp.play(sound1,1.0f,1.0f,0,0,10f);
            }
        }
        catch(Exception ex)
        {

        }
    }

    public void setImageAndText(int a,int b,String tempChar)
    {
        shuffleStr[a][b]=tempChar;
        if(tempChar.equals(" "))
            btn[a][b].setBackgroundResource(0);
        else if(tempChar.equals(str[0]))
            btn[a][b].setBackgroundResource(img[0]);
        else if(tempChar.equals(str[1]))
            btn[a][b].setBackgroundResource(img[1]);
        else if(tempChar.equals(str[2]))
            btn[a][b].setBackgroundResource(img[2]);
        else if(tempChar.equals(str[3]))
            btn[a][b].setBackgroundResource(img[3]);
        else if(tempChar.equals(str[4]))
            btn[a][b].setBackgroundResource(img[4]);
        else if(tempChar.equals(str[5]))
            btn[a][b].setBackgroundResource(img[5]);
        else if(tempChar.equals(str[6]))
            btn[a][b].setBackgroundResource(img[6]);
        else if(tempChar.equals(str[7]))
            btn[a][b].setBackgroundResource(img[7]);
        else if(tempChar.equals(str[8]))
            btn[a][b].setBackgroundResource(img[8]);
    }

    public void checkForWin()
    {
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!str[c].equalsIgnoreCase(shuffleStr[i][j]))
                    return;
                ++c;
            }
        }
        setFinalImage();
//        shuffleStr[0][2]="a3";
//        btn[0][2].setBackgroundResource(R.drawable.a3);
//        playWinMusic();
    }

    public void setFinalImage(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(shuffleStr[i][j].equals(" ")){
                    for(int k=0;k<str.length;k++){
                        if(str[k].equals(" ")){
                            shuffleStr[i][j]=str[k]+(k+1);
                            btn[i][j].setBackgroundResource(img[k]);
                            playWinMusic();
                        }
                    }
                }
            }
        }
    }

    public void playWinMusic()
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.match);
        mediaPlayer.start();
    }
}
