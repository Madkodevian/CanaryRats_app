package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView recView;
    private ArrayList<Titular> datos;
    private Button buttonUpdate;
    private Button buttonRemove;
    private Button buttonMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //Buttons
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonRemove= findViewById(R.id.buttonRemove);
        buttonMove = findViewById(R.id.buttonMove);

        //inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Titular>();
        for(int i=0; i<50; i++)
            datos.add(new Titular("Camiseta " + i, "Camiseta con logo " + i));

        //Inicialización RecyclerView
        recView = findViewById(R.id.RecViewListItem);
        recView.setHasFixedSize(true);

        final AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento " +
                        recView.getChildAdapterPosition(v));
            }
        });

        recView.setAdapter(adaptador);

        recView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        //BOTONES CRUD
        //Cambiar texto por imagen para los botones

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(1, new Titular("Nuevo titular", "Subtitulo nuevo titular"));
                adaptador.notifyItemInserted(1);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.remove(1);
                adaptador.notifyItemRemoved(1);
            }
        });

        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Titular aux = datos.get(1);
                datos.set(1,datos.get(2));
                datos.set(2,aux);

                adaptador.notifyItemMoved(1, 2);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Elemento1", Toast.LENGTH_SHORT).show();
    }
}