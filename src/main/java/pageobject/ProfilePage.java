package pageobject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {

    // Локатор кнопки "Выход"
    private SelenideElement exitButton = $x("//button[text()='Выход']");
    // Локатор кнопки "Конструктор"
    private SelenideElement constructorButton = $x("//p[text()='Конструктор']");
    // Локатор логотипа
    private SelenideElement logoButton = $x("//div[@class='AppHeader_header__logo__2D0X2']");

    @Step("Нажимаем на кнопку \"Выход\"")
    public void clickToExitButton() {
        exitButton.shouldBe(Condition.enabled).click();
    }

    @Step("Нажимаем на кнопку \"Конструктор\"")
    public void clickToConstructorButton() {
        constructorButton.shouldBe(Condition.enabled).click();
    }

    @Step("Нажимаем на логотип \"Stella Burgers\"")
    public void clickToLogoButton() {
        logoButton.shouldBe(Condition.enabled).click();
    }

    @Step("Проверяем, что страница профиля пользователя отображается")
    public void checkThatProfilePageIsLoad() {
        exitButton.shouldBe(Condition.visible);
    }
}
