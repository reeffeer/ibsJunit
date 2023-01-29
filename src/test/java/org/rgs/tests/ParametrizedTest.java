package org.rgs.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.rgs.utils.ValueGenerator;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ParametrizedTest extends BaseTests{

    @ParameterizedTest
    @MethodSource("names")
    @DisplayName("Parametrized test with 3 sets of names")
    void parametrizedTest(String name) {
        wait.until(ExpectedConditions.visibilityOf(homePage.getCookieCloseButton()));
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Проверить, загрузилась ли страница:
        Assertions.assertTrue(homePage.getRgsHeader().isDisplayed(), "Страница не загружена");

        //Закрыть cookie:
        homePage.closeCookie();

        //Выбрать Меню: Компаниям:
        homePage.clickCompanyButton();

        //Закрыть всплывающее окно:
        homePage.closeFrame();
        Assertions.assertFalse(homePage.getFrame().isDisplayed(), "Всплывающее окно не закрыто");

        //Проверить, был ли осуществлен переход в меню "Компаниям":
        Assertions.assertTrue(homePage.getCompanyMenuButton().getAttribute("class").contains("active"), "Выбор раздела \"Компаниям\" не осуществлен");

        //Выбрать Меню: Здоровье:
        homePage.clickHealthMenuButton();

        //Проверить, был ли осуществлен переход в меню "Здоровье":
        Assertions.assertTrue(homePage.getHealthMenuPresence().getAttribute("class").contains("active"), "Выбор раздела \"Здоровье\" не осуществлен");

        //Выбрать Меню: Добровольное медицинское страхование:
        homePage.clickVoluntaryInsuranceButton();


        //Проверить наличие заголовка – Добровольное медицинское страхование:
        Assertions.assertEquals("Добровольное медицинское страхование", voluntaryHealthInsurancePage.getVHIHeader().getText(),"Заголовок не совпадает");

        //Нажать на кнопку – Отправить заявку:
        Assertions.assertTrue(voluntaryHealthInsurancePage.getSendReqButton().isDisplayed(), "Кнопка не отображена");
        voluntaryHealthInsurancePage.clickSendRequestButton();

        //Проверить видимость формы для заполнения:
        Assertions.assertAll("Видимость полей ввода",
                () -> Assertions.assertTrue(voluntaryHealthInsurancePage.getUserNameField().isDisplayed(), "Поле ввода имени отсутствует"),
                () -> Assertions.assertTrue(voluntaryHealthInsurancePage.getUserPhoneField().isDisplayed(), "Поле ввода телефона отсутствует"),
                () -> Assertions.assertTrue(voluntaryHealthInsurancePage.getUserEmailField().isDisplayed(), "Поле ввода адреса почты отсутствует"),
                () -> Assertions.assertTrue(voluntaryHealthInsurancePage.getAddressInputField().isDisplayed(), "Поле ввода адреса отсутствует")
        );

        //Заполнить поля:
        voluntaryHealthInsurancePage.fillUserNameField(name);

        String phone = ValueGenerator.randomPhoneNumberGenerator();
        voluntaryHealthInsurancePage.fillUserPhoneField(phone);

        String email = "qwertyqwerty";
        voluntaryHealthInsurancePage.fillUserEmailField(email);

        String address = ValueGenerator.randomAddressGenerator();
        voluntaryHealthInsurancePage.fillUserAddressField(address);

        //Проверить, что все поля заполнены введенными значениями
        Assertions.assertAll(
                () -> Assertions.assertEquals(name, voluntaryHealthInsurancePage.getUserNameField().getAttribute("value"),
                        "Введенное в поле ФИО не соответствует заданному"),
                () -> Assertions.assertEquals("+7".concat(phone), voluntaryHealthInsurancePage.getUserPhoneField().getAttribute("value")
                                .replaceAll("[\\p{Punct}&&[^+]']+", "").replaceAll("\\s", ""),
                        "Введенный в поле номер не соответствует заданному"),
                () -> Assertions.assertEquals(email, voluntaryHealthInsurancePage.getUserEmailField().getAttribute("value"),
                        "Введенный в поле адрес почты не соответствует заданному"),
                () -> Assertions.assertEquals(address, voluntaryHealthInsurancePage.getAddressInputField().getAttribute("value"),
                        "Введенный в поле адрес не соответствует заданному")
        );

        //Поставить галочку в чекбоксе "Я согласен на обработку":
        voluntaryHealthInsurancePage.checkBoxActivation();

        //Нажать "Свяжитесь со мной"
        voluntaryHealthInsurancePage.clickSubmitButton();

        //Проверить, что кнопка "Свяжитесь со мной" неактивна"
        Assertions.assertFalse(voluntaryHealthInsurancePage.getDisabledSubmitButton().isEnabled(), "Кнопка все еще активна");

        //Проверить, что у поля – Эл. почта присутствует сообщение об ошибке – "Введите корректный адрес электронной почты"
        Assertions.assertEquals("Введите корректный адрес электронной почты",
                voluntaryHealthInsurancePage.getEmailErrorMessage().getText(), "Сообщение о неверно введенном адресе почты отсутствует");

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static Stream<String> names() {
        String name1 = ValueGenerator.randomNameGenerator();
        String name2 = ValueGenerator.randomNameGenerator();
        String name3 = ValueGenerator.randomNameGenerator();
        return Stream.of(name1, name2, name3);
    }
}
