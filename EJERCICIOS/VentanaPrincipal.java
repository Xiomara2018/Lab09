package EJERCICIOS;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private DatosPanel datosPanel;
    private RutaPanel rutaPanel;
    private PisoPanel pisoPanel;
    private CalidadPanel calidadPanel;
    private OpcionalesPanel opcionalesPanel;
    private BotonesPanel botonesPanel;

    public VentanaPrincipal() {
        super("Venta de Pasajes de Bus");
        
        setLayout(new GridLayout(6, 1, 5, 5));

        datosPanel = new DatosPanel();
        rutaPanel = new RutaPanel();
        pisoPanel = new PisoPanel();
        calidadPanel = new CalidadPanel();
        opcionalesPanel = new OpcionalesPanel();
        botonesPanel = new BotonesPanel(this);

        add(datosPanel);
        add(rutaPanel);
        add(pisoPanel);
        add(calidadPanel);
        add(opcionalesPanel);
        add(botonesPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonesPanel.getBtnResumen()) {
            mostrarResumenDialogo();
        } else if (e.getSource() == botonesPanel.getBtnReiniciar()) {
            datosPanel.reiniciar();
            rutaPanel.reiniciar();
            pisoPanel.reiniciar();
            calidadPanel.reiniciar();
            opcionalesPanel.reiniciar();
        }
    }

    private void mostrarResumenDialogo() {
        String nombres = datosPanel.getNombres();
        String apellidos = datosPanel.getApellidos();
        String dni = datosPanel.getDNI();
        String fecha = datosPanel.getFechaViaje();
        String origen = rutaPanel.getOrigen();
        String destino = rutaPanel.getDestino();
        String piso = pisoPanel.getPiso();
        String calidad = calidadPanel.getCalidad();
        String opcionales = opcionalesPanel.getOpcionales();

        StringBuilder resumen = new StringBuilder();
        resumen.append("--- RESUMEN DEL PASAJE ---");
        resumen.append("\nPasajero: ").append(nombres).append(" ").append(apellidos);
        resumen.append("\nDNI: ").append(dni);
        resumen.append("\nFecha: ").append(fecha);
        resumen.append("\n\nRuta: ").append(origen).append(" -> ").append(destino);
        resumen.append("\nAsiento: ").append(piso);
        resumen.append("\nCalidad: ").append(calidad);
        resumen.append("\nOpcionales: ").append(opcionales);

        JOptionPane.showMessageDialog(this,
                                  resumen.toString(),
                                  "Resumen de Compra",
                                  JOptionPane.INFORMATION_MESSAGE);
    }
}