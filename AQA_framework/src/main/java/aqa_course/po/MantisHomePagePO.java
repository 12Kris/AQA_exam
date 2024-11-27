package aqa_course.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static aqa_course.driver.DriverPool.getDriver;

public class MantisHomePagePO {
    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Увійти']")
    WebElement firstLoginButton;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Увійти']")
    WebElement finalLoginButton;

    public MantisHomePagePO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getFirstLoginButton() {
        return firstLoginButton;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getFinalLoginButton() {
        return finalLoginButton;
    }
}