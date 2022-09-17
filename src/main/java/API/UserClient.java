package API;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class UserClient extends RestClient{

    private static final String REGISTRATION_URL = "/api/auth/register";
    private static final String DELETE_URL = "/api/auth/user";
    private static final String LOGIN_URL = "/api/auth/login";

    public void registration() {
        String email = "Tora1234@yandex.ru";
        String password = "qwerty";
        String name = "Tora";
        // Создаем коллекцию для запроса
        HashMap<String, String> request = new HashMap<>();
        request.put("email", email);
        request.put("password", password);
        request.put("name", name);

        // Сохраняем ответ в виде класса UserCredentialsResponse
        UserCredentialsResponse response = given()
                .spec(getBaseSpec())
                .body(request)
                .when()
                .post(REGISTRATION_URL)
                .body()
                .as(UserCredentialsResponse.class);

        // Присваеваем токены из ответа
        Tokens.setAccessToken(response.getAccessToken());
        Tokens.setRefreshToken(response.getRefreshToken());
    }

    public void deleteUser(String token) {
        given()
                .spec(getBaseSpecToken(token))
                .when()
                .delete(DELETE_URL)
                .then().log().body();
    }

    public void login(String email, String password) {
        HashMap<String, String> newUser = new HashMap<>();
        newUser.put("email", email);
        newUser.put("password", password);

        UserCredentialsResponse response = given()
                .spec(getBaseSpec())
                .body(newUser)
                .when()
                .post(LOGIN_URL)
                .body()
                .as(UserCredentialsResponse.class);

        // Присваеваем токены из ответа
        Tokens.setAccessToken(response.getAccessToken());
        Tokens.setRefreshToken(response.getRefreshToken());
    }
}
