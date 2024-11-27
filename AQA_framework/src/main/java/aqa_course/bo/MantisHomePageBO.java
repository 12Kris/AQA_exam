package aqa_course.bo;

import aqa_course.po.MantisHomePagePO;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static aqa_course.driver.DriverPool.getDriver;

public class MantisHomePageBO {
    private final MantisHomePagePO mantisHomePagePO;

    public MantisHomePageBO() {
        mantisHomePagePO = new MantisHomePagePO();
    }

    public void loginAsAdministrator(String username, String password) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(mantisHomePagePO.getUsernameInput()));
        mantisHomePagePO.getUsernameInput().sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(mantisHomePagePO.getFirstLoginButton()));
        mantisHomePagePO.getFirstLoginButton().click();

        wait.until(ExpectedConditions.visibilityOf(mantisHomePagePO.getPasswordInput()));
        mantisHomePagePO.getPasswordInput().sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(mantisHomePagePO.getFinalLoginButton()));
        mantisHomePagePO.getFinalLoginButton().click();
    }

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String title = getDriver().getTitle();
        System.out.println("Current Page Title: " + title);
        return wait.until(ExpectedConditions.titleContains("Мій запис"));
    }
}
