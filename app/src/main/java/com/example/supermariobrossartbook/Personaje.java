package com.example.supermariobrossartbook;

/**
 * Clase que representa un Personaje.
 *
 * @author
 */
public class Personaje {
    private String nombre;
    private int imagenResId;
    private String descripcion;
    private java.util.List<String> habilidades;

    /**
     * Constructor de Personaje.
     *
     * @param nombre Nombre del personaje.
     * @param imagenResId Recurso de la imagen del personaje.
     * @param descripcion Breve descripción del personaje.
     * @param habilidades Lista de habilidades del personaje.
     */
    public Personaje(String nombre, int imagenResId, String descripcion, java.util.List<String> habilidades) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public java.util.List<String> getHabilidades() {
        return habilidades;
    }
}

