import javax.swing.*;
import java.awt.*;

public class Main {

    
    public static void main(String[] args) {

        /*
         * Swing tiene un hilo Event Dispatch Thread (EDT)
         * Hilo de despacho de eventos
         * todo el código que actualiza la interfaz gráfica debe ejecutarse en ese hilo
         * y se ejecutará cuando esté todo listo
         * @param Runnable
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ventana();
            }
        });
    }

    public static void ventana() {
        // Creamos la ventana
        JFrame ventana = new JFrame("Ventana");
        ventana.setLayout(null); // Layout nulo para posicionar manualmente
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para cerrar la ventana
        ventana.setSize(800, 400); // Tamaño de la ventana

        // Creamos una etiqueta de texto en la ventana
        JLabel etiqueta = new JLabel("Hola Mundo", SwingConstants.CENTER);
        etiqueta.setFont(new Font("consolas", Font.BOLD, 14)); // Fuente de la etiqueta
        etiqueta.setBounds(200, 50, 200, 30); // Posición y tamaño de la etiqueta
        ventana.add(etiqueta); // Ponemos la etiqueta en la ventana

        // Creamos el botón
        JButton boton = new JButton("Soy un botón");
        boton.setBounds(50, 50, 100, 100); // Posición y tamaño del botón
        ventana.add(boton); // Añadimos el botón a la ventana

        // Centramos la ventana en la pantalla
        ventana.setLocationRelativeTo(null);
        // Hacemos visible la ventana
        ventana.setVisible(true);

        System.out.println("La ventana lista");
    }
}
