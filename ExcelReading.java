package com.ExcelReadingNew;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExcelReading {

	WebDriver driver;

	String baseUrl = "https://s1.demo.opensourcecms.com/wordpress/wp-login.php?loggedout=true";

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@Test
	public void excelRead() throws IOException {

		File src = new File("./ExcelData.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++) {

			driver.findElement(By.id("user_login")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());

			driver.findElement(By.id("user_pass")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());

			driver.findElement(By.id("wp-submit")).click();

			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileHandler.copy(srcfile, new File("./Screenshots/image.png"));
		}
		wb.close();
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}
