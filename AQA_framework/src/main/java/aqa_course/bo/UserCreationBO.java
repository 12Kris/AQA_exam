package aqa_course.bo;

import aqa_course.po.UserCreationPO;

public class UserCreationBO {
    private final UserCreationPO userCreationPO;

    public UserCreationBO() {
        userCreationPO = new UserCreationPO();
    }

    public void createUser(String username, String realname, String email) {
        userCreationPO.getInviteUsersButton().click();
        userCreationPO.getUsernameInput().sendKeys(username);
        userCreationPO.getRealnameInput().sendKeys(realname);
        userCreationPO.getEmailInput().sendKeys(email);
        userCreationPO.getCreateRecordButton().click();
    }
}