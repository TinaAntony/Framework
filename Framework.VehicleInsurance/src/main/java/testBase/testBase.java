package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePageObjects;

public class testBase extends objectsRepo {

	public void lauchBrowserAndNavigate()
	{
		String Browser = "Chrome";
		String url = "http://sampleapp.tricentis.com/101/index.php#";
		if (Browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if (Browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@BeforeMethod
	public void setupmethod()
	{
		lauchBrowserAndNavigate();
		homePage = new HomePageObjects();
		
	}
	@AfterMethod
	public void cleanUp()
	{
		driver.quit();
	}
	}
