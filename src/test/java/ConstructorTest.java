import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static pageobject.PagesUrls.MAIN_PAGE_URL;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверяем, что можно перейти к разделу бургеров кликнув на кнопку \"Бургер\"")
    public void checkTransitionOnSectionBurger() {
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.clickToFillingsButton();
        mainPage.clickToBunButton();
        mainPage.checkBunAttributeText();
    }

    @Test
    @DisplayName("Проверяем, что можно перейти к разделу соусов кликнув на кнопку \"Соусы\"")
    public void checkTransitionOnSectionSauce() {
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.clickToSauceButton();
        mainPage.checkSauceAttributeText();
    }

    @Test
    @DisplayName("Проверяем, что можно перейти к разделу начинки кликнув на кнопку \"Начинки\"")
    public void checkTransitionOnSectionFillings() {
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.clickToFillingsButton();
        mainPage.checkFillingsAttributeText();
    }
}
