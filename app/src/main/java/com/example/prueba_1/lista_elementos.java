package com.example.prueba_1;

public class lista_elementos {
    public String nombre;
    public String contenido;
    public String stock;

    public lista_elementos(String nombre, String contenido, String stock) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.stock = stock;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
