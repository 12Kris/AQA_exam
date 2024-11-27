package aqa_course.ui;

import aqa_course.bo.MantisHomePageBO;
import aqa_course.bo.UserCreationBO;
import aqa_course.driver.DriverPool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserCreationTest {

    @BeforeMethod
    public void setUp() {
        DriverPool.getDriver().get("http://localhost/login_page.php");

        MantisHomePageBO mantisHomePageBO = new MantisHomePageBO();
        mantisHomePageBO.loginAsAdministrator("administrator", "root");

        Assert.assertTrue(mantisHomePageBO.isLoginSuccessful(), "Login was not successful!");

        DriverPool.getDriver().get("http://localhost/manage_user_create_page.php");
    }

    @Test
    public void testUserCreation() {
        WebDriverWait wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));

        WebElement inviteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='manage_user_create_page.php']")
        ));
        inviteButton.click();

        UserCreationBO userCreationBO = new UserCreationBO();
        userCreationBO.createUser("Vadim24", "Vadim Novosad", "vadim.nov@gmail.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}