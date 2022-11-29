package com.testing.myapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.widget.TextView;

public class LoginInActivity extends AppCompatActivity {

    private TextView txtSaludoUsuario;
    private TextView textViewParrafo;
    private DrawerLayout drawer;
    //private static final int mnuOpc1Profile = 1;
    //private static final int mnuOpc2Shop = 2;
    //private static final int mnuOpc3GetInTouch = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginin);

        //Localizar los controles
        txtSaludoUsuario = findViewById(R.id.txtSaludoUsuario);
        textViewParrafo = findViewById(R.id.textViewParrafo);

        //Navigation menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtSaludoUsuario.setText("Ha iniciado sesión, usuario " + bundle.getString("EMAIL"));

        textViewParrafo.setText("Éste es su perfil de Usuario. Para acceder a otras opciones, seleccione uno de los botones de abajo.");
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}