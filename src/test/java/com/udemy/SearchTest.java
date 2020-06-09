package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "Search test with Valid data")
    public void searchTestWithValidData() {
        homePage.openHomePage();
        Assert.assertTrue(headerSection.checkISSearchFieldEmpty());
        homePage.fillSearchField("angular")
                .submitSearchField();
        Assert.assertEquals(headerSection.getSearchedStringFromHeaderSearchField(), "angular");
        Assert.assertTrue(searchResultsPage.getSearchedStringResult().contains("angular"));
        Assert.assertTrue(searchResultsPage.getSearchURL().contains("ref=home"));
        Assert.assertTrue(searchResultsPage.getTitleFirstSearchedItem().contains("angular"));
    }

}