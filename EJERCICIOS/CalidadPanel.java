package EJERCICIOS;

import javax.swing.*;
import java.awt.FlowLayout;

public class CalidadPanel extends JPanel {

    private JList<String> listaCalidadServicio;

    public CalidadPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createTitledBorder("Calidad de Servicio"));
        
        String[] calidades = {"Económico", "Standard", "VIP"};
        listaCalidadServicio = new JList<>(calidades);
        listaCalidadServicio.setSelectedIndex(1);
        listaCalidadServicio.setVisibleRowCount(1);
        
        add(new JScrollPane(listaCalidadServicio));
    }

    public String getCalidad() {
        String calidad = listaCalidadServicio.getSelectedValue();
        return (calidad == null) ? "No seleccionado" : calidad;
    }

    public void reiniciar() {
        listaCalidadServicio.setSelectedIndex(1);
    }
}