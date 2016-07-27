/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageconverter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author New
 */
public class ImageConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            FromPNGtoJPG(args[0]);
        } else {
            System.out.println("Please, specify working dir");
        }
    }

    public static void FromPNGtoJPG(String dir) {
        BufferedImage bufferedImage;

        try {
            File folder = new File(dir); //"D:/Projects/RRP/FromPNGtoJPG"
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.getName().contains(".png")) {

                    bufferedImage = ImageIO.read(file);

                    BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
                            bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
                    newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
                    String oldName = file.getName();
                    String newName = oldName.substring(0, oldName.length() - 4);
                    ImageIO.write(newBufferedImage, "jpg", new File(dir + "/" + newName + ".jpg"));
                }
            }

            System.out.println("Done");

        } catch (IOException e) {
        }
    }
}
