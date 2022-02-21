package search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import search.Pages.BasePage;
import search.Pages.Page;

/**
 * 
 * @author Venkat
 *
 */
public class BaseCommand {
	
    public String url;
    public WebDriver driver; 
    public String browserName;
    public String title;
    public String searchText;
    public String relaventResult;
    public String publishedDate;
    public Page page;
    /**
     * 
     * @throws IOException
     */
    public BaseCommand() throws IOException {

        FileInputStream file = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//searchconfig.properties");
			getProperties(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
  
    /**
     * 
     * @param browserName
     * @return
     */
    @BeforeMethod
    public WebDriver getBrowser()
    {
    	System.out.println("---" + browserName);
        if(browserName.equals("chrome")) {
        	WebDriverManager.chromedriver().setup();
        	driver= new ChromeDriver();
	    	  driver.get(url);	
	          driver.manage().window().maximize();
	          page = new BasePage(driver);
        }
       
        return driver;
    }
    
    
    
    @AfterMethod
    public void tearDown() {
    if(driver != null) {
    	driver.quit();
    }
    	
    }
    
    /**
     * 
     * @param prop
     * @throws IOException 
     */
	public void getProperties(FileInputStream file) throws IOException {
		Properties prop = new Properties();
		prop.load(file);		
		
		url = prop.getProperty("url");
		title = prop.getProperty("title");
		searchText = prop.getProperty("searchText");
		browserName = prop.getProperty("browserName");
		publishedDate= prop.getProperty("publishedDate");
		relaventResult = prop.getProperty("relaventResult");

		
	}
    
}


