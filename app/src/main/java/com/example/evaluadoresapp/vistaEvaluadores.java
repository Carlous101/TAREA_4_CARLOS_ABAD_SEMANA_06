package com.example.evaluadoresapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class vistaEvaluadores extends RecyclerView.ViewHolder{
    TextView textViewName, textarea, textideEvaluador;
    ImageView imageView;
    public vistaEvaluadores(View itemView) {
        super(itemView);

        textViewName= itemView.findViewById(R.id.txtnombre);
        textarea = itemView.findViewById(R.id.txtarea);
        textideEvaluador = itemView.findViewById(R.id.txtidentificacion);
        imageView = itemView.findViewById(R.id.imgAvatar);
        }
}
