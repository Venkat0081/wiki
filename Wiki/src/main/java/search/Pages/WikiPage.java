package search.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Venkat
 *
 */
public class WikiPage extends BasePage{
	
	public WikiPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By submit = By.xpath("//button[@type='submit']");
	By search = By.xpath("//input[@type='search']");
	By searchResults = By.xpath("//li[@class='mw-search-result']");
	By nationalTeam = By.xpath("//a[@href='/wiki/Germany_national_youth_football_team']");
	
	
	/**
	 * @return the submit
	 */
	public By getSubmit() {
		return submit;
	}
	/**
	 * @return the nationalTeam
	 */
	public By getNationalTeam() {
		return nationalTeam;
	}
	/**
	 * @param nationalTeam the nationalTeam to set
	 */
	public void setNationalTeam(By nationalTeam) {
		this.nationalTeam = nationalTeam;
	}
	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(By submit) {
		this.submit = submit;
	}
	/**
	 * @return the search
	 */
	public By getSearch() {
		return search;
	}
	/**
	 * @param search the search to set
	 */
	public void setSearch(By search) {
		this.search = search;
	}
	/**
	 * @return the searchResults
	 */
	public By getSearchResults() {
		return searchResults;
	}
	/**
	 * @param searchResults the searchResults to set
	 */
	public void setSearchResults(By searchResults) {
		this.searchResults = searchResults;
	}
	
		
	
	
    }

