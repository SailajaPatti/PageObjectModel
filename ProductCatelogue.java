package sailajaLearning.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sailajaLearning.AbstarctComponent.AbstractComponent;


public class ProductCatelogue extends AbstractComponent {
	private static final Logger log = LoggerFactory.getLogger(ProductCatelogue.class);
    
	WebDriver driver;
		public ProductCatelogue(WebDriver driver) {
			
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(className="col-lg-4")
		static
		List<WebElement> Products;
		
	
	//static By ProductBy= By.cssSelector("#toast-container");
	static By AddToCart=By.cssSelector(".card-body button:last-of-type");
	//static By Dproduct=By.cssSelector(".ng-animating");
	static By cart=By.xpath("//button[@routerlink='/dashboard/cart']");
	
	public static List<WebElement> Products() {
		
		return Products;
	}
		
		public static WebElement getRequiredProduct(String productname)
		{
			WebElement Prod=Products().stream().filter(Product->
			Product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
			return Prod;
		}
		
		public static void addToCart(String productname) throws InterruptedException {
			
			WebElement prod=getRequiredProduct(productname);
			Implicitwait();
			 prod.findElement(AddToCart).click();
			 
			
			 //ElementToAppear(ProductBy);
			 //ElementToDisappear(Dproduct);
			
		}
		public  PaymentPage CartButtonClick() throws InterruptedException{
			
			Thread.sleep(1000);
			driver.findElement(cart).click();
			log.info(driver.toString());
			 PaymentPage obj3=new PaymentPage(driver);
			 log.info(obj3.toString());
				return obj3;
			
		}
	}
 

		
		
		
