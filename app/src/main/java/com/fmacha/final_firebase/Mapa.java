package com.fmacha.final_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Mapa extends AppCompatActivity {

    Button btnB,btnO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa2);
        asignarReferencias();
    }

    private void asignarReferencias(){
        btnB=findViewById(R.id.btnBrena);
        btnO=findViewById(R.id.btnCallao);

        btnB.setOnClickListener(view -> {
            Intent intent=new Intent(Mapa.this, MapaActivity.class);
            intent.putExtra("latitud","-11.865975900184962");
            intent.putExtra("longitud","-77.07764807484399");
            intent.putExtra("titulo","Comisaria de Puente Piedra");
            startActivity(intent);
        });

        btnO.setOnClickListener(view -> {
            Intent intent=new Intent(Mapa.this, MapaActivity.class);
            intent.putExtra("latitud","-12.054651162004372");
            intent.putExtra("longitud","-77.12887801902056");
            intent.putExtra("titulo","Comisaría de Callao");
            startActivity(intent);
        });
    }

}