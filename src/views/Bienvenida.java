
/**
 * @author Samuel Ponce Luna
 * @version 1.0
 */

package src.views;

// Importaciones de librerías de Swing y AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.config.JframeOptionsSetter;

/**
 * Clase Bienvenida: Ventana inicial de la aplicación
 * 
 * Características:
 * - Muestra una pantalla de bienvenida con información del autor
 * - Permite abrir la ventana principal o cerrar la aplicación
 */
public class Bienvenida extends JFrame {

    /**
     * Constructor de la clase Bienvenida
     * 
     * @param config Objeto que configura las opciones del JFrame
     */

    public Bienvenida(JframeOptionsSetter config) {
        // Inicializa los componentes de la ventana
        InitComponents(config);
    }

    /**
     * Método para inicializar los componentes de la ventana
     * 
     * @param config Objeto que configura las opciones del JFrame
     */
    public void InitComponents(JframeOptionsSetter config) {
        // Crea un panel principal con diseño de BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crea una etiqueta con HTML para dar formato al texto de bienvenida
        JLabel label = new JLabel("<html><div style='text-align: center; width: 300px;'>"
                + "Hola! Este proyecto ha sido realizado por <b>Samuel Ponce Luna</b>,<br>"
                + "Alumno de 1DAWT."
                + "</div></html>", SwingConstants.CENTER);
        
        // Configura la alineación y fuente de la etiqueta
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        // Crea botones para abrir la aplicación y cerrar
        JButton btnSiguiente = new JButton("Abrir");
        JButton btnCerrar = new JButton("Cerrar");

        // Crea un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnCerrar);

        // Configura la acción del botón de cerrar
        btnCerrar.addActionListener(e -> dispose());

        // Configura la acción del botón de abrir
        // Al presionarlo, cierra la ventana de bienvenida y abre el formulario principal
        btnSiguiente.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new Formulario().setVisible(true));
        });

        // Añade la etiqueta y el panel de botones al panel principal
        panel.add(label, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Añade el panel al JFrame
        this.add(panel);

        // Configura las propiedades del JFrame usando el objeto config
        this.setTitle(config.getTitulo());
        this.setSize(config.getDimensiones());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}