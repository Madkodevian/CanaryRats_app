package com.testing.myapplication;

public class Titular {
    private String titulo;
    private String subtitulo;
    private int img;

        public Titular(String titulo, String subtitulo){
            super();
            this.titulo = titulo;
            this.subtitulo = subtitulo;
            this.img = img;
        }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
