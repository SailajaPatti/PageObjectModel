package sailajaLearning.PageObject;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sailajaLearning.AbstarctComponent.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	WebDriver driver;
	
	By checkout=By.xpath("//button[normalize-space()='Checkout']");
	
	     public PaymentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	    	 super(driver);
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
	    
	}
  @FindBy(css=".cart h3")
static
  List<WebElement> CartItems;
  
  public static boolean VerificationOfAdded(String productname) {
	  
	  boolean match=((Collection<WebElement>) CartItems).stream().anyMatch(Item -> Item.getText().equalsIgnoreCase(productname));
		
		return match;
  }
  public ConfirmationPage CheckoutClick() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(checkout).click();
	  ConfirmationPage obj4=new ConfirmationPage(driver);
	  return obj4;
	 
  }
}

