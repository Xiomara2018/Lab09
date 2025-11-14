package ACTIVIDAD;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon; 
import javax.swing.JPanel; 
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaFlowLayout extends JFrame implements ActionListener {

    private JLabel lblImagen;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnCerrar;

    private ArrayList<String> rutasImagenes;
    private int indiceImagenActual = 0;

    public VentanaFlowLayout() {
        super("Gif con FlowLayout");

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        rutasImagenes = new ArrayList<>();

        rutasImagenes = new ArrayList<>();
        rutasImagenes.add( "cat.gif");
        if (rutasImagenes.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos una imagen en la lista.");
        }

        lblImagen = new JLabel();
        mostrarImagenActual();

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5)); 

        btnAnterior = new JButton("<< Anterior");
        btnSiguiente = new JButton("Siguiente >>");
        btnCerrar = new JButton("Cerrar");

        btnAnterior.addActionListener(this);
        btnSiguiente.addActionListener(this);
        btnCerrar.addActionListener(this);

        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnCerrar);
        add(lblImagen); 
        add(panelBotones);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true); 
    }

    private void mostrarImagenActual() {
        if (!rutasImagenes.isEmpty()) {
            String ruta = rutasImagenes.get(indiceImagenActual);
            ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
            lblImagen.setIcon(icon);
            pack(); 
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAnterior) {
            indiceImagenActual--;
            if (indiceImagenActual < 0) {
                indiceImagenActual = rutasImagenes.size() - 1; 
            }
            mostrarImagenActual();
        } else if (e.getSource() == btnSiguiente) {
            indiceImagenActual++;
            if (indiceImagenActual >= rutasImagenes.size()) {
                indiceImagenActual = 0; 
            }
            mostrarImagenActual();
        } else if (e.getSource() == btnCerrar) {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaFlowLayout();
            }
        });
    }
}