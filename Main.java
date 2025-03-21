import java.awt.BorderLayout;
import java.awt.Dimension;


import src.config.JframeOptionsSetter;
import src.views.Bienvenida;


public class Main {
    public static void main(String[] args) {
       
        JframeOptionsSetter config = new JframeOptionsSetter(
            "Gestor de tareas",
            new Dimension(500, 500),
            new BorderLayout()
        );

        
        new Bienvenida(config);
       
    }
}
