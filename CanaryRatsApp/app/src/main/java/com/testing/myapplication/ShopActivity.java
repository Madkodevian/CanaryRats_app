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
    private List<Titular> listaTitular = new ArrayList<>();
    AdaptadorTitulares adaptadorTitular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //Vista de la lista en ShopActivity
        listView = findViewById(R.id.listItemShop);

        //Aniadir nuevo titulo, subtitulo e imagen
        listaTitular.add(new Titular("Título 1", "Subtítulo largo 1", R.mipmap.ic_launcher));
        listaTitular.add(new Titular("Título 2", "Subtítulo largo 2", R.mipmap.ic_launcher));
        listaTitular.add(new Titular("Título 3", "Subtítulo largo 3", R.mipmap.ic_launcher));
        listaTitular.add(new Titular("Título 4", "Subtítulo largo 4", R.mipmap.ic_launcher));

        //Nuevo adaptador de titulares
        adaptadorTitular = new AdaptadorTitulares(ShopActivity.this, R.layout.activity_shop, listaTitular);

        //Aniadir a la lista
        listView.setAdapter(adaptadorTitular);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Elemento1", Toast.LENGTH_SHORT).show();
    }

    /**
    ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, datos);

    ArrayAdapter<CharSequence> adapter =
            ArrayAdapter.createFromResource(this,
                    R.array.valores_array,
                    android.R.layout.simple_spinner_item);
     */

    //cmbOpciones = findViewById(R.id.CmbOpciones);
    //adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    //cmbOpciones.setAdapter(adaptador);

    //AdaptadorTitulares adaptador1 = new AdaptadorTitulares(this, datos);
    //lstOpciones = findViewById(R.id.lstOpciones);
    //lstOpciones.setAdapter(adaptador1);
}