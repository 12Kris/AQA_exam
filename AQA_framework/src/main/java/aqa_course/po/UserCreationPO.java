package aqa_course.po;

import aqa_course.driver.DriverPool;
import aqa_course.wrapper.Button;
import aqa_course.wrapper.Input;
import aqa_course.wrapper.Link;
import aqa_course.wrapper.FieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCreationPO {

    @FindBy(xpath = "//a[@href='manage_user_create_page.php']")
    Link inviteUsersButton;

    @FindBy(id = "user-username")
    Input usernameInput;

    @FindBy(id = "user-realname")
    Input realnameInput;

    @FindBy(id = "email-field")
    Input emailInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Створити запис']")
    Button createRecordButton;

    public UserCreationPO() {
        PageFactory.initElements(new FieldDecorator(DriverPool.getDriver()), this);
    }

    public Link getInviteUsersButton() {
        return inviteUsersButton;
    }

    public Input getUsernameInput() {
        return usernameInput;
    }

    public Input getRealnameInput() {
        return realnameInput;
    }

    public Input getEmailInput() {
        return emailInput;
    }

    public Button getCreateRecordButton() {
        return createRecordButton;
    }
}