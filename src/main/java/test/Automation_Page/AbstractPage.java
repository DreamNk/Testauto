package test.Automation_Page;

import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.ghx.auto.core.ui.page.AbstractPage;

public class AbstractPage <T extends AbstractPage<T>> {

	final WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	/** Type text into a page element.. */
	public T enter(By by, String value) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(value);
		return me();
	}

	/** Check or uncheck a checkbox, if necessary. */
	public T checkCheckbox(By by, Boolean shouldBeChecked) {
		WebElement element = driver.findElement(by);
		if (element.isSelected() != shouldBeChecked)
			element.click();
		  return me();
	}

	public T click(By by) throws InterruptedException {
		WebElement element = driver.findElement(by);
		element.click();
		return me();
	}

	public T doubleclick(By by) throws InterruptedException {
		WebElement element = driver.findElement(by);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		return me();
	}

	/** Get the value of a page element. */
	public String value(By by) {
		WebElement element = driver.findElement(by);
		return element.getAttribute("value");
		
	}

	public String getText(By by) {
		String text = driver.findElement(by).getText();
		return text;
	}

	/** Select drop down option. */
	public T selectDropdownOption(By by, String option) {
		WebElement element = driver.findElement(by);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(option);
		return me();
	}

	/** Deselect all options. */
	public T deselectAll(By by) {
		WebElement element = driver.findElement(by);
		Select selectable = new Select(element);
		selectable.deselectAll();
		return me();
	}

	/** Hover a specified element. */
	public WebElement hover(By by) {
		WebElement element = driver.findElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		return element;
	}

	/** Wait for some time. */
	public T waitFor(int timeout) {
		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return me();
	}
	
	@SuppressWarnings("unchecked")
    protected T me() {
        return (T) this;
    }
	
	
	/** Wait for a page element to be visible. */
	public T waitForElementToBeVisible(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return me();
	}

	/** Wait for a page element to be invisible. */
	public T waitForElementToBeInVisible(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		return me();
	}

	/** Wait for text to be present in a page element's value. */
	public T WaitForTextToBePresentInElementValue(By by, String text, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
		return me();
	}

	/** Wait for a clickable page element within a specified timeframe. */
	public T WaitForElementToBeClickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return me();
	}

	/** Check if a page element is visible. */
	public Boolean isVisible(By selector, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(selector));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** Check if a page element exists. */
	public Boolean exists(By selector) {
		return driver.findElements(selector).size() != 0;
	}

	public int elementCount(By selector) {
		return driver.findElements(selector).size();
	}

	/** Scroll an element into view. */
	public T scrollToElement(By by) {
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return me();
	}

	/** Scroll to the top of the page. */
	public T scrollToTopOfPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);");
		return me();
	}

	/** Scroll to the bottom of the page. */
	public T scrollToBottomOfPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		return me();
	}

}
