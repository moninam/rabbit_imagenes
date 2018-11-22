package Cliente;

import auxiliar.Base64Format;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeoutException;

public class controlador implements ActionListener{

    private vistaConsulta vc;
    private RPCClient rpc;
    private Base64Format base;

    public controlador(){
        vc = new vistaConsulta();
        vc.Buscar.addActionListener(this);
        vc.getSalir().addActionListener(this);
        base = new Base64Format();

        vc.setVisible(true);

        try {
            rpc = new RPCClient();
        } catch (TimeoutException|IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vc.getBuscar()){
            String comando = vc.palabra.getText();
            String respuesta = rpc.Run(comando);
            BufferedImage envio = base.base64StringToImg(respuesta);
            ImageIcon imagen = new ImageIcon(envio);
            ImageIcon ultimo = setImageSize(imagen);
            vc.getLabelArea().setIcon(ultimo);
        }
        if (e.getSource() == vc.getSalir()){
            vc.dispose();
            System.exit(1);
        }

    }

    public ImageIcon setImageSize(ImageIcon image){

        int width = image.getIconWidth()/4;
        int height = image.getIconHeight()/4;
        Image img = image.getImage();
        Image scaled = img.getScaledInstance(width,height,Image.SCALE_SMOOTH);

        return new ImageIcon(scaled);
    }
}
