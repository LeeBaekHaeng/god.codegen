package dev.selenium.getting_started;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 셀레늄 테스트 사용
 * 
 * @author 이백행
 * @since 2024-01-13
 *
 */
@NoArgsConstructor
@Slf4j
class UsingSeleniumTest {

	/**
	 * 8개의 구성요소
	 */
	@Test
	void eightComponents() {
		if (log.isDebugEnabled()) {
			log.debug("eightComponents");
		}

		final WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		final String title = driver.getTitle();
		assertEquals("Web form", title, "title 제목");

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		final WebElement textBox = driver.findElement(By.name("my-text"));
		final WebElement submitButton = driver.findElement(By.cssSelector("button"));

		textBox.sendKeys("Selenium");
		submitButton.click();

		final WebElement message = driver.findElement(By.id("message"));
		final String value = message.getText();
		assertEquals("Received!", value, "message 메시지");

		driver.quit();

		assertEquals("", "", "");
	}

}