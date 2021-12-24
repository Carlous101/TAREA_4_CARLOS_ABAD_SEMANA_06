package com.example.evaluadoresapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class vista_Evaluados extends RecyclerView.ViewHolder{
    TextView nombre, identificacion, genero, situacion, cargo, fechainicio, fechafin;
    ImageView avatarUrl;

    public vista_Evaluados(View Itemview){
        super(Itemview);
        nombre = Itemview.findViewById(R.id.txtnombre);
        identificacion = Itemview.findViewById(R.id.txtidentificacion);
        genero = Itemview.findViewById(R.id.txtgenero);
        situacion = Itemview.findViewById(R.id.txtsituacion);
        cargo = Itemview.findViewById(R.id.txtcargo);
        fechainicio = Itemview.findViewById(R.id.txtfechainicio);
        fechafin = Itemview.findViewById(R.id.txtfechafin);
        avatarUrl = Itemview.findViewById(R.id.imgAvatar);

    }
}
