package pageobject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class ForgotPassPage {

    private static SelenideElement logHrefButton = $x("//a[text()='Войти']");

    @Step("Нажимаем на ссылку \"Войти\"")
    public void clickToLogHrefButton() {
        logHrefButton.shouldBe(Condition.enabled).click();
    }
}
