package aqa_course.bo;

import aqa_course.po.ProjectCreationPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static aqa_course.driver.DriverPool.getDriver;

public class ProjectCreationBO {

    private final ProjectCreationPO projectCreationPO;

    public ProjectCreationBO() {
        this.projectCreationPO = new ProjectCreationPO();
    }

    public void createProject(String projectName, String description) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost/manage_proj_page.php");

        wait.until(ExpectedConditions.elementToBeClickable(projectCreationPO.getCreateNewProjectButton().getElement())).click();
        wait.until(ExpectedConditions.visibilityOf(projectCreationPO.getProjectNameField().getElement())).sendKeys(projectName);
        wait.until(ExpectedConditions.visibilityOf(projectCreationPO.getProjectDescriptionField().getElement())).sendKeys(description);
        wait.until(ExpectedConditions.elementToBeClickable(projectCreationPO.getSubmitButton().getElement())).click();
    }

    public boolean isProjectCreated(String projectName) {
        WebDriver driver = getDriver();
        driver.get("http://localhost/manage_projects_page.php");

        try {
            return projectCreationPO.getProjectLink(projectName).getElement().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
