package com.testing.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class ShopActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView recView;
    private ArrayList<Titular> datos;
    private Button buttonUpdate;
    private Button buttonRemove;
    private Button buttonMove;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //Buttons
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonRemove = findViewById(R.id.buttonRemove);
        buttonMove = findViewById(R.id.buttonMove);

        //Navigation menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        //Otra forma
        //navigationView = (NavigationView)findViewById(R.id.navigation_view);

        //navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Titular>();
        for (int i = 0; i < 11; i++)
            datos.add(new Titular("Camiseta " + i, "Logo " + i));

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
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        //BOTONES CRUD
        //Cambiar texto por imagen para los botones

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(1, new Titular("Nueva camisa", "Nuevo logo"));
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
                datos.set(1, datos.get(2));
                datos.set(2, aux);

                adaptador.notifyItemMoved(1, 2);
            }
        });

        //MENU NAV
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (item.getItemId()) {
                            case R.id.mnuOpc1Profile:
                                fragment = new ProfileFragment();
                                fragmentTransaction = true;
                                Log.e("OPCION 1. PERFIL", "Funciona aparentemente");
                                break;
                            case R.id.mnuOpc2Shop:
                                fragment = new ShopFragment();
                                fragmentTransaction = true;
                                Log.e("OPCION 2. TIENDA", "Funciona aparentemente");
                                break;
                            case R.id.mnuOpc3GetInTouch:
                                fragment = new GetInTouchFragment();
                                fragmentTransaction = true;
                                Log.e("OPCION 3. CONTACTO", "Funciona aparentemente");
                                break;
                        }
                        if (fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                            item.setChecked(true);
                            getSupportActionBar().setTitle(item.getTitle());
                            Log.e("C3", "Funciona menu");
                        }
                        drawer.closeDrawers();
                        return true;
                    }
                });

    }

    /**
     * //SEPARACION DE LA LISTA
     * //Establece una separación de cero entre los elementos.
     * RecyclerView.ItemDecoration decoration = new RecyclerView.ItemDecoration() {
     *
     * @Override public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
     * super.getItemOffsets(outRect, view, parent, state);
     * outRect.set(2, 2, 2, 2);
     * recView.addItemDecoration(decoration);
     * <p>
     * //agregar
     * //recView.setAdapter(adaptador);
     * }
     * };
     */


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Elemento1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
            //...
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void fade(View button) {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}