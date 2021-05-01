package com.toDos.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.toDos.utils.BasePage;

public class TodoPage extends BasePage{
	
	public TodoPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	
	/*Locators*/
	final static String INPUT_FIELD = "//input[@ng-model='newTodo']";
	final static String ELEMENT_1 = "//label[@class='ng-binding']";
	final static String CHECKBOX = "//input[@type='checkbox']";
	
	/*@FindBy*/
	@FindBy(how = How.XPATH, using = INPUT_FIELD)
	public static WebElement inputField;
	@FindBy(how = How.XPATH, using = ELEMENT_1)
	public static WebElement element1;
	@FindBy(how = How.XPATH, using = CHECKBOX)
	public static WebElement checkbox;
	
	
	/*Methods*/
	public void submitTodo(String todo) throws InterruptedException {
		//inputField.sendKeys(todo);
		//wait explicit until to do
	//	Thread.sleep(3000);
		writeText(inputField, todo);
		inputField.sendKeys(Keys.ENTER);
	}
	
	public Boolean isElementDisplayed(WebElement element) {
		Boolean isElementDisplayed = element.isDisplayed();
		return isElementDisplayed;
	
	}
	
	public String checkElementContains(WebElement element) {
		String elementTodo = element.getText();
		return elementTodo;
	
	}
	
	public Boolean isCheckboxSelected(WebElement element) {
		Boolean isCheckboxSelected = element.isSelected();
		return isCheckboxSelected;
	
	}
	
}
