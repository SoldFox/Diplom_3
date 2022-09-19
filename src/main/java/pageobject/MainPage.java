package pageobject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Локаторы кнопок
    private SelenideElement profileButton = $x("//p[text()='Личный Кабинет']");
    private SelenideElement logInAccountButton = $x("//button[text()='Войти в аккаунт']");
    private SelenideElement checkoutButton = $x("//button[text()='Оформить заказ']");

    // Локатор всего раздела конструктора
    private SelenideElement bunButton = $x("//div[@style='display: flex;']/div[1]");

    // Локаторы разделов конструктора
    private ElementsCollection constructor = $$x("//div[@style='display: flex;']/div");
    private SelenideElement sauceButton = $x("//div[@style='display: flex;']/div[2]");
    private SelenideElement fillingsButton = $x("//div[@style='display: flex;']/div[3]");

    // Ожидаемый текст аттрибута "Class" для активного раздела конструктора
    private String currentClassAttributeValue = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    @Step("Нажимаем на кнопку \"Личный кабинет\"")
    public void clickToProfileButton() {
        profileButton.shouldBe(Condition.enabled).click();
    }

    @Step("Нажимаем на кнопку \"Войти в аккаунт\"")
    public void clickToLogInAccountButton() {
        logInAccountButton.shouldBe(Condition.enabled).click();
    }

    @Step("Нажимаем на раздел \"Булки\"")
    public void clickToBunButton() {
        bunButton.shouldBe(Condition.enabled).click();
    }

    @Step("Нажимаем на раздел \"Соусы\"")
    public void clickToSauceButton() {
        sauceButton.shouldBe(Condition.enabled).click();
    }

    @Step("Нажимаем на раздел \"Начинки\"")
    public void clickToFillingsButton() {
        fillingsButton.shouldBe(Condition.enabled).click();
    }

    public String getTextFromClassAttribute(int i) {
        return constructor.get(i).getAttribute("class");
    }

    @Step("Проверяем, что раздел \"Булки\" отображается на экране (является \"текущим\" разделом)")
    public void checkBunAttributeText() {
        Assert.assertEquals(currentClassAttributeValue, getTextFromClassAttribute(0)); // 0 - позиция булочек в коллекции "конструктора"- constructor
    }

    @Step("Проверяем, что раздел \"Соусы\" отображается на экране (является \"текущим\" разделом)")
    public void checkSauceAttributeText() {
        Assert.assertEquals(currentClassAttributeValue, getTextFromClassAttribute(1)); // 1 - позиция соусов в коллекции "конструктора"- constructor
    }

    @Step("Проверяем, что раздел \"Начинки\" отображается на экране (является \"текущим\" разделом)")
    public void checkFillingsAttributeText() {
        Assert.assertEquals(currentClassAttributeValue, getTextFromClassAttribute(2)); // 2 - позиция начинки в коллекции "конструктора"- constructor
    }

    @Step("Проверяем, что отображается главная страница")
    public void checkThatMainPageIsLoad() {
        checkoutButton.shouldBe(Condition.visible);
        profileButton.shouldBe(Condition.visible);
    }
}
