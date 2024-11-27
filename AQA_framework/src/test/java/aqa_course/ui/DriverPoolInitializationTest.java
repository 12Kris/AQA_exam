package aqa_course.ui;

import aqa_course.driver.DriverPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DriverPoolInitializationTest {
    @Test
    void TestMethod1(){
        DriverPool.getDriver().get("https://example.com");
        System.out.println(DriverPool.getDriver().getTitle());
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
