import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pirate.servlet.HelloServlet;

public class App extends HelloServlet{
	public static void main(String[] args) throws InterruptedException{
		// Tell java that you want to use the chrome driver for selenium
		System.setProperty("webdriver.chrome.driver", "/Users/WilliamOna/Downloads/chromedriver.exe");
		
		//Create new instance of ChromeDriver (note that your other options are: 
		//geckodriver for Firefox, edgedriver for Edge, Safari)
		WebDriver driver = new ChromeDriver();
		
		//use the driver to open some website
		driver.get("http://localhost:8080/PirateServer/");
		
		//select the element for "View Pirates" button
		WebElement viewPiratesButton = driver.findElement(By.xpath("//*[@id=\"showcase-content\"]/button/a"));
		
		//click on the button
		viewPiratesButton.click();
		
		//assert that we successfully navigate to the correct page
		String url = driver.getCurrentUrl();
		System.out.println(url);
		System.out.println("Testing to make sure that the url is correct "
				+ "(http://localhost:8080/PirateServer/pirate-list)");
		System.out.println(url.equals("http://localhost:8080/PirateServer/pirate-list")?"test pass":"test fails");
		
		try {
			WebElement pirateTableBody = driver.findElement(By.id("pirate-table-dat"));			
			if(pirateTableBody!=null) {
				System.out.println("Test pass");
			}
		}catch(Exception e) {
			System.out.println("Can't find the element... test failed");
			driver.quit();
		}
		
		//close the browser
		driver.quit();
	}
	



	
	
	
}
