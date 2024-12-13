package aqa_course.api;

import aqa_course.templates.UserTemplate;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UserApiBO {

    public String login() {
        String loginUrl = "http://localhost/login_page.php";

        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"administrator\", \"password\": \"root\"}")
                .when()
                .post(loginUrl)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token is null after login!");
        return token;
    }

    public String createUser(String token, String username, String email, String realName) {
        String createUserUrl = "http://localhost/api/rest/users";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body("{\"username\": \"" + username + "\", \"email\": \"" + email + "\", \"real_name\": \"" + realName + "\"}")
                .when()
                .post(createUserUrl)
                .then()
                .log().all()
                .statusCode(201)
                .extract().response();

        String userId = response.jsonPath().getString("user.id");
        Assert.assertNotNull(userId, "User ID is null after creation!");
        return userId;
    }

    public UserTemplate getUserById(String token, String userId) {
        String getUserUrl = "http://localhost/api/rest/users/" + userId;

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(getUserUrl)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        return response.as(UserTemplate.class);
    }

    public void updateUser(String token, String userId, String newEmail) {
        String updateUserUrl = "http://localhost/api/rest/users/" + userId;

        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + newEmail + "\"}")
                .when()
                .patch(updateUserUrl)
                .then()
                .log().all()
                .statusCode(200);
    }

    public void deleteUser(String token, String userId) {
        String deleteUserUrl = "http://localhost/api/rest/users/" + userId;

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(deleteUserUrl)
                .then()
                .log().all()
                .statusCode(204);
    }

    public boolean isUserDeleted(String token, String userId) {
        String getUserUrl = "http://localhost/api/rest/users/" + userId;

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(getUserUrl)
                .then()
                .log().all()
                .extract().response();

        return response.statusCode() == 404;
    }
}
