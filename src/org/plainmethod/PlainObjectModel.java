package org.plainmethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlainObjectModel {
	public static WebDriver driver;
	@FindBy(xpath="//button[@data-testid='royal_login_button']")
	private WebElement button;

	public PlainObjectModel(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getButton() {
		return button;
	}
}
