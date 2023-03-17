package sailajaLearning.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sailajaLearning.AbstarctComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
    
	WebDriver driver;
		public LandingPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
	
	//driver.findElement(By.id("userEmail"));
		
	@FindBy(id="userEmail")
	WebElement UserEmail;
	//driver.findElement(By.id("userPassword")).sendKeys("Lishika@2020");
	@FindBy(id="userPassword")
	WebElement userPassword;
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement Login;
	
	public ProductCatelogue doActions(String Email,String Pwd) {
		UserEmail.sendKeys(Email);
		userPassword.sendKeys(Pwd);
		Login.click();
		ProductCatelogue obj1=new ProductCatelogue(driver);
		return obj1;
	}
	
 public void goTo() {
	 driver.get("https://rahulshettyacademy.com/client");
	 
 }
 

		
		
		
}