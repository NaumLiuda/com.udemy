package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.udemy.constants.HeaderSectionConsts.CATEGORYLIST;

public class CategoriesTest extends BaseTest {

    @Test(description = "Check categories list")
    public void checkCategoriesList() {

        homePage.openHomePage();
        homePage.openListOfCategories();
        Assert.assertEquals(homePage.getTitlesListOfCategories(), CATEGORYLIST);
    }
}