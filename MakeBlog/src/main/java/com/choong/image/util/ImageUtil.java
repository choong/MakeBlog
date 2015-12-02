package com.choong.image.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component
public class ImageUtil {

	private final int DEFAULT_WIDTH_SIZE = 0;
	
	private final int DEFAULT_HEIGHT_SIZE = 0;
	
	private void createThumbnailImage(String imgPath, String fileName){
		if (!checkFileExtension(fileName)) {
			//TODO add logic 
		}
		
		try {
            //썸네일 가로사이즈
            int thumbnail_width = 360;
            //썸네일 세로사이즈
            int thumbnail_height = 260;
            //원본이미지파일의 경로+파일명
            File origin_file_name = new File("D:"+File.separator+"untitled.png");
            //생성할 썸네일파일의 경로+썸네일파일명
            File thumb_file_name = new File("D:"+File.separator+"thumbnail_image1.png");
 
            BufferedImage buffer_original_image = ImageIO.read(origin_file_name);
            BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = buffer_thumbnail_image.createGraphics();
            graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
            ImageIO.write(buffer_thumbnail_image, "jpg", thumb_file_name);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Check File extension (only .jpg, .png)
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileExtension(String fileName){
		
		String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase(); 
		return fileExtension.equals("jpg") || fileExtension.equals("png");
	}
}
