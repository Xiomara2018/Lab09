package EJERCICIOS;

import javax.swing.*;
import java.awt.FlowLayout;

public class PisoPanel extends JPanel {
    
    private JRadioButton radioPiso1, radioPiso2;
    private ButtonGroup grupoPiso;

    public PisoPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createTitledBorder("Selección de Piso"));

        radioPiso1 = new JRadioButton("1er Piso");
        radioPiso1.setSelected(true);
        radioPiso2 = new JRadioButton("2do Piso");
        
        grupoPiso = new ButtonGroup();
        grupoPiso.add(radioPiso1);
        grupoPiso.add(radioPiso2);
        
        add(radioPiso1);
        add(radioPiso2);
    }

    public String getPiso() {
        return radioPiso1.isSelected() ? "1er Piso" : "2do Piso";
    }

    public void reiniciar() {
        radioPiso1.setSelected(true);
    }
}