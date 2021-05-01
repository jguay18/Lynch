package com.example.lynch.models;

public class almuerzos {
    private String comida;
    private String descripcion;
    private String precio;
    private int imagen;

    public almuerzos(){
        this.comida = comida;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;

    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
