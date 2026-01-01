package ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import obj.Utility.ConfigFileReader;

public class ObjTestDemo {

	@Test
	public void ConfigRead() throws Exception{
		ConfigFileReader config =new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
		ChromeDriver driver =new ChromeDriver();
		driver.get(config.AppURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		File src =new File(config.FileLocation());
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data form Excel is ...." + data0);
		
		String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data form Excel is ...." + data1);
		
		driver.findElement(By.id(config.Uname())).sendKeys(data0);
		driver.findElement(By.id(config.Pword())).sendKeys(data1);
		Thread.sleep(5000);
		driver.findElement(By.xpath(config.SignInbtn())).click();
	}

}
