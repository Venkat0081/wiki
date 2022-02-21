package search;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import search.Pages.WikiPage;

/**
 * 
 * @author Venkat
 *
 */
public class SearchText extends BaseCommand{

	/**
	 * 
	 * @throws IOException
	 */
	public SearchText() throws IOException {
		super();
	}

	@Test
	public void getPageTitle() {
		if(driver != null) {
			Assert.assertTrue(driver.getTitle().equals(title));
		}

	}

	@Test
	public void getSearchResult() {		
		
		String[] searchTextArray = null;
		String[] searchResulttArray = null;
		List<WebElement> searchResults = null;
		if(page != null) {
		WikiPage wikipage = page.getInstance(WikiPage.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wikipage.getSubmit()));
		driver.findElement(wikipage.getSearch()).sendKeys(searchText);
		driver.findElement(wikipage.getSearch()).sendKeys(Keys.ENTER);

		searchResults = driver.findElements(wikipage.getSearchResults());
		searchTextArray = searchText.split(" ");
		if (searchResults != null && searchResults.size() > 0) {
			WebElement searchResult= searchResults.iterator().next();
			searchResulttArray = searchResult.getText().split(" ");
			if(searchResulttArray!= null && searchResulttArray.length > 0) {
				for (String str : searchTextArray) {
					boolean doesContain = Arrays.stream(searchResulttArray).anyMatch(x -> x.equalsIgnoreCase(str));

					Assert.assertTrue(doesContain);
				}
			}

		}
		}
	}

	@Test
	public void getScreenshot() {
		boolean isSuccess= false;
		if(page != null) {
			WikiPage wikipage = page.getInstance(WikiPage.class);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(wikipage.getSubmit()));
			driver.findElement(wikipage.getSearch()).sendKeys(searchText);
			driver.findElement(wikipage.getSearch()).sendKeys(Keys.ENTER);
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\test-output\\ScreenShot\\SearchText.png"));
				isSuccess= true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Assert.assertTrue(isSuccess);

	}	

	/**
	 * 
	 * @param val
	 */
	public static void setSleep(int val) {

		try {
			Thread.sleep(val);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
