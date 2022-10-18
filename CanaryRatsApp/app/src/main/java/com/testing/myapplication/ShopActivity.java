package com.testing.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {
    private ListView listView;
    private ListView lstOpciones;
    private ListView lblTitulo;
    private ListView lblSubTitulo;
    private Spinner cmbOpciones;
    private List<Titular> listaTitular = new ArrayList<>();
    AdaptadorTitulares adaptadorTitular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        listView = findViewById(R.id.listItemShop);
    }

    ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, datos);

    ArrayAdapter<CharSequence> adapter =
            ArrayAdapter.createFromResource(this,
                    R.array.valores_array,
                    android.R.layout.simple_spinner_item);


    //cmbOpciones = findViewById(R.id.CmbOpciones);
    //adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    //cmbOpciones.setAdapter(adaptador);

    //AdaptadorTitulares adaptador1 = new AdaptadorTitulares(this, datos);
    //lstOpciones = findViewById(R.id.lstOpciones);
    //lstOpciones.setAdapter(adaptador1);

    listaTitular.add(new Titular("Titulo 1", "Subtítulo largo 1", R.mipmap.ic_launcher));
    adaptadorTitular = new ListAdapter(ShopActivity.this, R.layout.activity_shop, listaTitular);
    lblTitulo.setAdapter(adaptadorTitular);

    private Titular[] datos =
            new Titular[]{
                    new Titular("Título 1", "Subtítulo largo 1"),
                    new Titular("Título 2", "Subtítulo largo 2"),
                    new Titular("Título 3", "Subtítulo largo 3"),
                    new Titular("Título 4", "Subtítulo largo 4"),
                    new Titular("Título 5", "Subtítulo largo 5"),
                    new Titular("Título 6", "Subtítulo largo 6"),
                    new Titular("Título 7", "Subtítulo largo 7"),
                    new Titular("Título 8", "Subtítulo largo 8"),
                    new Titular("Título 9", "Subtítulo largo 9"),
                    new Titular("Título 10", "Subtítulo largo 10"),
                    new Titular("Título 11", "Subtítulo largo 11"),
                    new Titular("Título 12", "Subtítulo largo 12"),
                    new Titular("Título 13", "Subtítulo largo 13"),
                    new Titular("Título 14", "Subtítulo largo 14"),
                    new Titular("Título 15", "Subtítulo largo 15")};
}