package dev.selenium.getting_started;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingSeleniumTest {

	@Test
	public void eightComponents() {
		if (log.isDebugEnabled()) {
			log.debug("eightComponents");
		}

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		String title = driver.getTitle();
		assertEquals("Web form", title);

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));

		textBox.sendKeys("Selenium");
		submitButton.click();

		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		assertEquals("Received!", value);

		driver.quit();
	}

}