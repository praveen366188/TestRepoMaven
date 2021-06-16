package pnc.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pnc.ProjectSat.BaseTest;
import pnc.ProjectSat.LoginPg;
import pnc.ProjectSat.Utilities;

public class ParallelExecution {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browserName")
	@BeforeTest
	public void setUpMethod(String browser) throws Exception {
		System.out.println("Browser name is: " + browser);
		System.out.println("Thread id" + Thread.currentThread().getId());
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					projectPath + "\\src\\main\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.infosys.com/careers/apply.html");
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='burger']")
	WebElement hamBurger;
	@FindBy(xpath = "//a[@title='Careers']")
	WebElement careerLinkInHamburgerMenu;

	@Test
	public void multiBrowser() throws Exception {

		Assert.assertEquals(hamBurger.isDisplayed(), true);
		hamBurger.click();
		Assert.assertEquals(careerLinkInHamburgerMenu.isDisplayed(), true);
		careerLinkInHamburgerMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.infosys.com/careers/");

	}

	@AfterTest
	public void tearDownMethod() throws Exception {
		driver.quit();
	}

}
