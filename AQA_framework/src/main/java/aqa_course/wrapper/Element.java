package aqa_course.wrapper;

import org.openqa.selenium.WebElement;

public class Element {
    private final WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getElement() {
        return webElement;
    }
}
