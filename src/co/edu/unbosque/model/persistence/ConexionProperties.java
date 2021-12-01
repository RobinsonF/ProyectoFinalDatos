package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConexionProperties {
	
	private final String RUTA_ARCHIVO_CONFIG = "Data/InfoBD.properties";
	private Properties prop;
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	
	public ConexionProperties() {
		prop = new Properties();
		file = new File(RUTA_ARCHIVO_CONFIG);
	}
	
	public String[] leerInfoBD() {
		String[] datos = new String[3];
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				prop.load(fis);
				datos[0] = prop.getProperty("login");
				datos[1] = prop.getProperty("password");
				datos[2] = prop.getProperty("url");
				fis.close();
			} catch (IOException e) {
				return null;
			}
		}
		return datos;
	}
}
