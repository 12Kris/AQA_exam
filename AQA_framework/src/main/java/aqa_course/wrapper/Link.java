package aqa_course.wrapper;

import org.openqa.selenium.WebElement;

public class Link extends Element {

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        System.out.println("Clicking link: " + getElement());
        getElement().click();
    }
}