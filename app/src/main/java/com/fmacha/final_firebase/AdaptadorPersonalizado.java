package com.fmacha.final_firebase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.MyViewHolder> {

    private Context context;
    private List<Contacto> listaContactos=new ArrayList<>();
    public AdaptadorPersonalizado(Context context,List<Contacto> listaContactos){
        this.context=context;
        this.listaContactos=listaContactos;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(this.context);
        View vista=inflater.inflate(R.layout.fila,parent,false);
        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.MyViewHolder holder, int position) {
        holder.filaNombres.setText(listaContactos.get(position).getNombres()+" "+listaContactos.get(position).getApellidos());
        holder.filaCorreo.setText(listaContactos.get(position).getCorreo()+"");
        holder.fila.setOnLongClickListener(view -> {
            Intent intent= new Intent(context, MainActivity.class);
            intent.putExtra("pid", listaContactos.get(position).getId()+"");
            intent.putExtra("pnombres",listaContactos.get(position).getNombres()+"");
            intent.putExtra("papellidos",listaContactos.get(position).getApellidos()+"");
            intent.putExtra("pcorreo",listaContactos.get(position).getCorreo()+"");
            context.startActivity(intent);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView filaNombres, filaCorreo;
        LinearLayout fila;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            filaNombres=itemView.findViewById(R.id.filaNombres);
            filaCorreo=itemView.findViewById(R.id.filaCorreo);
            fila=itemView.findViewById(R.id.fila);
        }
    }
}
