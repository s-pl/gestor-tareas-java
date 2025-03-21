package src.config;

import java.awt.Dimension;
import java.awt.LayoutManager;

public class JframeOptionsSetter {
    private String titulo;
    private Dimension dimensiones;
    private LayoutManager layout;

    public JframeOptionsSetter(String titulo, Dimension dimensiones, LayoutManager layout) {
        this.titulo = titulo;
        this.dimensiones = dimensiones;
        this.layout = layout;
    }

    public String getTitulo() {
        return titulo;
    }

    public Dimension getDimensiones() {
        return dimensiones;
    }

    public LayoutManager getLayout() {
        return layout;
    }
}
