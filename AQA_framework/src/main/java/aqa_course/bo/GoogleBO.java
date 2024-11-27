package aqa_course.bo;

import aqa_course.po.GoogleSearchPO;

import static aqa_course.driver.DriverPool.getDriver;

public class GoogleBO {
    private final GoogleSearchPO googleSearchPO;

    public GoogleBO() {
        this.googleSearchPO = new GoogleSearchPO();
    }

    public GoogleBO search(String query) {
        getDriver().get("https://www.google.com/");

        googleSearchPO.search(query);

        return this;
    }

    public boolean areResultsDisplayed() {
        return googleSearchPO.areResultsDisplayed();
    }
}
