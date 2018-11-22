package Servidor;

import auxiliar.Base64Format;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorArchivos {

    private static String path ="./imagenes/";
    //private static String path = "src//imagenes//";
    private static String ext = "jpg";


    private HashMap<String,String> mapa = new HashMap<>();

    public void inicializarMapa(String Ruta) {
        String sCadena="";
        try {
            File archivo = new File(Ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(fr);
            while ((sCadena = lector.readLine()) != null) {
                String[] datos = sCadena.split(",");
                System.out.println(datos[0]+datos[1]);
                mapa.put(datos[0],datos[1]);
            }
            lector.close();
        }
        catch (IOException e){
            System.out.println("lectura incorrecta");
        }
    }

    public String consultar(String key){
        Base64Format base = new Base64Format();
        if(mapa.containsKey(key)){
            try{
                String ruta = path + mapa.get(key);
                //String datos = leerArchivo(ruta);
                File img = new File(ruta);
                BufferedImage imagen = ImageIO.read(img);
                String datos = base.imageToBase64String(imagen,ext);
                return datos;
            }catch (IOException exc){
                System.out.println("No se encontro la imagen");
                throw new UncheckedIOException(exc);
            }

        }
        return "Error: archivo no encontrado";
    }



    public String leerArchivo(String Ruta) {
        String datos = "";
        String sCadena;
        try {
            File archivo = new File(Ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(fr);
            while ((sCadena = lector.readLine()) != null) {
                datos += sCadena + System.lineSeparator();
            }
            lector.close();
        }
        catch (IOException e){
        }
        return datos;
    }


}
