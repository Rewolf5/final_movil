package com.fmacha.final_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {

    RecyclerView rvContactos;
    FloatingActionButton btnNuevo;

    FirebaseDatabase database;
    DatabaseReference reference;
    private List<Contacto>listaContactos =new ArrayList<>();
    AdaptadorPersonalizado adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        asignarReferencias();
        inicializarFirebase();
        mostrarDatos();
    }

    private  void mostrarDatos(){
       reference.child("Contacto").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               listaContactos.clear();
               for(DataSnapshot item:snapshot.getChildren()){
                   Contacto p=item.getValue(Contacto.class);
                   listaContactos.add(p);
               }
               adaptador= new AdaptadorPersonalizado(ListarActivity.this,listaContactos);
               rvContactos.setAdapter(adaptador);
               rvContactos.setLayoutManager(new LinearLayoutManager(ListarActivity.this));
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
    }

    private  void asignarReferencias(){
        rvContactos=findViewById(R.id.rbContacto);
        btnNuevo=findViewById(R.id.btnNuevo);
        btnNuevo.setOnClickListener(view -> {
            Intent intent= new Intent(ListarActivity.this, MainActivity.class);
            startActivity(intent);
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos=viewHolder.getAdapterPosition();
                String id=listaContactos.get(pos).getId();
                listaContactos.remove(pos);
                adaptador.notifyDataSetChanged();
                reference.child("Contacto" +
                        "").child(id).removeValue();
            }
        }).attachToRecyclerView(rvContactos);
    }
}