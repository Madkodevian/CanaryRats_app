package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private final List<Titular> listaTitular = new ArrayList<>();
    AdaptadorTitulares adaptadorTitular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Vista de la lista en ShopActivity
        listView = findViewById(R.id.listItemShop);

        //Aniadir nuevo titulo, subtitulo e imagen
        listaTitular.add(new Titular("Título 1", "Diseño de camisa: 1", R.mipmap.ic_launcher));
        listaTitular.add(new Titular("Título 2", "Diseño de camisa: 2", R.mipmap.ic_launcher));
        listaTitular.add(new Titular("Título 3", "Diseño de camisa: 3", R.mipmap.ic_launcher));
        listaTitular.add(new Titular("Título 4", "Diseño de camisa: 4", R.mipmap.ic_launcher));

        //Nuevo adaptador de titulares
        adaptadorTitular = new AdaptadorTitulares(ShopActivity.this, R.layout.activity_shop, listaTitular);

        //Aniadir a la lista
        listView.setAdapter(adaptadorTitular);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Elemento1", Toast.LENGTH_SHORT).show();
    }
}