package generivUtilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * this is class contains reusable methods to accesss data from properties file
 * @param key
 * @param value
 * @param filepath
 */

public class propertiesutiility {
	Properties property;
	
public void propertiesInitialization(String filepath) {

	FileInputStream fis =null;
	 try {
		 fis=new FileInputStream(filepath);
		 
	 
}catch (FileNotFoundException e) {
	e.printStackTrace();
}

 property = new Properties();
 try {
	 property.load(fis);
 }catch(IOException e) {
	 e.printStackTrace();
 }
}
public String getDataFromproperties(String key) {
	String data=property.getProperty(key);
	return data;
}
	
	public void setDataproperties(String key,String value,String filepath) {
		property.put(key, value);
		
		FileOutputStream fos =null;
		try {
			 fos = new FileOutputStream(filepath);
		}catch(IOException e) {
			 e.printStackTrace();
		 }
			 try {
				 property.store(fos, "Data updated Sucessful");
			 
		}catch(IOException e) {
			 e.printStackTrace();
		 }
	}
}
		