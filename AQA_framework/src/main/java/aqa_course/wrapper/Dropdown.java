package aqa_course.wrapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends Element {

    private final Select select;

    public Dropdown(WebElement webElement) {
        super(webElement);
        this.select = new Select(webElement);
    }

    public void selectByVisibleText(String text) {
        System.out.println("Selecting option with visible text: " + text);
        select.selectByVisibleText(text);
    }

    public void selectByValue(String value) {
        System.out.println("Selecting option with value: " + value);
        select.selectByValue(value);
    }

    public void selectByIndex(int index) {
        System.out.println("Selecting option by index: " + index);
        select.selectByIndex(index);
    }

    public String getSelectedOption() {
        return select.getFirstSelectedOption().getText();
    }
}