package sailajaLearning.AbstarctComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
 static WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
public static void ElementToAppear(By FindBy) {
	
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
	w.until(ExpectedConditions.visibilityOf(driver.findElement(FindBy)));
	
}
public static void ElementToDisappear(By FindBy) throws InterruptedException {
	Thread.sleep(2000);
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
    w.until(ExpectedConditions.invisibilityOf(driver.findElement(FindBy)));
}
public static void Implicitwait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
}
