package org.rgs.pages;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.rgs.tests.BaseTests;

import java.util.concurrent.TimeUnit;

@Getter
public class HomePage extends BaseTests {
    @FindBy(xpath = "//div[@class=\"logotype\"]")
    private WebElement rgsHeader;
    @FindBy(xpath = "//button[@class=\"btn--text\"]")
    private WebElement cookieCloseButton;
    @FindBy(xpath = "//a[contains(text(), 'Компаниям')]")
    private WebElement companyMenuButton;
    @FindBy(xpath = "//iframe[@id=\"fl-616371\"]")
    private WebElement frame;
    @FindBy(xpath = "//div[@data-fl-track=\"click-close-login\"]")
    private WebElement frameCloseButton;
    @FindBy(xpath = "//span[contains(text(), 'Здоровье')]")
    private WebElement healthMenuButton;
    @FindBy(xpath = "//span[contains(text(), 'Здоровье')]/..")
    private WebElement healthMenuPresence;
    @FindBy(xpath = "//a[contains(text(), 'Добровольное медицинское страхование')]")
    private WebElement voluntaryHealthInsurance;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(BaseTests.webDriver, this);
        BaseTests.webDriver = webDriver;
    }

    public void closeCookie() {
        try {
            cookieCloseButton.click();
        } catch (NoSuchElementException ignore) {
        } finally {
            webDriver.switchTo().defaultContent();
        }
    }

    public void clickCompanyButton() {
        companyMenuButton.click();
    }

    public void closeFrame() {
        try {
            wait.until(ExpectedConditions.visibilityOf(frame));
            webDriver.switchTo().frame(frame);
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            actions.click(frameCloseButton).perform();
        } catch (NoSuchElementException ignore) {
        } finally {
            webDriver.switchTo().defaultContent();
        }
    }

    public void clickHealthMenuButton() {
        healthMenuButton.click();
    }

    public void clickVoluntaryInsuranceButton() {
        voluntaryHealthInsurance.click();
    }
}
