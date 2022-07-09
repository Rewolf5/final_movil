package com.fmacha.final_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Salir extends AppCompatActivity {
    TextView tvDatos;
    ImageView ivRegresar;
    ImageView ivSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salir);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);

        recibirDatos();

        ivRegresar=(ImageView) findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        ivSalir=(ImageView) findViewById(R.id.ivSalir);
        ivSalir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


            }
        });
    }
    private void recibirDatos(){
        Bundle  extras =getIntent().getExtras();
        String d1=extras.getString("dato01");
        String d2=extras.getString("dato02");

        tvDatos=(TextView) findViewById(R.id.tvDatos);
        tvDatos.setText(d1+d2);

    }
}