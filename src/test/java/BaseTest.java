import API.Tokens;
import API.UserClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {

    protected String name = UserGenerator.getName();
    protected String email = UserGenerator.getEmail();
    protected String password = UserGenerator.getPassword();
    protected String incorrectPassword = UserGenerator.getIncorrectPassword();

    UserClient userClient;
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Before
    public void init() {
        setUp();
        userClient = new UserClient();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
        if (Tokens.getAccessToken() == null) {
            System.out.println("Access token is null - user can't be deleted. Maybe user hasn't been created");
        } else {
            userClient.deleteUser(Tokens.getAccessToken());
        }
    }
}
