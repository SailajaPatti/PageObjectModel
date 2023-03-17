package sailajaLearning.recheck;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import sailajaLearning.PageObject.ConfirmationPage;
import sailajaLearning.PageObject.LandingPage;
import sailajaLearning.PageObject.PaymentPage;
import sailajaLearning.PageObject.ProductCatelogue;
import sailajaLearning.TestComponent.BaseTest;



public class Test1 extends BaseTest {
	
	@Test
	
	public void submitOrder() throws IOException, InterruptedException
	{
		
	 String RE="IPHONE 13 PRO";
     LandingPage obj= launchApplication();
	 ProductCatelogue obj1=obj.doActions("sailaja@tcs.com", "Lishika@2020");
     obj1.Products();
     obj1.getRequiredProduct(RE);
     obj1. addToCart(RE);
     PaymentPage obj3= obj1.CartButtonClick();
     boolean match=obj3.VerificationOfAdded(RE);
     Assert.assertTrue(match);
     ConfirmationPage obj4= obj3.CheckoutClick();
     obj4.EnterAllCardDetails(89778888, "sailaja");
     obj4.SelectCountry("Ind");
     //obj4.ClickSubmit();
    //since final submit button is not working properly so that not creating the class for the final page
    //String Confirm=driver.findElement(By.cssSelector(".hero-primary")).getText();
    //Assert.assertTrue(Confirm.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
    
	}


}

	

		
		
	   
	    
		
	    
//why everytime need to create obj we simply return that in langing page rt since after submit in 
//in landing page it is causing to open next page rt then create object there it self call that method in Test and assign in a variable
//In main java u created locators and in test/java folder u r creating tests where is actual execution is happening
//this instaniation of driver and invoking driver these are all common steps foe every test rt 	//so u can create one common test component for that invoking browser of any as our requirement
//so for this always better to maintain a global properties file for making instantiate the browser
//since we need to work on multiple browsers rt when we r preparing for framework


    
	    
		
		
		
		
	    
		
		
		
		
		
		
		
		
		
	   


	


