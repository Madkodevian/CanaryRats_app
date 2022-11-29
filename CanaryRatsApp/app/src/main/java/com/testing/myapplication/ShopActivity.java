package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;


public class ShopActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView recView;
    private ArrayList<Titular> datos;
    private Button buttonUpdate;
    private Button buttonRemove;
    private Button buttonMove;
    private static final int mnuOpc1Profile = 1;
    private static final int mnuOpc2Shop = 2;
    private static final int mnuOpc3GetInTouch = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //setContentView(R.menu.main_menu);

        //Buttons
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonRemove= findViewById(R.id.buttonRemove);
        buttonMove = findViewById(R.id.buttonMove);

        //inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Titular>();
        for(int i=0; i<11; i++)
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
                datos.add(1, new Titular("Nueva camisa", "nueva camiseta con logo"));
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
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, mnuOpc1Profile, Menu.NONE, "Perfil")
                .setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(Menu.NONE, mnuOpc2Shop, Menu.NONE, "Tienda")
                .setIcon(android.R.drawable.ic_menu_compass);
        menu.add(Menu.NONE, mnuOpc3GetInTouch, Menu.NONE, "Contacto")
                .setIcon(android.R.drawable.ic_menu_agenda);
        return true;
    }

    //Establece una separación de cero entre los elementos.
    RecyclerView.ItemDecoration decoration = new RecyclerView.ItemDecoration() {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(2, 2, 2, 2);
            recView.addItemDecoration(decoration);

            //agregar
            //recView.setAdapter(adaptador);
        }
    };

    /**
    public static int getMnuOpc2Shop() {
        return mnuOpc2Shop;
    }


    int id = mnuOpc2Shop.getItemId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (mnuOpc2Shop.getItemId()) {
            case android.R.id.mnuOpc2Shop:
                //Creamos el Intent
                Intent intent =
                        new Intent(ShopActivity.this, LoginActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Elemento1", Toast.LENGTH_SHORT).show();
    }
}