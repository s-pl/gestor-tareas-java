package src.controllers;

import java.io.Serializable;

public class Tarea implements Serializable {

    // Esto es necesario para la serialización
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String horaMaxima;
    private String fechaMaxima;
    private String descripcion;
    private boolean realizada;

    // Constructor
    public Tarea(String nombre, String horaMaxima, String fechaMaxima, String descripcion, boolean realizada) {
        this.nombre = nombre;
        this.horaMaxima = horaMaxima;
        this.fechaMaxima = fechaMaxima;
        this.descripcion = descripcion;
        this.realizada = realizada;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraMaxima() {
        return horaMaxima;
    }

    public void setHoraMaxima(String horaMaxima) {
        this.horaMaxima = horaMaxima;
    }

    public String getFechaMaxima() {
        return fechaMaxima;
    }

    public void setFechaMaxima(String fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return nombre + " | " + fechaMaxima + " | " + (realizada ? "Realizada" : "Sin Realizar");
    }
}
