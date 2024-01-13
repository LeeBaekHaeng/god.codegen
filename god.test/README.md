# 테스트

목차

1. Selenium 셀레늄
2. Getting Started 시작하기
3. Install a Selenium library Selenium 라이브러리 설치
4. junit-jupiter-api 5.10.1
5. lombok
6. log4j2.xml
7. Using Selenium 셀레늄 사용

## Selenium 셀레늄
웹 애플리케이션 자동화 및 테스트

https://www.selenium.dev/

## Getting Started 시작하기
WebDriver

https://www.selenium.dev/documentation/webdriver/

## Install a Selenium library Selenium 라이브러리 설치
https://www.selenium.dev/documentation/webdriver/getting_started/install_library/

```xml
		<!-- https://www.selenium.dev/documentation/webdriver/getting_started/install_library/ -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.16.1</version>
		</dependency>
```

## junit-jupiter-api 5.10.1

```xml
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.1</version>
    <scope>test</scope>
</dependency>
```

## lombok
eclipse.ini
```
-javaagent:plugins/org.projectlombok.agent_1.18.24/lombok.jar
```

```xml
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>
```

## log4j2.xml
/god.test/src/test/resources/log4j2.xml
```xml
		<Logger name="god" level="DEBUG" additivity="false">
			<AppenderRef ref="console" />
		</Logger>
```

## Using Selenium 셀레늄 사용

https://www.selenium.dev/documentation/webdriver/getting_started/using_selenium/#examples

Examples

```java
package dev.selenium.getting_started;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsingSeleniumTest {

    @Test
    public void eightComponents() {
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
```

java.lang.UnsupportedClassVersionError: org/openqa/selenium/chrome/ChromeDriver has been compiled by a more recent version of the Java Runtime (class file version 55.0), this version of the Java Runtime only recognizes class file versions up to 52.0

java.lang.UnsupportedClassVersionError: org/openqa/selenium/chrome/ChromeDriver는 최신 버전의 Java Runtime(클래스 파일 버전 55.0)으로 컴파일되었습니다. 이 Java Runtime 버전은 최대 52.0의 클래스 파일 버전만 인식합니다.

https://www.baeldung.com/java-lang-unsupportedclassversion

https://www.oracle.com/java/technologies/java-se-support-roadmap.html

52 = Java 8

55 = Java 11

https://adoptium.net/temurin/releases/?os=windows&arch=x64&package=jdk&version=11

OpenJDK11U-jdk_x64_windows_hotspot_11.0.21_9.zip

jdk-11.0.21+9

