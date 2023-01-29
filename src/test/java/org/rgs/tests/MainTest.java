package org.rgs.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static io.smallrye.common.constraint.Assert.assertTrue;

class MainTest {

 /*   private By title = By.xpath("//*[@id=\"__layout\"]/div/main/div[1]/div/div[1]/section/div/div/div/div[2]/h1");
    private String checker = "Добровольное медицинское страхование";
    private By cookies = By.xpath("//*[@id=\"__layout\"]/div/main/div[2]/div/div/button");
    private By companies = By.xpath("//div[@class='container header-container header-main']/nav/ul/li[2]/a");
    private By iframe = By.xpath("//iframe[contains(@id, 'fl-616371')]");
    private By btnClose = By.xpath("//div [@data-fl-track='click-close-login']");
    private By tabHealth = By.xpath("//div[@class='category']/ul/li[2]");
    private By tabDMS = By.xpath("//div[@class='header-list-products']/div/ul/li[3]");
    private By btnSendRequest = By.xpath("//*[@id=\"__layout\"]/div/main/div[1]/div/div[1]/section/div/div/div/div[4]/a");
    private By formRequest = By.xpath("//*[@id=\"__layout\"]/div/main/div[1]/div/div[4]/section/div/div/div/div/div[1]/div[2]/div");

    private By fieldName = By.xpath("//div[@class='input-row']/div/input");
    private By fieldPhone = By.xpath("//div[@formkey='Номер телефона']/div/div/input");
    private By fieldEmail = By.xpath("//div[@formkey='email']/div/div/input");
    private By fieldAddress = By.xpath("//div[@formkey='Адрес']/div/div/div/div/div/input");
    private By checkbox = By.xpath("//div[@class='form__checkbox']/label/input");
    private By btnContactMe = By.xpath("//div[@class='col col-12 ']/div/button");
    static WebDriver driver;

    @BeforeAll
    static void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.rgs.ru");
    }

    void checkTitle() {
       if (driver.findElement(title).getText().contains(checker)) {
           System.out.println("Correct page");
        }
    }

    @Test
    void test() {
        driver.findElement(companies).click();

        findAndCloseIFrame();

        driver.findElement(tabHealth).click();

        driver.findElement(tabDMS).click();
        checkTitle();

        if(driver.findElement(cookies).isDisplayed()) {
            driver.findElement(cookies).click();
        }

        driver.findElement(btnSendRequest).click();

        if (driver.findElement(formRequest).isDisplayed()) {
            System.out.println("Форма заполнения заявки видна");
        }
    }

    private void findAndCloseIFrame() {
        try {
            driver.switchTo().frame(driver.findElement(iframe));
            driver.findElement(btnClose).click();
            driver.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            driver.switchTo().defaultContent();
        }
    }*/

    /*public WebElement scroll(WebElement element, int x, int y) {
        String code = "window.scroll(" + (element.getLocation().x + x) +
                ", " + (element.getLocation().y + y) + ");";
        ((JavascriptExecutor) driver).executeScript(code, element, x, y);
        return element;
    }

    private boolean isDisplayedFrame(By by) {
        try {
            driver.switchTo().frame(driver.findElement(by));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }*/

    /*@AfterAll
    static void after() {
        driver.quit();
    }*/
}
