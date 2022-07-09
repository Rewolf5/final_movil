package com.fmacha.final_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class logoActivity extends AppCompatActivity {
     //EditText txtupn;
     //ImageView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_logo);

        Animation animacion1= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView txtupn =findViewById(R.id.txtupn);
        ImageView imglogo=findViewById(R.id.imglogo);



            txtupn.setAnimation(animacion2);
            imglogo.setAnimation(animacion1);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(logoActivity.this,InicioActivity.class);
                    startActivity(intent);
                finish();

                }
            },6000);

    }
    }
