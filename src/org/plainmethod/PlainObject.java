package org.plainmethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlainObject {
	
	public static WebDriver driver;
	@FindBy(xpath="//input[@data-testid='royal_email']")
	private WebElement logIn;
	@FindBy(id="pass")
	private WebElement password;
	
	public PlainObject(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public WebElement getLogin() {
		return logIn;
	}
	public WebElement getPassword() {
		return password;
	}
	
	

}
