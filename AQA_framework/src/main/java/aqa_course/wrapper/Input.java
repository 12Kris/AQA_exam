package aqa_course.wrapper;

import org.openqa.selenium.WebElement;

public class Input extends Element {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        System.out.println("Typing text '" + text + "' into input: " + getElement());
        getElement().sendKeys(text);
    }

    public void clearText() {
        System.out.println("Clearing input field: " + getElement());
        getElement().clear();
    }
}
