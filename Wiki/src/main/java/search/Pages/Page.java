package search.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Venkat
 *
 */
public abstract class Page {

	    WebDriver driver;
	    WebDriverWait wait;

	    public Page(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(this.driver,15);
	        PageFactory.initElements(driver, this);
	    }
       public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
	    {
	        try {
	            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
}
