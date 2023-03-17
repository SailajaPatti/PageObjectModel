package sailajaLearning.TestComponent;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import sailajaLearning.PageObject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	
	public LandingPage obj;
	
	public WebDriver InstantiateBrowser() throws IOException {
		
		
		//so we need to set up a global property file 
		//to do that in there is properties class so it read the properties and execute those at run time.
		//so for this u need to create a file in main/java folder for that create a subfolder under that create a file with .properties extension
		//then that file parse and extract the global properties data
		//create object of properties file to get the load method to load the file of properties
		//but load mwthod will accept thhe file as InputStream so to convert it into inputStream create a
		//a object of the InputSream and covert the file path into inputstream and provide in load method
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\1685453\\eclipse-workspace\\recheck\\src\\main\\java\\sailajaLearning\\Properties\\Globaldata.properties");
		//file path is very long rt so u dont need to hardcode from local u can dynamically generate the path of the file
		//so for this we have System.getproprty() it will give the project location so if u give this project to some other person so for then their project path will extract
		
		prop.load(fis);
		//to extract the properties from the file
		String Browser=prop.getProperty("browser");
		
		if(Browser.equalsIgnoreCase("chrome")) {
		
        
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1685453\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
		
	}
		else if(Browser.equalsIgnoreCase("firefox")) {
			//code for firefox browser
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			//code for edge browser
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//so here driver has no scope so the declare a global variable and remove WebDriver while creating obj of webdriver
		return driver;
	}
	   
		public  LandingPage launchApplication() throws IOException {
			driver=InstantiateBrowser();
			 obj=new LandingPage(driver);
			obj.goTo();
			return obj;
		}
	    
	    public void Final() {
	    	driver.close();
	    }
}
