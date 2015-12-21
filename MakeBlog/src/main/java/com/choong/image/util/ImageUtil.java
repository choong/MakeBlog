package com.choong.image.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import com.choong.common.util.DateUtils;
import com.choong.common.vo.ImageMeta;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Descriptor;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDescriptor;
import com.drew.metadata.exif.GpsDirectory;
import com.drew.metadata.file.FileMetadataDirectory;
import com.drew.metadata.jpeg.JpegDirectory;
import com.drew.metadata.png.PngDirectory;

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
	
	
	public ImageMeta getMetaData(File file){
		ImageMeta result = null;
		extractImageMetadata(file);
		return result;
	}
	
	private ImageMeta extractImageMetadata(File file){
		ImageMeta result = new ImageMeta();
		
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			
			FileMetadataDirectory fileDir = metadata.getFirstDirectoryOfType(FileMetadataDirectory.class);
			String fileName = fileDir.getString(FileMetadataDirectory.TAG_FILE_NAME);
			String fileSize = fileDir.getString(FileMetadataDirectory.TAG_FILE_SIZE);
			
			result.setFileName(fileName);
			result.setFileSize(fileSize);
			
			int width = 0;
			int height = 0;
			if(metadata.getFirstDirectoryOfType(JpegDirectory.class) != null){
				JpegDirectory jpegDir = metadata.getFirstDirectoryOfType(JpegDirectory.class);
				height = jpegDir.getImageHeight();
				width = jpegDir.getImageWidth();
			} else {
				PngDirectory pngDir = metadata.getFirstDirectoryOfType(PngDirectory.class);
				height = pngDir.getInt(PngDirectory.TAG_IMAGE_HEIGHT);
				width = pngDir.getInt(PngDirectory.TAG_IMAGE_WIDTH);
			}
			
			result.setHeight(height);
			result.setWidth(width);
			
			ExifIFD0Directory exifD0;
			if ((exifD0 = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class)) != null){
				String makeName = exifD0.getString(ExifIFD0Directory.TAG_MAKE);
				String modelName = exifD0.getString(ExifIFD0Directory.TAG_MODEL);
				result.setMakeName(makeName);
				result.setModelName(modelName);
			}
			
			
			ExifSubIFDDirectory exifSub;
			if ((exifSub = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class)) != null){
				Date orginalDate = exifSub.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL, TimeZone.getDefault());
				String date = DateUtils.dateFommat(orginalDate);
				result.setDate(date);
				
				String iso = exifSub.getString(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT);
				String shutterSpeed = exifSub.getString(ExifSubIFDDirectory.TAG_EXPOSURE_TIME);
				String fNumber = exifSub.getString(ExifSubIFDDirectory.TAG_FNUMBER);
				result.setIso(iso);
				result.setShutterSpeed(shutterSpeed);
				result.setShutterSpeed(shutterSpeed);
				result.setfNumber(fNumber);
			}
			
			GpsDirectory gpsDir =  metadata.getFirstDirectoryOfType(GpsDirectory.class);
			if (gpsDir != null) {
				GpsDescriptor gpsDesc = new GpsDescriptor(gpsDir);
				String latitude = gpsDesc.getGpsLatitudeDescription();
				String longitude = gpsDesc.getGpsLongitudeDescription();
				result.setLatitude(latitude);
				result.setLongitude(longitude);
				
			}
			System.out.println(result);
			
		} catch (ImageProcessingException e) {
			
		} catch (IOException e) {
			
		} catch (MetadataException e) {

		}
		
		
		return result;
	}
	
	private ImageMeta extractFileInfo(Metadata metadata){
		ImageMeta result = new ImageMeta();
		
		FileMetadataDirectory fileDir = metadata.getFirstDirectoryOfType(FileMetadataDirectory.class);
		String fileName = fileDir.getString(FileMetadataDirectory.TAG_FILE_NAME);
		String fileSize = fileDir.getString(FileMetadataDirectory.TAG_FILE_SIZE);
		
		result.setFileName(fileName);
		result.setFileSize(fileSize);
		
		return result;
	}
	
	private ImageMeta extractImageInfo(Metadata metadata) throws MetadataException{
		ImageMeta result = new ImageMeta();
		
		int width = 0;
		int height = 0;
		
		if(metadata.getFirstDirectoryOfType(JpegDirectory.class) != null){
			JpegDirectory jpegDir = metadata.getFirstDirectoryOfType(JpegDirectory.class);
			height = jpegDir.getImageHeight();
			width = jpegDir.getImageWidth();
		} else {
			PngDirectory pngDir = metadata.getFirstDirectoryOfType(PngDirectory.class);
			height = pngDir.getInt(PngDirectory.TAG_IMAGE_HEIGHT);
			width = pngDir.getInt(PngDirectory.TAG_IMAGE_WIDTH);
		}
		
		result.setHeight(height);
		result.setWidth(width);
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		ImageUtil img = new ImageUtil();
		img.getMetaData(new File("D:\\untitled.png"));
		img.getMetaData(new File("D:\\IMG_9978.JPG"));
		System.out.println("111111111111111111111111111111111111");
//		img.getMetaData(new File("D:\\DSC00602.JPG"));
		img.getMetaData(new File("D:\\IMG_3978.JPG"));
	}
}
