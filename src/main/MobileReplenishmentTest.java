package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MobileReplenishmentTest {
    /**
     * All UI Elements:
     * */
    By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By submitBtn = By.xpath("//button[@data-qa-node='submit']");
    By details = By.xpath("//div[@data-qa-node='details']");
    By actualCardNumber = By.xpath("//td[@data-qa-node='card']");
    By actualMobileOperator = By.xpath("//span[@data-qa-node='nameB']");
    By actualAmount = By.xpath("//div[@data-qa-node='amount']");

    /**
     * All Test Data
     * */
    String phoneNumberValue = "686979712";
    String minSumAmountValue = "1";
    String cardNumberValue = "4004159115449003";
    String expDateValue = "1227";
    String cvvValue = "123";
    String firstNameValue = "Test";
    String lastNameValue = "Testovich";
    /**
     * Expected data
     * */
    String expectedSum = "1 UAH";
    String expectedPhoneNumber = "Поповнення телефону. На номер +380686979712";
    String expectedCardNumber = "4004 **** **** 9003";
    String expectedMobileOperator = "Kyivstar Ukraine";

    @Test
    void checkMinSum(){
        //Вказуэмо шлях до Драйвера, по якому будемо робити копiю для тестiв
        //System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        // Створюэмо новий об'экт driver для браузера Хрому, де будуть мiститись методи webDriver
//        do {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://next.privat24.ua/mobile");
            driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
            driver.findElement(amount).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            driver.findElement(amount).sendKeys(minSumAmountValue);
            driver.findElement(cardNumber).sendKeys(cardNumberValue);
            driver.findElement(expDate).sendKeys(expDateValue);
            driver.findElement(cvv).sendKeys(cvvValue);
            driver.findElement(firstName).sendKeys(firstNameValue);
            driver.findElement(lastName).sendKeys(lastNameValue);
            driver.findElement(submitBtn).submit();
            // Compare ER with AR

            Assertions.assertEquals(expectedPhoneNumber, driver.findElement(details).getText());
            Assertions.assertEquals(expectedCardNumber, driver.findElement(actualCardNumber).getText());
            Assertions.assertEquals(expectedMobileOperator, driver.findElement(actualMobileOperator).getText());
            Assertions.assertEquals(expectedSum, driver.findElement(actualAmount).getText());

            driver.close();
//        } while(true);

    }
}
