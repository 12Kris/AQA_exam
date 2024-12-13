package aqa_course.ui;

import aqa_course.bo.MantisHomePageBO;
import aqa_course.bo.ProjectCreationBO;
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

public class ProjectCreationTest {

    @BeforeMethod
    public void setUp() {
        DriverPool.getDriver().get("http://localhost/login_page.php");

        MantisHomePageBO mantisHomePageBO = new MantisHomePageBO();
        mantisHomePageBO.loginAsAdministrator("administrator", "root");

        Assert.assertTrue(mantisHomePageBO.isLoginSuccessful(), "Login was not successful!");

        DriverPool.getDriver().get("http://localhost/manage_proj_page.php");
    }

    @Test
    public void testProjectCreation() {
        WebDriverWait wait = new WebDriverWait(DriverPool.getDriver(), Duration.ofSeconds(10));

        WebElement createProjectButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'btn-primary') and contains(@class, 'btn-white') and contains(@class, 'btn-round')]")
        ));
        createProjectButton.click();

        ProjectCreationBO projectCreationBO = new ProjectCreationBO();
        String projectName = "TestProject";
        String projectDescription = "This is a test project.";

        projectCreationBO.createProject(projectName, projectDescription);
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
