package pageobject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    // Локаторы полей ввода
    private SelenideElement emailField = $x("//input[@type = 'text']");
    private SelenideElement passwordField = $x("//input[@type = 'password']");

    // Локатор кнопки "Войти"
    private SelenideElement logButton = $x("//button[text()='Войти']");

    @Step("Вводим данные в поле \"Email\"")
    public void setEmailField(String text) {
        emailField.shouldBe(Condition.enabled).setValue(text);
    }

    @Step("Вводим данные в поле \"Пароль\"")
    public void setPasswordField(String text) {
        passwordField.shouldBe(Condition.enabled).setValue(text);
    }

    @Step("Нажимаем на кнопку \"Войти\"")
    public void clickToLogButton() {
        logButton.shouldBe(Condition.enabled).click();
    }

    public void login(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickToLogButton();
    }

    @Step("Проверяем, что отображается страница логина")
    public void checkingThatLoginPageIsLoad() {
        emailField.shouldBe(Condition.visible);
        passwordField.shouldBe(Condition.visible);
        logButton.shouldBe(Condition.visible);
    }
}
