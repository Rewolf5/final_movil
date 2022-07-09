package com.fmacha.final_firebase;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class KeepSafe extends Fragment {


    public KeepSafe() {
        // Required empty public constructor
    }



    @Override


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btnContacto = (Button) view.findViewById(R.id.btnContacto);
        Button btnMapa=(Button) view.findViewById(R.id.btnMapa);

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListarActivity.class);
                startActivity(intent);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Mapa.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_keep_safe, container, false);
    }
}



















