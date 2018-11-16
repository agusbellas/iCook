package com.cifprodolfoucha.icook.clases;

import java.util.ArrayList;
import java.util.Objects;

public class Receta {

    private String id;
    private int imagen;
    private String nombre;
    private String tipo;
    private String tiempo;
    private ArrayList<String> ingredientes;
    private String preparacion;
    private int valoracion;
    private boolean favorito;

    public Receta(String id, int imagen, String nombre, String tipo, String tiempo, ArrayList<String> ingredientes, String preparacion) {

        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tiempo = tiempo;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.valoracion = 0;
        this.favorito = false;
    }

    public Receta() {
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receta receta = (Receta) o;
        return Objects.equals(id, receta.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
