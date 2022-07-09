package com.fmacha.final_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.navigationdrawer.MenuActivity;

public class InicioActivity extends AppCompatActivity {
    EditText user, pass;
    Button btnEntrar, btnRegistrar;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        user=(EditText) findViewById(R.id.User);
        pass=(EditText) findViewById(R.id.Pass);
        btnEntrar=(Button) findViewById(R.id.btnEntrar);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrar);
        dao = new daoUsuario(this);

        btnEntrar.setOnClickListener(this::onClick);
        btnRegistrar.setOnClickListener(this::onClick);
    }

public void onClick(View v){
    switch (v.getId()){
        case R.id.btnEntrar:
            String u =user.getText().toString();
            String p =pass.getText().toString();
            if(u.equals("")&&p.equals("")){
                Toast.makeText(this, "Error: Campo vacio", Toast.LENGTH_LONG).show();
            }else if(dao.login(u,p)==1){
                Usuario ux=dao.getUsuario(u,p);
                Toast.makeText(this, "Dato Correcto", Toast.LENGTH_LONG).show();
                Intent i2= new Intent(InicioActivity.this, Navigation_drawer.class);
                i2.putExtra("Id",ux.getId());
                startActivity(i2);
                finish();
            }else{
                Toast.makeText(this, "Usuario y/o Incorrecto", Toast.LENGTH_LONG).show();

            }
            break;

        case R.id.btnRegistrar:
            Intent i= new Intent(InicioActivity.this,Registrar.class);
            startActivity(i);
            break;
    }

}

}