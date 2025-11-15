package EJERCICIOS;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class BotonesPanel extends JPanel {

    private JButton btnResumen;
    private JButton btnReiniciar;

    public BotonesPanel(ActionListener listener) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        btnResumen = new JButton("Mostrar Resumen");
        btnReiniciar = new JButton("Reiniciar");
        
        btnResumen.addActionListener(listener);
        btnReiniciar.addActionListener(listener);
        
        add(btnResumen);
        add(btnReiniciar);
    }

    public JButton getBtnResumen() {
        return btnResumen;
    }

    public JButton getBtnReiniciar() {
        return btnReiniciar;
    }
}