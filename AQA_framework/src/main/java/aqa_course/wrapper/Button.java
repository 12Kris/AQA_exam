package aqa_course.wrapper;

import org.openqa.selenium.WebElement;

public class Button extends Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        System.out.println("Clicking button: " + getElement());
        getElement().click();
    }
}
