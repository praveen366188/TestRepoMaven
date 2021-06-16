package pnc.ProjectSat;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelCommonMethods;

public class LoginPg extends BaseTest {
	public LoginPg() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='burger']")
	WebElement hamBurger;
	@FindBy(xpath = "//a[@title='Careers']")
	WebElement careerLinkInHamburgerMenu;

	public void verifyHamburger() throws IOException {

		Assert.assertEquals(hamBurger.isDisplayed(), true);
		hamBurger.click();
		Utilities.screenShot();
		Assert.assertEquals(careerLinkInHamburgerMenu.isDisplayed(), true);
		careerLinkInHamburgerMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.infosys.com/careers/");

	}

	public void verifyFooterFields() {

		ExcelCommonMethods exl = new ExcelCommonMethods(
				projectPath + "\\src\\main\\resources\\testData\\test_infy.xlsx");

		System.out.println(exl.readDataFromExcel("Sheet1", 1, 0));
		System.out.println(exl.readDataFromExcel("Sheet1", 1, 1));
		exl.writeDataFromExcel("Sheet2", "jingli");
		
		
	}
	
	

}
