package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView recView;
    private ArrayList<Titular> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Titular>();
        for(int i=0; i<50; i++)
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));

        //Inicialización RecyclerView
        recView = findViewById(R.id.RecViewListItem);
        recView.setHasFixedSize(true);

        final AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);

        recView.setAdapter(adaptador);

        recView.setAdapter(adaptador);

        recView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Elemento1", Toast.LENGTH_SHORT).show();
    }
}