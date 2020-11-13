package io.github.dalayach;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
                  
/** Main class where we will actually calculate the fastest path. */
public class Main
{

	/** Constructor. */
   public Main()
   {
   
   	// this is where we run things. Let's try a single item for now.
   
   	// we will definitely need a unit test as well (to ensure that things are ACTUALLY as optimal as they should be).
      
      
      /** Putting an image for the dialog prompt -- BE SURE NOT TO USE AN IMAGE CONTAINING SPOILERS. */
      String dialogImageName = "KabbuPosingArmsCrossed.png";
      /** Putting an icon for the window and the toolbar -- BE SURE NOT TO USE AN IMAGE CONTAINING SPOILERS. */
      String windowImageName = "KabbuHead.png";
      
      BufferedImage dialogImage = this.fetchImage(new File(""), dialogImageName);
      BufferedImage windowImage = this.fetchImage(new File(""), windowImageName);
      
      if (dialogImage != null)
      {
      
         ImageIcon dialogImageIcon =
            new ImageIcon(dialogImage.getScaledInstance(dialogImage.getWidth() / 10, dialogImage.getHeight() / 10, Image.SCALE_SMOOTH));
      
         ImageIcon windowImageIcon =
            new ImageIcon(windowImage.getScaledInstance(windowImage.getWidth(), windowImage.getHeight(), Image.SCALE_SMOOTH));
      
         GUIIntro guiIntro = new GUIIntro(dialogImageIcon, windowImageIcon);
      
      }
      
   }
   
   public BufferedImage fetchImage(File temp, String imageFileName)
   {
   
      File f = new File(temp.getAbsolutePath());
   
      while (!f.getName().contains("bug-fables-recipe-path-finder"))
      {
      
         f = f.getParentFile();
      
      }
      
      String sep = java.nio.file.FileSystems.getDefault().getSeparator();
      
      String newPath = f.getAbsolutePath() + sep + "src" + sep + "main" + sep + "res" + sep + imageFileName;
   
      try
      {
      
         return ImageIO.read(new File(newPath));
      
      } catch(IOException ioe)
      {
      
         return null;
      
      }      
   }
	
	/**
	 * 
	 * Main method.
	 *
	 * @param args possible String arguments.
	 *
	 */
   public static void main(String[] args)
   {
   
      Main main = new Main();
   
   }

}
