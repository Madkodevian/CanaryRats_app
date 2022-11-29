package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginInActivity extends AppCompatActivity {

    private TextView txtSaludoUsuario;
    private TextView textViewParrafo;
    private static final int mnuOpc1Profile = 1;
    private static final int mnuOpc2Shop = 2;
    private static final int mnuOpc3GetInTouch = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginin);

        //Localizar los controles
        txtSaludoUsuario = findViewById(R.id.txtSaludoUsuario);
        textViewParrafo = findViewById(R.id.textViewParrafo);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtSaludoUsuario.setText("Ha iniciado sesión, usuario " + bundle.getString("EMAIL"));

        textViewParrafo.setText("Éste es su perfil de Usuario. Para acceder a otras opciones, seleccione uno de los botones de abajo.");
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

}