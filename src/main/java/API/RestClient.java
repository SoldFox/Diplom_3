package API;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static pageObject.PagesUrls.MAIN_PAGE_URL;

public class RestClient {

    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(MAIN_PAGE_URL)
                .build();
    }

    public RequestSpecification getBaseSpecToken(String token) {
        String validToken = token.replaceAll("(Bearer )", "");
        return new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + validToken)
                .setContentType(ContentType.JSON)
                .setBaseUri(MAIN_PAGE_URL)
                .build();
    }
}
