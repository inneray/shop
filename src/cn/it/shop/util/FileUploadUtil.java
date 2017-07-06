package cn.it.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;


import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.it.shop.model.FileImage;
@SuppressWarnings("unchecked")
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	@Value("#{prop.basePath+prop.filePath}")
	private String filePath ="";
	
	@Value("#{prop.basePath+prop.bankPath}")
	private String bankPath = "";
	public String[] getBankImage(){
		return new File(bankPath).list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".gif");
			}
		});
	}
	
	//String ext = FilenameUtils.getExtension(getFileImage().getFilename());
	//FileUtil.copyFile(getFileImage().getFile(), new File("C:/"+UUID.randomUUID().toString()+".jpg"));
	//System.out.println("C:/"+UUID.randomUUID().toString()+"."+ext);
	private String getFilenameExt(String filename){
		return FilenameUtils.getExtension(filename);
	}
	
	
	
	private String newFileName(String filename){
		return UUID.randomUUID()+"."+getFilenameExt(filename);
	}
	
	/* (non-Javadoc)
	 * @see cn.it.shop.util.FileUpload#uploadFile(cn.it.shop.model.FileImage)
	 */
	@Override
	public String uploadFile(FileImage fileImage){
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath,pic));
			return pic;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new RuntimeException(e);
		}finally{
			fileImage.getFile().delete();
		}
		return null;
	}
}
