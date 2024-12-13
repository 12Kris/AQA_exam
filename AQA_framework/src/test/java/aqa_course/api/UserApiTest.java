package aqa_course.api;

import aqa_course.templates.UserTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserApiTest {

    private UserApiBO userApiBO;
    private String token;

    @BeforeClass
    public void setup() {
        System.out.println("Initializing setup for CreateUserTest...");
        userApiBO = new UserApiBO();
        token = userApiBO.login();
        Assert.assertNotNull(token, "Login failed: Token is null!");
    }

    @Test
    public void testCreateUser() {
        String username = "createUser";
        String email = "createuser@example.com";
        String realName = "Create User";

        String userId = userApiBO.createUser(token, username, email, realName);
        Assert.assertNotNull(userId, "Failed to create user!");

        UserTemplate fetchedUser = userApiBO.getUserById(token, userId);
        Assert.assertNotNull(fetchedUser, "Failed to fetch created user!");
        Assert.assertEquals(fetchedUser.getUsername(), username, "Username mismatch!");
        Assert.assertEquals(fetchedUser.getEmail(), email, "Email mismatch!");
        Assert.assertEquals(fetchedUser.getRealName(), realName, "Real name mismatch!");

        System.out.println("Create user test passed!");
    }
}
