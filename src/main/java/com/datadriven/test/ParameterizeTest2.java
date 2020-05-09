/*Working fine

* This is called Data Driven Approach -- used to create Data Driven framework
* Data driven Approach means -- Driving the data from Excel or other files. Also called Parametrisation. 
*/

package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest2 {

	public static void main(String[] args) {

		// Web driver code:
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		ChromeDriver driver = new ChromeDriver();// launch browser
		driver.get("https://login.yahoo.com/account/create?src=noSrc&specId=yidReg");

		// Get test data from excel
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Yogesh\\eclipse-workspace\\Java Training\\DataDrivenFW-Part2\\src\\main\\java\\com\\testdata\\Yahooform2.xlsx");
		int rowCount = reader.getRowCount("RegTestData");

		reader.addColumn("RegTestData", "Status");
		
		// Parametrisation: Para. always done by using for loop
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("*******************");

			String FirstName = reader.getCellData("RegTestData", "FirstName", rowNum);
			System.out.println(FirstName);

			String LastName = reader.getCellData("RegTestData", "LastName", rowNum);
			System.out.println(LastName);

			String EmailAddress = reader.getCellData("RegTestData", "EmailAddress", rowNum);
			System.out.println(EmailAddress);

			String Password = reader.getCellData("RegTestData", "Password", rowNum);
			System.out.println(Password);

			String BirthMonth = reader.getCellData("RegTestData", "BirthMonth", rowNum);
			System.out.println(BirthMonth);

			String Day = reader.getCellData("RegTestData", "Day", rowNum);
			System.out.println(Day);

			String Gender = reader.getCellData("RegTestData", "Gender", rowNum);
			System.out.println(Gender);

			// Enter the data.

			driver.findElement(By.xpath("//input[@name='firstName']")).clear();
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FirstName);

			driver.findElement(By.xpath("//input[@name='lastName']")).clear();
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(LastName);

			driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).clear();
			driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys(EmailAddress);

			driver.findElement(By.xpath("//input[@type='password']")).clear();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);

			Select select = new Select(driver.findElement(By.xpath("//select[@id='usernamereg-month']")));
			select.selectByVisibleText(BirthMonth);

			driver.findElement(By.xpath("//input[@id='usernamereg-day']")).clear();
			driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys(Day);

			driver.findElement(By.xpath("//input[@name='freeformGender']")).clear();
			driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys(Gender);
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");// write the data into cell
		}

	}

}
