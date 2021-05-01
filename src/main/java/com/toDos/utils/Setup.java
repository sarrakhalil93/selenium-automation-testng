package com.toDos.utils;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class Setup extends BasePage {

	public Setup() throws IOException {
		super();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setupTest(String browser) throws InterruptedException {
		initialization(browser);
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		Assert.assertEquals(driver.getTitle(), "AngularJS • TodoMVC");
	}
	@AfterMethod
	public void cleanTest() {
		driver.navigate().refresh();
		driver.quit();
	}
}
