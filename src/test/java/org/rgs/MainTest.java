package org.rgs;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTest {

    private By companies = By.xpath("//div[@class='container header-container header-main']/nav/ul/li[2]/a");
    private By iframe = By.xpath("//iframe[contains(@id, 'fl-616371')]");
    private By btnClose = By.xpath("//div [@data-fl-track='click-close-login']");
    private By tabHealth = By.xpath("//div[@class='category']/ul/li[2]");
    private By tabDMS = By.xpath("//div[@class='header-list-products']/div/ul/li[3]");
    private By btnSendRequest = By.xpath("//div[@class='actions']/button");
    private By fieldName = By.xpath("//div[@class='input-row']/div/input");
    private By fieldPhone = By.xpath("//div[@formkey='Номер телефона']/div/div/input");
    private By fieldEmail = By.xpath("//div[@formkey='email']/div/div/input");
    private By fieldAddress = By.xpath("//div[@formkey='Адрес']/div/div/div/div/div/input");
    private By checkbox = By.xpath("//div[@class='form__checkbox']/label/input");
    private By btnContactMe = By.xpath("//div[@class='col col-12 ']/div/button");
    WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.rgs.ru");
    }

    @Test
    public void test() {
        //Click on companies
        driver.findElement(companies).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Find iFrame and close
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(btnClose).click();
        driver.switchTo().defaultContent();

        //Click on Здоровье
        WebElement health = driver.findElement(tabHealth);
        health = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(health));
        health.click();

        //Click on ДМС
        WebElement dms = driver.findElement(tabDMS);
        dms = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(dms));
        dms.click();

        //Click on button
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scroll(driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/div[1]/div/div[1]/section/div/div")), 0, 250);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(btnSendRequest).click();

        //Fill the fields
        driver.findElement(fieldName).sendKeys("Апре Проим Куваф");
        driver.findElement(fieldPhone).sendKeys("9110362390");
        driver.findElement(fieldAddress).sendKeys("Санкт-Петербург, ул. Горького, д. 12");
        driver.findElement(fieldEmail).sendKeys("qwertyqwerty");
        scroll(driver.findElement(fieldAddress), 0, 100);

        //Click on checkbox
        WebElement chbx = driver.findElement(checkbox);

        chbx.click();
        //Click on button Свяжитесь со мной
        driver.findElement(btnContactMe).submit();
    }

    public WebElement scroll(WebElement element, int x, int y) {
        String code = "window.scroll(" + (element.getLocation().x + x) +
                ", " + (element.getLocation().y + y) + ");";
        ((JavascriptExecutor) driver).executeScript(code, element, x, y);
        return element;
    }

//    @After
//    public void after() {
//        driver.quit();
//    }
}
