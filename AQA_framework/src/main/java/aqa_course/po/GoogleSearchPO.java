package aqa_course.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static aqa_course.driver.DriverPool.getDriver;

public class GoogleSearchPO {
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "search")
    private WebElement resultsContainer;

    public GoogleSearchPO() {
        PageFactory.initElements(getDriver(), this);
    }

    public void search(String query) {
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    public boolean areResultsDisplayed() {
        return resultsContainer.isDisplayed();
    }
}
