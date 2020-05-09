//Working fine

package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {

		// Web driver code:
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		ChromeDriver driver = new ChromeDriver();// launch browser
		driver.get("https://login.yahoo.com/account/create?src=noSrc&specId=yidReg");

		// Get test data from excel
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Yogesh\\eclipse-workspace\\Java Training\\DataDrivenFW-Part2\\src\\main\\java\\com\\testdata\\Yahooform2.xlsx");

		String FirstName = reader.getCellData("RegTestData", "FirstName", 2);
		System.out.println(FirstName);

		String LastName = reader.getCellData("RegTestData", "LastName", 2);
		System.out.println(LastName);

		String EmailAddress = reader.getCellData("RegTestData", "EmailAddress", 2);
		System.out.println(EmailAddress);

		String Password = reader.getCellData("RegTestData", "Password", 2);
		System.out.println(Password);

		String BirthMonth = reader.getCellData("RegTestData", "BirthMonth", 2);
		System.out.println(BirthMonth);

		String Day = reader.getCellData("RegTestData", "Day", 2);
		System.out.println(Day);

		String Gender = reader.getCellData("RegTestData", "Gender", 2);
		System.out.println(Gender);

		// Enter the data
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FirstName);

		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(LastName);

		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys(EmailAddress);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);

		Select select = new Select(driver.findElement(By.xpath("//select[@id='usernamereg-month']")));
		select.selectByVisibleText(BirthMonth);

		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys(Day);

		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys(Gender);
	}

}
