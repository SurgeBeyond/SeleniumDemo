package crossbrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	
	WebDriver driver;

/**
 * This function will run before each Test in testng.xml... Seriously?
 * @param browser
 * @throws Exception
 */
@BeforeClass
@Parameters("browser")
public void setup(String browser) throws Exception{
	//Check if parameter passed from TestNG is 'Chrome'
	if(browser.equalsIgnoreCase("chrome")){
	//Open Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	//Check if parameter passed from TestNG is 'IE'
	else if(browser.equalsIgnoreCase("IE")){
		//set path to chromedriver.exe
		System.setProperty("webdriver.ie.driver","C:\\Users\\Public\\IEDriverServer.exe");
		//Open IE browser
		driver = new InternetExplorerDriver();
	}
	else{
		throw new Exception("Browser is incorrect");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
public void testParameterWithXML(){
	
	try {
		driver.navigate().to("http://google.com");
		
		WebElement inputTextBox = driver.findElement(By.xpath("//input[@name='q']"));
		inputTextBox.sendKeys("Surge Beyond");
	}catch(Exception e) {
		System.out.println(e.getMessage());
		}
}}
