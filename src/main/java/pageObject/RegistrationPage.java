package pageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {

    // Локаторы Полей ввода
    private SelenideElement nameField = $x("//fieldset[1]/div/div/input");
    private SelenideElement emailField = $x("//fieldset[2]/div/div/input");
    private SelenideElement passwordField = $x("//fieldset[3]/div/div/input");

    // Локатор текста Некорректный пароль
    private SelenideElement incorrectPasswordText = $x("//p[@class='input__error text_type_main-default']");

    // Локатор кнопки Зарегистрироваться
    private SelenideElement registrationButton = $x("//button[text()='Зарегистрироваться']");

    // Href ссылка Войти
    private SelenideElement logHrefButton = $x("//a[text()='Войти']");

    @Step("Вводим данные в поле \"Имя\"")
    public void setNameField (String name) {
        nameField.shouldBe(Condition.enabled).setValue(name);
    }

    @Step("Вводим данные в поле \"Email\"")
    public void setEmailField (String email) {
        emailField.shouldBe(Condition.enabled).setValue(email);
    }

    @Step("Вводим данные в поле \"Пароль\"")
    public void setPasswordField (String password) {
        passwordField.shouldBe(Condition.enabled).setValue(password);
    }

    @Step("Кликаем по кнопке  \"Зарегистрироваться\"")
    public void clickToRegistrationButton() {
        registrationButton.shouldBe(Condition.enabled).click();
    }

    public void registration(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickToRegistrationButton();
    }

    @Step("Проверяем, что отображается текст \"Некорректный пароль\"")
    public void checkTheIncorrectPasswordTextForVisibility() {
        Assert.assertEquals("Некорректный пароль", incorrectPasswordText.shouldBe(Condition.visible).getText());
    }

    @Step("Нажимаем на ссылку \"Войти\"")
    public void clickToLogHrefButton() {
        logHrefButton.shouldBe(Condition.enabled).click();
    }
}
