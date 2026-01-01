package obj.Utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigFileReader {
	Properties pro;
	
	public ConfigFileReader() {
		try {
			File src =new File("./Properties File/config.property");
			FileInputStream fis=new FileInputStream(src);
			pro =new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is ... " + e.getMessage());
		}
	}
	
	
	public String getChromePath() {
		String path =pro.getProperty("ChromeDriver");
		return path;
	}
	public String getEdgePath() {
		String path =pro.getProperty("EdgeDriver");
		return path;
	}

	public String getFirefoxPath() {
		String path =pro.getProperty("FirefoxDriver");
		return path;
	}
	
	public String AppURL() {
		String path =pro.getProperty("baseUrl");
		return path;
	}
	public String Uname() {
		String path =pro.getProperty("Uname");
		return path;
	}
	public String Pword() {
		String path =pro.getProperty("Pword");
		return path;
	}
	
	public String SignInbtn() {
		String path =pro.getProperty("SignInbtn");
		return path;
	}
	public String FileLocation() {
		String path =pro.getProperty("FileLocation");
		return path;
	}

	

}
