package com.todos.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.toDos.pages.TodoPage;
import com.toDos.utils.Setup;

public class AddTodoTest extends Setup {

	public AddTodoTest() throws IOException {
		super();
	
	}
	TodoPage todoPage;
	@Test(priority = 1)
	public void iCanAddTodo() throws IOException, InterruptedException {
		todoPage = new TodoPage();
		boolean elementText = todoPage.isElementDisplayed(TodoPage.inputField);
		Assert.assertTrue(elementText);
		todoPage.submitTodo(prop.getProperty("todo1"));
		String elementToDo = todoPage.checkElementContains(TodoPage.element1);
		Assert.assertTrue(elementToDo.contains(prop.getProperty("todo1")));
		// ou autrement
		//Assert.assertEquals(prop.getProperty("todo1"), elementToDo);
		boolean checkbox = todoPage.isCheckboxSelected(TodoPage.checkbox);
		Assert.assertFalse(checkbox);
	}
	
}
