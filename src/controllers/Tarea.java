/**
 * @author Samuel Ponce Luna
 * @version 1.0
 */

package src.controllers;

import java.io.Serializable;

/**
 * Clase Tarea: Representa una tarea en el gestor de tareas
 * 
 * Características:
 * - Implementa Serializable para poder guardar/cargar objetos
 * - Almacena información detallada de una tarea
 */
public class Tarea implements Serializable {
    // Número de versión para serialización
    // Permite la compatibilidad al serializar/deserializar objetos
    private static final long serialVersionUID = 1L;

    // Atributos de la tarea
    private String nombre;           // Nombre de la tarea
    private String horaMaxima;       // Hora límite para la tarea
    private String fechaMaxima;      // Fecha límite para la tarea
    private String descripcion;      // Descripción detallada de la tarea
    private boolean realizada;       // Estado de completación de la tarea

    /**
     * Constructor de la clase Tarea
     * 
     * @param nombre Nombre de la tarea
     * @param horaMaxima Hora límite de la tarea
     * @param fechaMaxima Fecha límite de la tarea
     * @param descripcion Descripción detallada de la tarea
     * @param realizada Estado de completación de la tarea
     */
    public Tarea(String nombre, String horaMaxima, String fechaMaxima, String descripcion, boolean realizada) {
        this.nombre = nombre;
        this.horaMaxima = horaMaxima;
        this.fechaMaxima = fechaMaxima;
        this.descripcion = descripcion;
        this.realizada = realizada;
    }

    // Métodos Getter y Setter para cada atributo
    // Permiten acceder y modificar los atributos de manera controlada

    /**
     * Obtiene el nombre de la tarea
     * @return Nombre de la tarea
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la tarea
     * @param nombre Nuevo nombre para la tarea
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la hora máxima de la tarea
     * @return Hora máxima de la tarea
     */
    public String getHoraMaxima() {
        return horaMaxima;
    }

    /**
     * Establece la hora máxima de la tarea
     * @param horaMaxima Nueva hora máxima para la tarea
     */
    public void setHoraMaxima(String horaMaxima) {
        this.horaMaxima = horaMaxima;
    }

    /**
     * Obtiene la fecha máxima de la tarea
     * @return Fecha máxima de la tarea
     */
    public String getFechaMaxima() {
        return fechaMaxima;
    }

    /**
     * Establece la fecha máxima de la tarea
     * @param fechaMaxima Nueva fecha máxima para la tarea
     */
    public void setFechaMaxima(String fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    /**
     * Obtiene la descripción de la tarea
     * @return Descripción de la tarea
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la tarea
     * @param descripcion Nueva descripción para la tarea
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Verifica si la tarea está realizada
     * @return true si la tarea está completada, false en caso contrario
     */
    public boolean isRealizada() {
        return realizada;
    }

    /**
     * Establece el estado de completación de la tarea
     * @param realizada Nuevo estado de la tarea
     */
    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    /**
     * Representación en cadena de la tarea
     * Usado para mostrar información básica en listas o componentes
     * 
     * @return Cadena con nombre, fecha y estado de la tarea
     */
    @Override
    public String toString() {
        return nombre + " | " + fechaMaxima + " | " + horaMaxima + " | " +  (realizada ? "Realizada" : "Sin Realizar");
    }
}