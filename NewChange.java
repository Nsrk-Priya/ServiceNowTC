package ServiceNow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewChange {

	public static void main(String[] args) throws InterruptedException 
	{
		
		String attribute;
     
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://dev87386.service-now.com/");
		driver.manage().window().maximize();
	   // Thread.sleep(2000);
	    driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("uaNJW8jHq9uW");
		driver.findElement(By.id("sysverb_login")).click();
	    driver.findElement(By.xpath("//input[@id=\"filter\"]")).sendKeys("change",Keys.ENTER);
	    driver.findElement(By.xpath("(//div[text()=\"Create New\"])[3]")).click();
	    WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']")); ////iframe[@id='gsft_main']
        driver.switchTo().frame(frame);
        Thread.sleep(2000);
       driver.findElement(By.xpath("(//div[@role='tab'])[4]")).click();
       driver.findElement(By.xpath("(//div[@class='change-model-board-lists']//li)[2]/div")).click();
        
         attribute = driver.findElement(By.id("change_request.number")).getAttribute("value");
        System.out.println(attribute);
        WebElement priority = driver.findElement(By.id("change_request.priority"));
        Select option= new Select(priority);
        option.selectByIndex(2);
        
        WebElement state = driver.findElement(By.id("change_request.state"));
        Select option1= new Select(state);
        option1.selectByValue("-5");
        driver.findElement(By.id("change_request.short_description")).sendKeys("TC001 new change");
        driver.findElement(By.id("change_request.description")).sendKeys("Change management ,create new change");
        
       
        driver.findElement(By.id("sysverb_insert_bottom")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
        driver.switchTo().frame(frame);
        
        driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(attribute,Keys.ENTER);
       Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
       
       

	}

}
