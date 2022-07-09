package com.fmacha.final_firebase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtApellido, txtCorreo;
    Button btnRegistrar;

    Contacto contacto;
    FirebaseDatabase database;
    DatabaseReference reference;
    boolean registra=true;
    String id;
    HashMap map=new HashMap();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarReferencias();
        inicializarFirebase();
        obtenerValores();
    }

    private  void obtenerValores(){
        if(getIntent().hasExtra("pid")){
            registra=false;
            id=getIntent().getStringExtra("pid");
            txtNombre.setText(getIntent().getStringExtra("pnombres"));
            txtApellido.setText(getIntent().getStringExtra("papellidos"));
            txtCorreo.setText(getIntent().getStringExtra("pcorreo"));

        }

    }

    private  void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
    }

    private void asignarReferencias(){
        txtNombre=findViewById(R.id.txtNombres);
        txtApellido=findViewById(R.id.txtApellidos);
        txtCorreo=findViewById(R.id.txtCorreo);
        btnRegistrar=findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(view -> {
            capturarDatos();
            String mensaje = "";

            if(registra){
                reference.child("Contacto").child(contacto.getId()).setValue(contacto);
                mensaje = "Persona Registrada";
            }else{
                reference.child("Contacto").child(id).updateChildren(map);
                mensaje="Persona actualizada";
            }

            AlertDialog.Builder ventana=new AlertDialog.Builder(MainActivity.this);
            ventana.setTitle("Mensaje informativo");
            ventana.setMessage(mensaje);
            ventana.setPositiveButton("ACEPTAR", (dialogInterface, i) -> {
                finish();
            });
            ventana.create().show();
        });
    }

    private  void capturarDatos(){
        String nombres=txtNombre.getText().toString();
        String apellidos=txtApellido.getText().toString();
        String correo=txtCorreo.getText().toString();

        if(registra) {
            contacto = new Contacto(UUID.randomUUID().toString(), nombres, apellidos, correo);
        }else{
            map.put("nombres",nombres);
            map.put("apellidos",apellidos);
            map.put("correo",correo);
        }

    }
}











