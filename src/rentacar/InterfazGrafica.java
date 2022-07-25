/*
 */

package rentacar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Karina Madrigal
 */
public class InterfazGrafica extends JFrame{

    public InterfazGrafica() {
        this.setSize(750, 750); //se establece tamano
        setTitle("Rent a Car");
        setLocationRelativeTo(null);
        initComponents();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); //cierra, termina la ejecucion
    }
    
    private void initComponents(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
        panel.setLayout(null);
        
        //Icono
        ImageIcon icono = new ImageIcon("icono.png");
        JLabel iconImage = new JLabel();
        iconImage.setBounds(10, 10, 50, 50);
        iconImage.setIcon(new ImageIcon(icono.getImage().
                getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        panel.add(iconImage);
        
        JLabel jlregistro = new JLabel();
        jlregistro.setText("Registro");
        jlregistro.setBounds(10, 10, 100, 150);
        jlregistro.setForeground(Color.black);
        jlregistro.setFont(new Font("arial", Font.PLAIN, 17));
        panel.add(jlregistro);
        
        
    }
    
    

}
