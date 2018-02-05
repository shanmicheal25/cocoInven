package com.inven.coco.common.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * @author shankar
 *
 */
public class ImageUtil {

	private static final int IMG_WIDTH = 200;
	private static final int IMG_HEIGHT = 200;

	public static void main(String[] args) {

		try {

			BufferedImage originalImage = ImageIO.read(new File("D:\\image\\37eaa59e-9bec-4e78-b3d0-3b054d55ae14.jpg"));
			System.out.println("Width of image  : " + originalImage.getWidth());
			System.out.println("Height of image : " + originalImage.getHeight());
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_4BYTE_ABGR_PRE : originalImage.getType();

			

//			BufferedImage resizeImageJpg = resizeImage(originalImage, type, width, height);
//			ImageIO.write(resizeImageJpg, "jpg", new File("D:\\image\\mkyong_jpg.jpg"));

			// BufferedImage resizeImagePng = resizeImage(originalImage, type,
			// width, width);
			// ImageIO.write(resizeImagePng, "png", new
			// File("D:\\image\\mkyong_png.jpg"));

			// BufferedImage resizeImageHintJpg =
			// resizeImageWithHint(originalImage, type);
			// ImageIO.write(resizeImageHintJpg, "jpg", new
			// File("D:\\image\\mkyong_hint_jpg.jpg"));
			//
			// BufferedImage resizeImageHintPng =
			// resizeImageWithHint(originalImage, type);
			// ImageIO.write(resizeImageHintPng, "png", new
			// File("D:\\image\\mkyong_hint_png.jpg"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int type, int widthOrig, int heightOrig, int keySize) {
		
		int width = 0;
		int height = 0;
		int ratio = 0;
		
		if (widthOrig > heightOrig) {
			if (keySize < widthOrig) {
				ratio = widthOrig / keySize;
				height = heightOrig / ratio;
				width = keySize;
			} else {
				ratio = keySize / widthOrig;
				height = heightOrig/ ratio;
				width = keySize;

			}
		} else if(widthOrig < originalImage.getHeight()){
			if (keySize < originalImage.getHeight()) {
				ratio = heightOrig/ keySize;
				width = widthOrig / ratio;
				height = keySize;
			} else {
				ratio = keySize / originalImage.getHeight();
				width = widthOrig / ratio;
				height = keySize;

			}
		}else{
			width = keySize;
			height = keySize;
		}
		
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		return resizedImage;
	}

	public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) {

		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
}