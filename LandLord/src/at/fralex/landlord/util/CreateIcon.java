package at.fralex.landlord.util;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateIcon {

	public static void createIcon(String text, File file, String fontname, int width, int height, String outputName) {

		BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = image.createGraphics();
		int fontsize = 1;
		int textwidth = 0;
		int textheight = 0;
		Font font;
		while (true) {

			AffineTransform affinetransform = new AffineTransform();
			FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
			font = new Font(fontname, Font.PLAIN, fontsize);
			textwidth = (int) (font.getStringBounds(text, frc).getWidth());
			textheight = (int) (font.getStringBounds(text, frc).getHeight());

			if (textwidth > width - 10 || textheight > height - 10) {
				break;
			} else {
				fontsize++;
			}

		}

		g.drawImage(originalImage, 0, 0, null);
		g.setFont(font);
		g.drawString(text, width / 2 - textwidth / 2, height / 2 + textheight / 3);
		g.dispose();

		File f = new File("res/icon/" + outputName + ".png");
		try {
			ImageIO.write(image, "png", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
