package at.fralex.landlord.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateIcon {

	public static void createIcon(String text, File file,String fontname, int width, int height,String outputName) {
		
		BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = image.createGraphics();
		int fontsize = 0;
		if(height < width) {
			fontsize = height;
		}else {
			fontsize = width/2;
		}
		
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
		Font font = new Font(fontname, Font.PLAIN, fontsize);
		int textwidth = (int)(font.getStringBounds(text, frc).getWidth());
		int textheight = (int)(font.getStringBounds(text, frc).getHeight());
		
		
		g.drawImage(originalImage, 0, 0, null);
		g.setFont(font);
		g.drawString(text, width/2-textwidth/2, height/2 + (textheight/32 * 10));
		g.dispose();

		File f = new File("res/icon/"+outputName+".png");
		try {
			ImageIO.write(image, "png", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
