package aqa_course.ui;

import aqa_course.bo.MantisHomePageBO;
import org.testng.Assert;
import org.testng.annotations.Test;

import static aqa_course.driver.DriverPool.getDriver;
public class MantisHomePageTest {
    @Test
    public void testLoginAsAdministrator() {
        getDriver().get("http://localhost/login_page.php");

        MantisHomePageBO mantisHomePageBO = new MantisHomePageBO();
        mantisHomePageBO.loginAsAdministrator("administrator", "root");
        Assert.assertTrue(mantisHomePageBO.isLoginSuccessful(), "Login was not successful!");
    }
}