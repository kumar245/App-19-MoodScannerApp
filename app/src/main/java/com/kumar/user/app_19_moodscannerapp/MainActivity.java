package com.kumar.user.app_19_moodscannerapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private ImageView imageView;
   private TextView result;
   private Runnable runnable;
    private AnimationDrawable animationDrawable;
private String[] moodResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moodResults=new String[]{
                "Someone is cranky!",
                "You are my sunshine!",
                "No comments...",
                "You're stressed out!",
                "Happy camper :)",
                "Not your day :(",
                "Smile - it's good for you.",
                "In the clouds...",
                "Pensive!",
                "Sad!",
                "Excited!"
        };
        imageView= (ImageView) findViewById(R.id.thumbPrint);
        imageView.setBackgroundResource(R.drawable.thumb_animations);
        animationDrawable= (AnimationDrawable) imageView.getBackground();
        result= (TextView) findViewById(R.id.result);
       imageView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               animationDrawable.start();
               showResult();
               return true;
           }
       });
    }
    public void showResult(){
        runnable=new Runnable() {
            @Override
            public void run() {
                int rand= (int) (Math.random() * moodResults.length);
                result.setText(moodResults[rand]);
                animationDrawable.stop();
            }
        };
        Handler handler=new Handler();
        handler.postDelayed(runnable,5000);
    }
}
