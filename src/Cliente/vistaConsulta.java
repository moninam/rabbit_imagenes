package Cliente;

import javax.swing.*;
import java.awt.*;

public class vistaConsulta extends JFrame {
    JLabel labelArea;

    JButton Buscar = new JButton("Buscar");
    JButton Salir = new JButton("Salir");

    public  TextField palabra = new TextField(20);
    public vistaConsulta(){
            super("Buscador");
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        add(palabra);
        add(Buscar);
        labelArea = new JLabel();
        add(labelArea);
        add(Salir);
        setSize(400,300);//pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getBuscar() {
        return Buscar;
    }

    public JButton getSalir(){
        return Salir;
    }
    public JLabel getLabelArea() {
        return labelArea;
    }

}
