package src.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.config.JframeOptionsSetter;

public class Bienvenida extends JFrame {

    public Bienvenida(JframeOptionsSetter config) {
        InitComponents(config);
    }

    public void InitComponents(JframeOptionsSetter config) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("<html><div style='text-align: center; width: 300px;'>"
                + "Hola! Este proyecto ha sido realizado por <b>Samuel Ponce Luna</b>,<br>"
                + "Alumno de 1DAWT."
                + "</div></html>", SwingConstants.CENTER);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton btnSiguiente = new JButton("Abrir");
        JButton btnCerrar = new JButton("Cerrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());

        btnSiguiente.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new Formulario().setVisible(true));
        });

        panel.add(label, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        this.add(panel);
        this.setTitle(config.getTitulo());
        this.setSize(config.getDimensiones());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
