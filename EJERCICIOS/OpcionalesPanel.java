package EJERCICIOS;

import javax.swing.*;
import java.awt.FlowLayout;

public class OpcionalesPanel extends JPanel {

    private JCheckBox chkAudifonos, chkManta, chkRevistas;

    public OpcionalesPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createTitledBorder("Servicios Opcionales"));

        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        
        add(chkAudifonos);
        add(chkManta);
        add(chkRevistas);
    }

    public String getOpcionales() {
        String opcionales = "";
        if (chkAudifonos.isSelected()) opcionales += "Audífonos | ";
        if (chkManta.isSelected()) opcionales += "Manta | ";
        if (chkRevistas.isSelected()) opcionales += "Revistas";
        return (opcionales.isEmpty()) ? "Ninguno" : opcionales;
    }

    public void reiniciar() {
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
    }
}