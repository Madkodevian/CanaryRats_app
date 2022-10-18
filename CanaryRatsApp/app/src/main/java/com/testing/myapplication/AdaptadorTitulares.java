package com.testing.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdaptadorTitulares extends ArrayAdapter<Titular> {
    private List<Titular> listaTitular;
    private int resourceLayout;
    private Context contexto;


    public AdaptadorTitulares(@NonNull Context context, int resource, List <Titular> objects) {
        super(context, R.layout.activity_shop, resource, objects);
        this.listaTitular = objects;
        this.contexto = context;
        this.resourceLayout = resource;

    }

    //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(contexto).inflate(R.layout.activity_shop,null);
            //view = LayoutInflater.from(contexto).inflate(R.layout.item_list,null);
        }

        Titular titular = listaTitular.get(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_list, null);

        ImageView imagen = item.findViewById(R.id.imgProduct);
        //imagen.setImageResource(listaTitular.getImg());
        //add on Titular
        imagen.setImageResource(titular.getImg());

        TextView lblTitulo = item.findViewById(R.id.lblTitulo);
        //lblTitulo.setText(listaTitular[position].getTitulo());
        lblTitulo.setText(titular.getTitulo());

        TextView lblSubtitulo = item.findViewById(R.id.lblSubTitulo);
        //lblSubtitulo.setText(listaTitular[position].getSubtitulo());
        lblTitulo.setText(titular.getSubtitulo());

        return(item);
    }
}