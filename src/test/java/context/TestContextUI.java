package context;



import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import pageObjects.SearchPageObjects;

public class TestContextUI {
	
	private WebDriver driver;
	private SearchPageObjects searchPageObjects;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public SearchPageObjects getsearchPageObjects() {
		return searchPageObjects;
	}

	public void initializePageObjectClasses(WebDriver driver,Scenario scn) {
		searchPageObjects = new SearchPageObjects(driver,scn);
		
	}
	
		

}
