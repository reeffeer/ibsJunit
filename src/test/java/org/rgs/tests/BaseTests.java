package org.rgs.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rgs.pages.HomePage;
import org.rgs.pages.VHIPage;
import org.rgs.utils.ConfigurationProperties;
import org.rgs.utils.Driver;


import java.util.concurrent.TimeUnit;

public class BaseTests {
    public static WebDriver webDriver;
    public static Actions actions;
    public static JavascriptExecutor executor;
    public static WebDriverWait wait;
    public static HomePage homePage;
    public static VHIPage voluntaryHealthInsurancePage;


    @BeforeAll
    static void beforeAll() {
        System.out.println("Start tests");
    }

    @BeforeEach
    public void setUp() {
        try {
            String browserName = "webdriver." + getPropertyCustom("browser") + ".driver";
            webDriver = new Driver(browserName).webDriver;
            System.out.println(browserName);
            System.out.println(getPropertyCustom("browser"));
        } catch (NullPointerException ignore) {
        }


        homePage = new HomePage(webDriver);
        voluntaryHealthInsurancePage = new VHIPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        executor = (JavascriptExecutor) webDriver;
        actions = new Actions(webDriver);
        wait = new WebDriverWait(webDriver, 5, 500);
        webDriver.get(ConfigurationProperties.getProperty("homePage"));

    }

    @AfterEach
    void disconnect() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.quit();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finish tests");
    }

    public String getPropertyCustom(String property) {
        String value = System.getProperty(property);
        if (value!=null) {
            return value.toLowerCase();
        } else {
            return value;
        }
    }
}
