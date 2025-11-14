package ACTIVIDAD;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaGridLayout extends JFrame {

    public VentanaGridLayout() {
        super("GridLayout Conteo de Clics");

        setLayout(new GridLayout(3, 2, 10, 10));

        ManejadorClicBotones manejador = new ManejadorClicBotones();

        for (int i = 0; i < 6; i++) {
            JButton boton = new JButton(String.valueOf(i + 1));
            boton.setFont(new Font("Serif", Font.BOLD, 100));
            boton.setPreferredSize(new Dimension(200, 150));

            boton.addMouseListener(manejador);

            add(boton);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ManejadorClicBotones extends MouseAdapter {
        
        @Override
        public void mouseClicked(MouseEvent evento) {
            int clickCount = evento.getClickCount();
            
            JButton botonClickeado = (JButton) evento.getSource();
            String numeroBoton = botonClickeado.getText();

            String verbo = (clickCount == 1) ? "vez" : "veces";
            
            String detalles = String.format("Se hizo clic %d %s en el botón número %s",
                                            clickCount,
                                            verbo,
                                            numeroBoton);
            
            JOptionPane.showMessageDialog(null,
                                      detalles, 
                                      "Clics y botones del raton",
                                      JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaGridLayout());
    }
}