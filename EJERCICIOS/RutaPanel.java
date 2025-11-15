package EJERCICIOS;

import javax.swing.*;
import java.awt.FlowLayout;

public class RutaPanel extends JPanel {

    private JComboBox<String> comboOrigen, comboDestino;

    public RutaPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createTitledBorder("Ruta del Viaje"));
        
        String[] ciudades = {"Arequipa", "Lima", "Cusco", "Puno", "Tacna"};
        add(new JLabel("Origen:"));
        comboOrigen = new JComboBox<>(ciudades);
        add(comboOrigen);
        
        add(new JLabel("Destino:"));
        comboDestino = new JComboBox<>(ciudades);
        comboDestino.setSelectedIndex(1);
        add(comboDestino);
    }

    public String getOrigen() { return (String) comboOrigen.getSelectedItem(); }
    public String getDestino() { return (String) comboDestino.getSelectedItem(); }

    public void reiniciar() {
        comboOrigen.setSelectedIndex(0);
        comboDestino.setSelectedIndex(1);
    }
}