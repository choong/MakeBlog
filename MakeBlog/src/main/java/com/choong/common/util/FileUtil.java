package com.choong.common.util;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class FileUtil {
	
	private Log log = LogFactory.getLog(FileUtil.class);
	
	public boolean existFile(String path, String fileName){
		
		if (StringUtils.isEmpty(path) || StringUtils.isEmpty(fileName)) return false;
		
		String fullPath;
		
		if (path.endsWith("/"))
			fullPath = path + fileName;
		else
			fullPath = path + "/" + fileName;
		
		return existFile(fullPath);
	}
	
	
	public boolean existFile(String fullPath){
		
		if (StringUtils.isEmpty(fullPath)) return false;
		
		try {
			
			File f = new File(fullPath);
			return f.exists();
		} catch(Exception e){
			log.error(e);
			return false;
		}
		
	}
}
