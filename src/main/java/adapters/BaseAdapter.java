package adapters;

import com.google.gson.Gson;
import constants.IAdapterConstants;
import constants.IUrlConstants;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IUrlConstants, IAdapterConstants {

    Gson converter = new Gson();

    /**
     * Get request.
     *
     * @param url the url
     * @return the string
     */
    public String get(String url) {
        return
        given()
            .header(TOKEN_KEY, TOKEN_VALUE)
            .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
        .when()
            .get(BASE_URL + url)
        .then()
            .log().all()
            .extract().body().asString();
    }

    /**
     * Post request.
     *
     * @param url  the url
     * @param body the body
     * @return the string
     */
    public String post(String url, String body) {
        return
        given()
            .header(TOKEN_KEY, TOKEN_VALUE)
            .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
            .body(body)
        .when()
            .post(BASE_URL + url)
        .then()
            .log().all()
            .extract().body().asString();
    }

    /**
     * Delete request.
     *
     * @param url the url
     * @return the string
     */
    public String delete(String url) {
        return
        given()
            .header(TOKEN_KEY, TOKEN_VALUE)
            .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
        .when()
            .delete(BASE_URL + url)
        .then()
            .log().all()
            .extract().body().asString();
    }
}