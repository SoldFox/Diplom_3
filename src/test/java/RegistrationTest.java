import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static pageobject.PagesUrls.*;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Проверяем, что можно зарегистрироваться используя валидные данные")
    public void userCanBeRegistered() {
        // Создаем экземпляр класса и открываем страницу регистрации
        RegistrationPage registrationPage = open(REGISTRATION_PAGE_URL, RegistrationPage.class);
        // Заполняем поля и нажимаем кнопку регистрации
        registrationPage.registration(name, email, password);

        LoginPage loginPage = page(LoginPage.class);
        // Проверяем, что отображается страница логина
        loginPage.checkingThatLoginPageIsLoad();
        // Дергаем ручку логина, чтобы получить токен для удаления
        userClient.login(email, password);
    }

    @Test
    @DisplayName("Проверяем, что отображается сообщение \"Некорректный пароль\", при вводе невалидного пароля")
    public void theIncorrectPasswordTextCanBeDisplayed() {
        RegistrationPage registrationPage = open(REGISTRATION_PAGE_URL, RegistrationPage.class);
        // Заполняем поле и нажимаем кнопку регистрации
        registrationPage.setPasswordField(incorrectPassword);
        registrationPage.clickToRegistrationButton();
        // Провряем что отображается текст "Некорректный пароль"
        registrationPage.checkTheIncorrectPasswordTextForVisibility();
    }
}
