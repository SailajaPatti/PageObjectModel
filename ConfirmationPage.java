package sailajaLearning.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sailajaLearning.AbstarctComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
  WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	//driver.findElement(By.xpath("//div[@class='form__cc']//div[1]//div[1]//input[1]")).sendKeys("093");
	@FindBy(xpath="//div[@class='form__cc']//div[1]//div[1]//input[1]")
	WebElement Credit;
	
	//driver.findElement(By.xpath("//div[contains(text(),'Name on Card')]/following-sibling::input")).sendKeys("Sailaja");
	@FindBy(xpath="//div[contains(text(),'Name on Card')]/following-sibling::input")
	WebElement CardName;
	
	//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("Ind");
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	//driver.findElements(By.cssSelector("button[type='button']"));
	@FindBy(css="button[type='button']")
	List<WebElement> dropdown;
	
	//WebElement submit=driver.findElement(By.cssSelector(".action__submit"));
	@FindBy(xpath="//a[text()='Place Order ']//i")
	WebElement Submit;
	public void EnterAllCardDetails(int credit,String cardName) {
		
		Credit.sendKeys(String.valueOf(credit));
		CardName.sendKeys(cardName);
		
		}
	public void SelectCountry(String country) {
		Country.sendKeys(country);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement COUNTRY=dropdown.stream().filter(s-> s.getText().equals("India")).findFirst().orElse(null);
		COUNTRY.click();
	   }
	
	public void ClickSubmit() throws InterruptedException {
		Thread.sleep(2000);
		Submit.click();
	}
	

}
