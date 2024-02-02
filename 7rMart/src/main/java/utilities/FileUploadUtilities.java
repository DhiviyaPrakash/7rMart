package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FileUploadUtilities {
	public void fileUpload(WebElement element, WebDriver driver, String path) throws Exception 
	{
		Actions obj = new Actions(driver);
	    obj.moveToElement(element).click().perform();
	  
	    //put path to your image in a clipboard
	   StringSelection s1=new  StringSelection(path);	 
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
	   
	   Robot robot = new Robot();
	     robot.delay(1000 );
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     
	     robot.delay(250);
	      robot.keyRelease(KeyEvent.VK_CONTROL);
	      robot.keyRelease(KeyEvent.VK_V);
	     
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
