package EJERCICIOS;

import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class DatosPanel extends JPanel {
    
    private JTextField txtNombres, txtApellidos, txtDNI;

    private JFormattedTextField txtFechaViaje;

    public DatosPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createTitledBorder("Datos del Pasajero"));
        
        add(new JLabel("Nombres:"));
        txtNombres = new JTextField(10);
        add(txtNombres);
        
        add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField(10);
        add(txtApellidos);
        
        add(new JLabel("DNI:"));
        txtDNI = new JTextField(8);
        add(txtDNI);
        
        add(new JLabel("Fecha (dd/mm/aa):"));
        
        try {
            MaskFormatter mascaraFecha = new MaskFormatter("##/##/####");
            mascaraFecha.setPlaceholderCharacter('_');
            
            txtFechaViaje = new JFormattedTextField(mascaraFecha);
            txtFechaViaje.setColumns(8); 
            
        } catch (ParseException e) {
            e.printStackTrace();
            txtFechaViaje = new JFormattedTextField();
            txtFechaViaje.setColumns(8);
        }
        add(txtFechaViaje);

    }

    public String getNombres() { return txtNombres.getText(); }
    public String getApellidos() { return txtApellidos.getText(); }
    public String getDNI() { return txtDNI.getText(); }
    public String getFechaViaje() { return txtFechaViaje.getText(); }

    public void reiniciar() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDNI.setText("");
        txtFechaViaje.setValue(null);
    }
}