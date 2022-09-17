import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.ForgotPassPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static pageObject.PagesUrls.*;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Проверяем, что можно залогинится через кнопку \"Войти в аккаунт\"")
    public void userCanLoginUsingLogButton() {
        // Дергаем эндпоинт на регистрацию пользователя
        userClient.registration();
        // Открываем главную страницу и создаем экземпляр класса
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        // Кликаем на кнопку "Войти в аккаунт"
        mainPage.clickToLogInAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        // Вводим данные в поля авторизации
        loginPage.login(email, password);
        // Проверяем, что отображается главная страница
        mainPage.checkThatMainPageIsLoad();
    }

    @Test
    @DisplayName("Проверяем, что можно залогинится через кнопку \"Личный кабинет\"")
    public void userCanLoginUsingProfileButton() {
        userClient.registration();
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        // Кликаем на кнопку "Личный кабинет"
        mainPage.clickToProfileButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);
        mainPage.checkThatMainPageIsLoad();
    }

    @Test
    @DisplayName("Проверяем, что можно залогинится через ссылку \"Войти\" на экране регистрации")
    public void userCanLoginUsingHrefButtonInRegistrationForm() {
        userClient.registration();
        // Открываем страницу регистрации
        RegistrationPage registrationPage = open(REGISTRATION_PAGE_URL, RegistrationPage.class);
        // Кликаем ссылку "Войти"
        registrationPage.clickToLogHrefButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);
        MainPage mainPage = page(MainPage.class);
        mainPage.checkThatMainPageIsLoad();
    }

    @Test
    @DisplayName("Проверяем, что можно залогинится через ссылку \"Войти\" на экране восстановлния пароля")
    public void userCanLoginUsingHrefButtonInForgotPassForm() {
        userClient.registration();
        // Открываем страницу Восстановление пароля
        ForgotPassPage forgotPassPage = open(FORGOT_PASS_PAGE_URL, ForgotPassPage.class);
        // Кликаем на ссылку "Войти"
        forgotPassPage.clickToLogHrefButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(email, password);
        MainPage mainPage = page(MainPage.class);
        mainPage.checkThatMainPageIsLoad();
    }
}
