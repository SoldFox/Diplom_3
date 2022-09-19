import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static pageobject.PagesUrls.LOGIN_PAGE_URL;

public class ProfileNavigationTest extends BaseTest {

    @Test
    @DisplayName("Проверяем, что авторизованный пользователь может перейти на страницу профиля кликнув на кнопку \"Личный кабинет\"")
    public void userCanGoToProfileAfterClickOnProfileButton() {
        // Дергаем эндпоинты на регистрацию пользователя
        userClient.registration();
        // Открываем страницу авторизации и логинимся
        LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(email, password);

        MainPage mainPage = page(MainPage.class);
        // Кликаем на кнопку "Личный кабинет"
        mainPage.clickToProfileButton();
        ProfilePage profilePage = page(ProfilePage.class);
        // Проверяем, что отображается страница профиля пользователя
        profilePage.checkThatProfilePageIsLoad();
    }

    @Test
    @DisplayName("Проверяем, что можно перейти на главную страницу кликнув на логотип \"Stella Burgers\"")
    public void userCanGoToMainPageAfterClickOnLogoInProfilePage() {
        // Дергаем эндпоинты на регистрацию пользователя
        userClient.registration();
        // Открываем страницу авторизации и логинимся
        LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(email, password);

        MainPage mainPage = page(MainPage.class);
        mainPage.clickToProfileButton();
        ProfilePage profilePage = page(ProfilePage.class);
        // Кликаем на логотип
        profilePage.clickToLogoButton();
        // Проверяем, что отображается главная страница
        mainPage.checkThatMainPageIsLoad();
    }

    @Test
    @DisplayName("Проверяем, что можно перейти на главную страницу кликнув на кнопку \"Конструктор\"")
    public void userCanGoToMainPageAfterClickOnConstructorInProfilePage() {
        // Дергаем эндпоинты на регистрацию пользователя
        userClient.registration();
        // Открываем страницу авторизации и логинимся
        LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(email, password);

        MainPage mainPage = page(MainPage.class);
        mainPage.clickToProfileButton();
        ProfilePage profilePage = page(ProfilePage.class);
        // Кликаем на иконку конструктора
        profilePage.clickToConstructorButton();
        // Проверяем, что отображается главная страница
        mainPage.checkThatMainPageIsLoad();
    }

    @Test
    @DisplayName("Проверяем, что можно выйти из аккаунта кликнув на кнопку \"Выход\"")
    public void userCanLogoutAfterClickOnExitButtonInProfilePage() {
        userClient.registration();
        LoginPage loginPage = open(LOGIN_PAGE_URL, LoginPage.class);
        loginPage.login(email, password);

        MainPage mainPage = page(MainPage.class);
        mainPage.clickToProfileButton();
        ProfilePage profilePage = page(ProfilePage.class);
        // Кликаем на кнопку выхода
        profilePage.clickToExitButton();
        // Проверяем, что отображается страница авторизации
        loginPage.checkingThatLoginPageIsLoad();
    }
}
