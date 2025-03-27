/**
 * @author Samuel Ponce Luna
 * @version 1.0
 */

package src.config;

// Importaciones necesarias para manejar dimensiones y diseños de interfaz
import java.awt.Dimension;
import java.awt.LayoutManager;

/**
 * Clase JframeOptionsSetter: Configurador de opciones para JFrames
 * 
 * Características:
 * - Permite configurar propiedades básicas de una ventana
 * - Actúa como un objeto de configuración centralizado
 * - Encapsula título, dimensiones y diseño de layout
 */
public class JframeOptionsSetter {
    // Atributos privados para configuración de la ventana
    private String titulo;           // Título de la ventana
    private Dimension dimensiones;   // Dimensiones de la ventana
    private LayoutManager layout;    // Administrador de diseño para la ventana

    /**
     * Constructor para crear un configurador de opciones de JFrame
     * 
     * @param titulo Título que se mostrará en la ventana
     * @param dimensiones Tamaño de la ventana
     * @param layout Administrador de diseño para los componentes de la ventana
     */
    public JframeOptionsSetter(String titulo, Dimension dimensiones, LayoutManager layout) {
        this.titulo = titulo;
        this.dimensiones = dimensiones;
        this.layout = layout;
    }

    /**
     * Obtiene el título de la ventana
     * 
     * @return Título de la ventana
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene las dimensiones de la ventana
     * 
     * @return Dimensiones de la ventana
     */
    public Dimension getDimensiones() {
        return dimensiones;
    }

    /**
     * Obtiene el administrador de diseño de la ventana
     * 
     * @return LayoutManager para organizar componentes
     */
    public LayoutManager getLayout() {
        return layout;
    }
}