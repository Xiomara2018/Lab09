package ACTIVIDAD;
import java.awt.BorderLayout;
import javax.swing.*;
import java.net.URL; 

public class VentanaBorderLayout extends JFrame {

    private JLabel norte;
    private JLabel sur;
    private JLabel este;
    private JLabel oeste;
    private JLabel centro;
    private JButton sur1;

    public VentanaBorderLayout(){
        super("Una ventana con BorderLayout :)"); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 1200);

        sur1 = new JButton("Boton sur :V");
        norte = new JLabel();
        sur = new JLabel(); 
        este = new JLabel("Etiqueta en el este");
        oeste = new JLabel("Etiqueta en el oeste");
        centro = new JLabel();

        URL imgUrl = getClass().getResource("NOSE.jpg");
        ImageIcon nc = null;

        if (imgUrl != null) {
            nc = new ImageIcon(imgUrl);
        } else {
            System.err.println("Error: No se pudo encontrar el archivo 'NOSE.jpg'");
            centro.setText("Error al cargar GIF"); 
        }
        centro.setIcon(nc);
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        centro.setVerticalAlignment(SwingConstants.CENTER);
        norte.setText("Etiqueta arribaaaa");
        sur.setText("Etiqueta abajoooooo");
        este.setText("Etiqueta esteee");
        oeste.setText("Etiqueta oesteee");

        add(norte, BorderLayout.NORTH);
        add(sur1, BorderLayout.SOUTH);
        add(este, BorderLayout.EAST);
        add(oeste, BorderLayout.WEST);
        add(centro, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaBorderLayout(); 
        });
    }
}
