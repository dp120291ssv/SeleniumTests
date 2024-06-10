package main;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MobileReplenishmentTest {

    @Test
    void checkMinSum(){
        /**
         * All UI Elements:
         * */
        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");

        /**
         * All Test Data
         * */
        String phoneNumberValue = "686979712";

        //Вказуэмо шлях до Драйвера, по якому будемо робити копiю для тестiв
        //System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        // Створюэмо новий об'экт driver для браузера Хрому, де будуть мiститись методи webDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://next.privat24.ua/mobile");
        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);


        // Compare ER with AR

        driver.close();

    }
}
