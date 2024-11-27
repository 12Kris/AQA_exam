package aqa_course.ui;

import aqa_course.bo.MantisHomePageBO;
import aqa_course.bo.UserCreationBO;
import aqa_course.bo.UserDeletionBO;
import aqa_course.driver.DriverPool;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserDeletionTest {

    @BeforeMethod
    public void setUp() {
        DriverPool.getDriver().get("http://localhost/login_page.php");

        MantisHomePageBO mantisHomePageBO = new MantisHomePageBO();
        mantisHomePageBO.loginAsAdministrator("administrator", "root");

        Assert.assertTrue(mantisHomePageBO.isLoginSuccessful(), "Login was not successful!");
    }

    @Test
    public void testDeleteUser() {
        UserCreationBO userCreationBO = new UserCreationBO();
        UserDeletionBO userDeletionBO = new UserDeletionBO();

        if (!userDeletionBO.doesUserExist("Vadim24")) {
            userCreationBO.createUser("Vadim24", "Vadim Novosad", "vadim.nov@gmail.com");
        }

        userDeletionBO.deleteUser("Vadim24");
        Assert.assertFalse(userDeletionBO.doesUserExist("Vadim24"), "User was not deleted!");
    }


    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}