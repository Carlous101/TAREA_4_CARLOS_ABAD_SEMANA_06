package com.example.evaluadoresapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adaptador_evaluados extends RecyclerView.Adapter<vista_Evaluados>{
    private Context Ctx;
    private List<UTEQ_2_Evaluar> lstEvaluados;
    public adaptador_evaluados(Context mCtx, List<UTEQ_2_Evaluar> usuarios) {
        this.lstEvaluados = usuarios;
        Ctx=mCtx;
    }
    @Override
    public vista_Evaluados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.evaluados_docentes, null);
        //view.setOnClickListener(this);
        return new vista_Evaluados(view);
    }

    @Override
    public void onBindViewHolder(vista_Evaluados holder, int position) {
        UTEQ_2_Evaluar usuario = lstEvaluados.get(position);
        holder.nombre.setText(usuario.getNombreevaluado());
        holder.identificacion.setText(usuario.getIdevaluado());
        holder.situacion.setText(usuario.getSituacion());
        holder.genero.setText(usuario.getGenero());
        holder.cargo.setText(usuario.getCargo());
        holder.fechainicio.setText(usuario.getFechainicio());
        holder.fechafin.setText(usuario.getFechafin());
        Glide.with(Ctx)
                .load(usuario.getUrlimg2())
                .error(R.drawable.unknown)
                .into(holder.avatarUrl);
    }
    @Override
    public int getItemCount() {
        final int size = lstEvaluados.size();
        return size;
    }
}
