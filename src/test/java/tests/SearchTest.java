package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends CoreTestCase {

    @Test
    public void testFindJava() {
        MainPageObject mainPO = new MainPageObject(this.driver);
        WebElement searchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input");
        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find Search... input");
        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPO.waitForElementPresent(
                "xpath://*[./*[contains(@text, \"Island of Indonesia\")]]",
                "Cannot find result 'Island of Indonesia' on 'Java' search");
        expectedResult.click();

        System.out.println("Success");
    }

    @Test
    public void testFindNonExistentText() {
        MainPageObject mainPO = new MainPageObject(this.driver);
        WebElement searchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input", 10);
        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find Search... input");
        searchInput.sendKeys("wfewfewfwegweg");

        WebElement expectedResult = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_empty_text",
                "Cannot find element 'No results found'");
        if(expectedResult.getText().equals("No results found")) {
            System.out.println("Success!");
        }
    }
}
