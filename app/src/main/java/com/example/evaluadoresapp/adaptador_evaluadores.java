package com.example.evaluadoresapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adaptador_evaluadores extends RecyclerView.Adapter<vistaEvaluadores>
implements View.OnClickListener{
    private Context contextoEvaluador;
    private List<UTEQ_1_Evaluador> lista_Evaluador_UTEQ;

    public adaptador_evaluadores(Context mcontextoEvaluador, List<UTEQ_1_Evaluador> usuarios) {
        this.lista_Evaluador_UTEQ = usuarios;
        contextoEvaluador=mcontextoEvaluador;
    }
    @Override
    public vistaEvaluadores onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflar y devolver nuestro soporte de vista
        LayoutInflater inflater = LayoutInflater.from(contextoEvaluador);
        View view = inflater.inflate(R.layout.evaluadores_decanos, null);
        view.setOnClickListener(this);
        return new vistaEvaluadores(view);
    }

    @Override
    public int getItemCount() {
        final int size = lista_Evaluador_UTEQ.size();
        return size;
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.Listener =listener;
    }

    @Override
    public void onBindViewHolder(vistaEvaluadores holder, int position) {
        UTEQ_1_Evaluador usuario = lista_Evaluador_UTEQ.get(position);
        holder.textViewName.setText(usuario.getNombre());
        holder.textarea.setText(usuario.getArea());
        holder.textideEvaluador.setText(usuario.getIdEv());
        try {
            Glide.with(contextoEvaluador)
                    .load(usuario.getUrlImg2())
                    .error(R.drawable.unknown)
                    .into(holder.imageView)

            ;//(Drawable("https://evaladmin.uteq.edu.ec/adminimg/unknown.png"));
        }catch(Exception ex){

        }

    }
    private View.OnClickListener Listener;
    @Override
    public void onClick(View v) {
        if (Listener != null){
            Listener.onClick(v);
        }
    }
}
