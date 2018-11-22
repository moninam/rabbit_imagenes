package auxiliar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Format {

    public Base64Format(){

    }

    public String imageToBase64String(RenderedImage image,String format){
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try{
            ImageIO.write(image,format,Base64.getEncoder().wrap(os));
            return os.toString("UTF-8");
        }catch (IOException exc){
            throw new UncheckedIOException(exc);
        }
    }

    public BufferedImage base64StringToImg(String base64String){
        try{
            return ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(base64String)));
        }catch (IOException exc){
            throw new UncheckedIOException(exc);
        }
    }
}
