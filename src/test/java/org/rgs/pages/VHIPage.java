package org.rgs.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.rgs.tests.BaseTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
public class VHIPage extends BaseTests {

    @FindBy(xpath = "//h1[contains(text(), 'Добровольное медицинское страхование')]")
    private WebElement vHIHeader;
    @FindBy(xpath = "//a[@class=\"action-item btn--basic\"]")
    private WebElement sendReqButton;
    @FindBy(xpath = "//input[@name=\"userName\"]")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@name=\"userTel\"]")
    private WebElement userPhoneField;
    @FindBy(xpath = "//input[@name=\"userEmail\"]")
    private WebElement userEmailField;
    @FindBy(xpath = "//input[@class=\"vue-dadata__input\"]")
    private WebElement addressInputField;
    @FindBy(xpath = "//div[@class=\"vue-dadata__suggestions\"]")
    private WebElement addressDropDown;
    @FindBy(xpath = "//input[@type=\"checkbox\"]/..")
    private WebElement checkBox;
    @FindBy(xpath = "//button[contains(text(), 'Свяжитесь со мной')]")
    private WebElement submitButton;
    @FindBy(xpath = "//span[contains(text(), 'Введите корректный адрес электронной почты')]")
    private WebElement emailErrorMessage;
    @FindBy(xpath = "//button[@class=\"form__button-submit btn--basic btn--disabled\"]")
    private WebElement disabledSubmitButton;

    public VHIPage(WebDriver driver) {
        PageFactory.initElements(BaseTests.webDriver, this);
        BaseTests.webDriver = driver;
    }

    public void clickSendRequestButton() {
        actions.click(sendReqButton).perform();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void fillUserNameField(String fio) {
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(fio);
    }

    public void fillUserPhoneField(String tel) {
        wait.until(ExpectedConditions.visibilityOf(userPhoneField));
        userPhoneField.sendKeys(tel);
    }

    public void fillUserEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOf(userPhoneField));
        userEmailField.sendKeys(email);
    }

    public void fillUserAddressField(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressInputField));
        addressInputField.sendKeys(address);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> dropDownList = webDriver.findElements(By.xpath("//span[@class='vue-dadata__suggestions-item']"));
        dropDownList.get(0).submit();
    }

    public void checkBoxActivation() {
        executor.executeScript("arguments[0].scrollIntoView(true);", checkBox);
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        executor.executeScript("arguments[0].click();", checkBox);
    }

    public void clickSubmitButton() {
        submitButton.submit();
    }
}
