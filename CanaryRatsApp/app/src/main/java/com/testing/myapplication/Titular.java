package com.testing.myapplication;

import android.widget.ArrayAdapter;

public class Titular {
    private String titulo;
    private String subtitulo;
    final String[] datos = new String[]{titulo,subtitulo};

        public Titular(String titulo, String subtitulo){
            this.titulo = titulo;
            this.subtitulo = subtitulo;
        }

    public String getTitulo(){
            return titulo;
        }

        public String getSubtitulo(){
            return subtitulo;
        }

    public String[] getDatos() {
        return datos;
    }

}
