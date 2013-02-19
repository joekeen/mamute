package br.com.caelum.brutal.integration.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {

	protected final WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement byId(String id) {
		return driver.findElement(By.id(id));
	}

	protected WebElement byName(String name) {
		return driver.findElement(By.name(name));
	}

	protected List<WebElement> allByClassName(String name) {
		return driver.findElements(By.className(name));
	}
	
	protected WebElement byClassName(String name) {
	    try {
	        return driver.findElement(By.className(name));
	    } catch (NoSuchElementException e) {
	        return null;
        }
	}
	
	protected WebElement byCSS(String selector) {
	    return driver.findElement(By.cssSelector(selector));
	}
	
	protected List<WebElement> allByCSS(String selector) {
	    return driver.findElements(By.cssSelector(selector));
	}
	
	protected void waitForElement(final By by, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
