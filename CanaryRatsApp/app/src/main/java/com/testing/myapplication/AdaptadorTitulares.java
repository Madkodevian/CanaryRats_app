package com.testing.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AdaptadorTitulares extends ArrayAdapter<Titular> {
    private ListView lstOpciones;
    private ListView lblTitulo;
    private ListView lblSubTitulo;
    //final String[] datos = new String[]{};

    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.listitem_titular, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_titular, null);

        TextView lblTitulo = item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(datos[position].getTitulo());

        TextView lblSubtitulo = item.findViewById(R.id.lblSubTitulo);
        lblSubtitulo.setText(datos[position].getSubtitulo());

        return(item);
    }
}