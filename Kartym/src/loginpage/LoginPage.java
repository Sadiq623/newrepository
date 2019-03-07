package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\software testing\\chrome driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.kartym.com/home");
		
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div[3]/div/div[2]/a")).click();
		
		
		

	}

}
