package com.testing.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorTitulares extends RecyclerView.Adapter<AdaptadorTitulares.TitularesViewHolder> implements View.OnClickListener{
    private ArrayList<Titular> datos;
    private View.OnClickListener listener;

    public AdaptadorTitulares(ArrayList<Titular> datos) {
        this.datos = datos;
    }

    @Override
    public TitularesViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        itemView.setOnClickListener(this);

        TitularesViewHolder tvh = new TitularesViewHolder(itemView);
        return tvh;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(TitularesViewHolder viewHolder, int pos) {
        Titular item = datos.get(pos);
        viewHolder.bindTitular(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    public static class TitularesViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitulo;
        private TextView txtSubtitulo;

        public TitularesViewHolder(View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.lblTitulo);
            txtSubtitulo = itemView.findViewById(R.id.lblSubTitulo);
        }

        public void bindTitular(Titular t) {
            txtTitulo.setText(t.getTitulo());
            txtSubtitulo.setText(t.getSubtitulo());
        }
    }
}