package aqa_course.ui;

import aqa_course.bo.GoogleBO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    @Test
    public void testGoogleSearch() {
        GoogleBO googleBO = new GoogleBO();

        googleBO.search("cakes");
        Assert.assertTrue(googleBO.areResultsDisplayed(), "Search results are not displayed!");
    }
}
