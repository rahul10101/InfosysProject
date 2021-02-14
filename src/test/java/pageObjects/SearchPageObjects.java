package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class SearchPageObjects extends Interact{
	private static final Logger logger = LogManager.getLogger(SearchPageObjects.class);

 Scenario scn;
 
 private By searchTextBox = By.xpath("//input[@id='sb_form_q']"); 
 private By seachButton = By.xpath("//label[@class='search icon tooltip']");
 private By urlOfInfosys = By.xpath("//a[text()='Infosys - Consulting | IT Services | Digital Transformation']");
 private By infosysHambergerMenu = By.xpath("//div[@class='burger']");
 private By hambergerServices = By.xpath("//a[@title='Services']");
 private By testingTitle = By.xpath("//a[@title='Testing']");
 
 
public SearchPageObjects(WebDriver driver, Scenario s) {
	setDriver(driver);
	this.scn = s;
}

public void SetsearchTextBox(String text)
{
	setElement(searchTextBox, text);
	logger.info("Value Entered in Search Text Box: " +text);
	takeScreenShotAndAttachInReport(scn);
}
	
public void SetsearchTextBoxAndPressEnter(String text)
{
	setElementAndPressEnter(searchTextBox, text);
	logger.info("Value Entered in Search Text Box: " +text);
	takeScreenShotAndAttachInReport(scn);
}

public void clickOnSearchButton() {
	
	clickElement(seachButton);	
	logger.info("Clicked on Search Button");
}


public void validateTitle() {
	String actual = getPageTitle();
	String expected = "Infosys - Bing";
	scn.write("actual: " + actual + " , Expected: " + expected);
	Assert.assertEquals("Page Title", expected.trim(), actual.trim());
}
public void validateBingUrl() {
	String url = getCurrentPageURL();
	if(url.contains("q=infosys"))
	{
		logger.info("q=infosys is available in url");
	}
}

public void validateInfosysPageTitle() {
	String actual = getPageTitle();
	String expected = "Infosys - Consulting | IT Services | Digital Transformation";
	scn.write("actual: " + actual + " , Expected: " + expected);
	Assert.assertEquals("Infosys Page Title", expected.trim(), actual.trim());
}

  public void validateInfosysPageUrl() {
	  String url = getCurrentPageURL();
	  if(url.equals("https://www.infosys.com/"))
	  {
		logger.info("URL link Validated");
	}
  }

	public void clickOnInfosysHambergerMenu() {
		clickElement(infosysHambergerMenu);	
		logger.info("Clicked on Hamberger Menu");
	}
	
	public void clickOnHambergerMenuServices() {
		clickElement(hambergerServices);	
		logger.info("Clicked on Hamberger Menu Services");
	}

	public void moveOnHambergerMenuServices() {
		moveMouseonInfosysServices(hambergerServices);
		logger.info("Moved on Hamberger Menu Services");
	}
	
	public void clickOnTestingTitle() {
		clickElement(testingTitle);
		logger.info("Clicked on Testing Title");
	}
	
	public void clickOnInfosysURL() {
		clickElement(urlOfInfosys);
		logger.info("Clicked on Infosys URL");
}
	
	
	public void validateTestingPageUrl() {
		  String url = getCurrentPageURL();
		  if(url.equals("https://www.infosys.com/services/validation-solutions.html"))
		  {
			logger.info("Testing URL link Validated");
		}
	  }
	
	public void validateTestingPageTitle() {
		String actual = getPageTitle();
		String expected = "Quality Assurance (QA) Consulting Services | Infosys";
		scn.write("actual: " + actual + " , Expected: " + expected);
		Assert.assertEquals("Testing Page Title", expected.trim(), actual.trim());
	}
}
