package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GeneralUtilites {
	
	public String getElementText(WebElement element)
	{
		return element.getText();
		}
	public String selectByValueFromDropdown(WebElement element, String value)
	{
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public String selectByIndexFromDropdown(WebElement element, int index)
	{
		Select object = new Select(element);
		object.selectByIndex(index);
		WebElement SelectedElement = object.getFirstSelectedOption();
		return SelectedElement.getText();
	}
	public String selectByVissibleText(WebElement element, String text)
	{
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement SelectedElement = object.getFirstSelectedOption();
		return SelectedElement.getText();
	}
	public String selectMultiDropdownElement(WebElement element, int size)
	{
		String allElements =null;
		Select multiObj = new Select(element);
		for(int i=0;i<size;i++)
		{
			multiObj.selectByIndex(i);
		}
		List<WebElement> list1 = multiObj.getAllSelectedOptions();
		for(int j=0;j<list1.size();j++)
		{
		 allElements = list1.get(j).getText();
			
		}
		return allElements;
	}
	
	public void sendKeyFunction(WebElement element, String inputValue)
	{
		element.sendKeys(inputValue);
	}
	public void radiobuttonClick(WebElement element)
	{
		element.click();
	}
	public void dragAndDropAction(WebElement source, WebElement target,WebDriver driver)
	{
		Actions actionObj =new Actions(driver);
		actionObj.dragAndDrop(source, target);
	}
	public void pageScroll(WebDriver driver, WebElement element )
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,15500)");
	    //WebElement element =driver.findElement(null);
	   // js.executeScript("arguments[0].click()", element);
		
	}
	public String generateCurrentDateAndTime() //for generating current date & time
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void multipleTabHandle(WebDriver driver)
	{
		String parentWindow =driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String childWindow :allWindows)
		{
			if(!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.getTitle();
				
			}
		}
		driver.switchTo().window(parentWindow);
		
	}

	

}
