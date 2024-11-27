package aqa_course.bo;

import aqa_course.po.UserDeletionPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static aqa_course.driver.DriverPool.getDriver;

public class UserDeletionBO {

    private final UserDeletionPO userDeletionPO;

    public UserDeletionBO() {
        this.userDeletionPO = new UserDeletionPO();
    }

    public void deleteUser(String username) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost/manage_user_page.php");

        wait.until(ExpectedConditions.elementToBeClickable(userDeletionPO.getUserLink(username).getElement())).click();
        wait.until(ExpectedConditions.elementToBeClickable(userDeletionPO.getDeleteButton().getElement())).click();
        wait.until(ExpectedConditions.elementToBeClickable(userDeletionPO.getConfirmDeleteButton().getElement())).click();
    }

    public boolean doesUserExist(String username) {
        WebDriver driver = getDriver();
        driver.get("http://localhost/manage_user_page.php");

        try {
            return userDeletionPO.getUserLink(username).getElement().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}