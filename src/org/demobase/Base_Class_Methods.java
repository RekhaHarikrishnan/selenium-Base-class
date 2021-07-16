package org.demobase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class_Methods {
	
	
	public static WebDriver driver;

	// WebDriver
	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ranjithrekha\\eclipse-workspace\\SeleniumLocators\\Driver\\chromedriver.exe");
			 driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ranjithrekha\\eclipse-workspace\\SeleniumLocators\\Driver\\geckodriver.exe");
			 driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid ");
		}
		driver.manage().window().maximize();
		return driver;
	}

	// get
	public static void openUrl(String url) {
		driver.get(url);

	}

	// close
	public static void closeOption() {
		driver.close();

	}

	// quit
	public static void quitBrowser() {
		driver.quit();

	}

	// Navigation Methods
	// navigate to
	public static void navigateToMethod(String url) {
		driver.navigate().to(url);

	}

	// Navigate Back
	public static void navigateBackmethod() {
		driver.navigate().back();

	}

	// Navigate Refresh
	public static void toRefreshPage() {
		driver.navigate().refresh();

	}

	// Navigate Forward
	public static void forwardThePage() {
		driver.navigate().forward();

	}

	// getCurrentUl
	public static void getCurrentUrlMethod() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	// TakeScreenShot
	public static void takeScreenshot(String path) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFileToDirectory(source, destination);

	}

	// getTitle
	public static void toGetTitle() {

		String title = driver.getTitle();
		System.out.println(title);
	}
	//wait methods
    //Implicitly Wait 
      public static void implicitlyWaitMethod(int num,String s) {
		driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
	}
      //Explicitly Wait
        public static void explicitlyWaitMethod(WebElement element,int num) {
			WebDriverWait wait = new WebDriverWait(driver, num);
            wait.until(ExpectedConditions.visibilityOf(element));
		}
      
      
      
	// WebElements
	// Click
	public static void clickTheButton(WebElement element) {
		element.click();

	}

	// SendKeys
	public static void sendTheValues(WebElement element, String s) {
		element.sendKeys(s);

	}

	// getText
	public static void getTextValue(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}

	// isEnable
	public static void checkItIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	// isDisplayed
	public static void ckeckItIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	// isSelected
	public static void checkItIsSelected(WebElement element) {

		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	// getAttribute
	public static void getAttributeValues(WebElement element) {
		String attribute = element.getAttribute("textContent");
		System.out.println(attribute);

	}

	// checkbox
	public static void clickCheckBox(WebElement element) {
		element.click();

	}

	// get Options
	public static void getAllOptions(WebElement element) {
		Select s = new Select(element);
		System.out.println("****All Options:****");
		List<WebElement> Options = s.getOptions();
		for (WebElement allOptions : Options) {
			String text = allOptions.getText();
			System.out.println(text);
		}
		
		System.out.println("***Size****");
		int size = Options.size();
		System.out.println(size);
		
		
		for (int i = 0; i < size; i++) {
			
			if (i==1||i==5||i==7) {
				s.selectByIndex(i);
			}
		}

	}

	// getAllSelectedOptions

	public static void allSelectedOptions(WebElement element) {
		Select s = new Select(element);
		System.out.println("****All Selected Options:****");
		List<WebElement> options = s.getAllSelectedOptions();
		for (WebElement allSelectedOptions : options) {
			String text = allSelectedOptions.getText();
			System.out.println(text);
			
			
		}

	}

	// get FirstSelectedOption
	public static void firstSelectedOption(WebElement element) {

		Select s = new Select(element);
		System.out.println("****First Selected Optionj:****");
		WebElement firstSelectedOption = s.getFirstSelectedOption();

		String text = firstSelectedOption.getText();
		System.out.println(text);

	}

	// isMultiple
	public static void ckeckItIsMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println("Dropdown Is Multiple Or Not:" + multiple);
	}

	// Alert Types
	// Simple Alert

	public static void simpleAlertMethod(WebElement element) {
		element.click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
	}

	// Confirm Alert
	public static void confirmAlertMethod(String s) {
		Alert confirmAlert = driver.switchTo().alert();
		if (s.equalsIgnoreCase("accept")) {
			confirmAlert.accept();
		} else if (s.equalsIgnoreCase("dismiss")) {
			confirmAlert.dismiss();
		}
	}

	// promptAlert
	public static void promptAlertMethod(String sendkeys, String s) {
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys(sendkeys);
		String text = promptAlert.getText();
		System.out.println(text);
		if (s.equalsIgnoreCase("accept")) {
			promptAlert.accept();

		} else if (s.equalsIgnoreCase("dismiss")) {
			promptAlert.dismiss();

		}

	}
	
	//Actions
	public static void mouseOverAction(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

	}
	//Right click Action
	public static void rightClickAction(WebElement element) {
		Actions a = new Actions(driver);
        a.contextClick(element).build().perform();
	}
	//Robot Actions
	public static void robotActionMethod() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
	}
	//Drag and Drop Method
	public static void dragAndDrop(WebElement drag,WebElement drop) {
		Actions a = new Actions(driver);
        a.dragAndDrop(drag, drop).build().perform();;
	}
	
	//Frames
	//Single Frame
	public static void frameUsingIndex(int index) {
		driver.switchTo().frame(index);
		
	}
	//frame using string
		public static void frameUsingString(String str) {
			driver.switchTo().frame(str);
		}
		//Frame using Webelement
		public static void frameUsingWebelement(WebElement element) {
			driver.switchTo().frame(element);

		}
	//Quit The Frame
	public static void quitFrame() {
		
		driver.switchTo().defaultContent();
	}
	//MultipleFrame
	public static void numberOfFrames(int outerindex,int innerindex) {
		
		driver.switchTo().frame(outerindex);
        driver.switchTo().frame(innerindex);
        quitFrame();
	}
	
	//Drop Down
	//Single Dropdown using index 
	public static void dropdownUsingIndex(WebElement element,int index) {
		Select s = new Select(element);
        s.selectByIndex(index);
	}
	//single Dropdown using value
         public static void dropdownUsingValue(WebElement element,String value) {
       	 Select s = new Select(element);	
         s.selectByValue(value);
		}
         
    //single Dropdown using Visible text 
         public static void dropdownUsingText(WebElement element,String text) {
       	 Select s = new Select(element);	
         s.selectByVisibleText(text);
		}
         
         
     //Multiple Dropdown  
         public static void multipleDropDown(WebElement element) {
       	 Select s = new Select(element);

		}
         
       //Scrollup and Down methods
         //Scroll up
           public static void toScrollUp(WebElement element) {
          	 JavascriptExecutor js = (JavascriptExecutor) driver;
               js.executeScript("arguments[0].scrollIntoView;",element);
		}
         //scrollDown
           public static void toScrollDown(WebElement element) {
        	   JavascriptExecutor js = (JavascriptExecutor) driver;
               js.executeScript("arguments[0].scrollIntoView;",element);
		}
           
          //to scroll bottom of the page 
           public static void toScrollBottom() {
        	   
      	     JavascriptExecutor js = (JavascriptExecutor) driver;
      	     js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
           
           //Window Handles
         public static void getWindowTitles() {
        	 Set<String> allTitle = driver.getWindowHandles();
     		for (String id : allTitle) {
     			String myTitle = driver.switchTo().window(id).getTitle();
     			System.out.println(myTitle);

		}
     		String address = "Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in";
    		for (String id : allTitle) {
    			if (driver.switchTo().window(id).getTitle().equals(address)) {
    				break;

    			}
    		}
       }



}

