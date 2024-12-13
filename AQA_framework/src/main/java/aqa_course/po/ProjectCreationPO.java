package aqa_course.po;

import aqa_course.driver.DriverPool;
import aqa_course.wrapper.Button;
import aqa_course.wrapper.Input;
import aqa_course.wrapper.Link;
import aqa_course.wrapper.FieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectCreationPO {

    @FindBy(xpath = "//button[text()='Створити новий проєкт']")
    Button createNewProjectButton;

    @FindBy(id = "project-name")
    Input projectNameField;

    @FindBy(id = "project-description")
    Input projectDescriptionField;

    @FindBy(xpath = "//input[@type='submit']")
    Button submitButton;

    public ProjectCreationPO() {
        PageFactory.initElements(new FieldDecorator(DriverPool.getDriver()), this);
    }

    public Button getCreateNewProjectButton() {
        return createNewProjectButton;
    }

    public Input getProjectNameField() {
        return projectNameField;
    }

    public Input getProjectDescriptionField() {
        return projectDescriptionField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public Link getProjectLink(String projectName) {
        WebElement linkElement = DriverPool.getDriver().findElement(By.xpath("//a[text()='" + projectName + "']"));
        return new Link(linkElement);
    }
}
