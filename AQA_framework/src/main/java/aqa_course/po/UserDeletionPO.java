package aqa_course.po;

import aqa_course.driver.DriverPool;
import aqa_course.wrapper.Button;
import aqa_course.wrapper.FieldDecorator;
import aqa_course.wrapper.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDeletionPO {

    private final WebDriver driver;

    public UserDeletionPO() {
        this.driver = DriverPool.getDriver();
        PageFactory.initElements(new FieldDecorator(driver), this);
    }

    public Link getUserLink(String username) {
        return new Link(driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]")));
    }

    @FindBy(xpath = "//button[@formaction='manage_user_delete.php']")
    private Button deleteButton;

    @FindBy(xpath = "//input[@type='submit' and @value='Видалити запис']")
    private Button confirmDeleteButton;

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getConfirmDeleteButton() {
        return confirmDeleteButton;
    }
}
