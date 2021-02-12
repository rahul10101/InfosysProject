package stepDefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.factory.DriverFactory;
import utils.manager.driver.factory.DriverManager;

public class SearchStepDef extends TestBase {
	TestContextUI testContextUI;
	Scenario scn;

	public SearchStepDef(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}

	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	@After
	public void CleanUp(Scenario s) {

		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot) testContextUI.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}

		testContextUI.getDriver().quit();
		scn.write("Browser is Closed");
	}

	@Given("I have browser opened")
	public void i_have_browser_opened() throws Exception {

		DriverManager driverManager = DriverFactory.getDriverManager("chrome");
		WebDriver driver = driverManager.getDriver();
		driverManager.maximizeBrowser();
		driverManager.navigateToDriver(serverUI);
		scn.write("Chrome Driver invoked and URL navigated as: " + serverUI);
		testContextUI.setDriver(driver);
		testContextUI.initializePageObjectClasses(driver, scn);
	}

	@When("I Search {string} and Validate Search Result and click on Infosys url")
	public void i_Search_and_Validate_Search_Result_and_click_on_Infosys_url(String word) {
		testContextUI.getsearchPageObjects().SetsearchTextBoxAndPressEnter(word);
		testContextUI.getsearchPageObjects().validateTitle();
		testContextUI.getsearchPageObjects().validateBingUrl();
	}

	@Then("I move on next page and click on hamburger icon and select service link via mouse hover and click on Testing")
	public void i_move_on_next_page_and_click_on_hamburger_icon_and_select_service_link_via_mouse_hover_and_click_on_Testing() {
		testContextUI.getsearchPageObjects().clickOnInfosysURL();
		testContextUI.getsearchPageObjects().validateInfosysPageTitle();
		testContextUI.getsearchPageObjects().validateInfosysPageUrl();
		testContextUI.getsearchPageObjects().clickOnInfosysHambergerMenu();
		testContextUI.getsearchPageObjects().moveOnHambergerMenuServices();
		testContextUI.getsearchPageObjects().clickOnTestingTitle();
		testContextUI.getsearchPageObjects().validateTestingPageTitle();
		testContextUI.getsearchPageObjects().validateTestingPageUrl();
	}

}
