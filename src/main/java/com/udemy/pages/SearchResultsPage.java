package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @FindBy(xpath ="//*[@class='search--header-container--2-Reh']")
    private WebElement searchResultTitle;

    @FindBy (xpath ="(//*[contains(@class,'udlite-focus-visible-target')])[1]")
    private WebElement firstSearchResultTitle;

    By searchFieldOnPageLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    By firstSearchedItemLocator = By.xpath("(//div[@class='course-card--main-content--3xEIw']/div)[1]");

    public String getSearchedStringResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldOnPageLocator));
        WebElement searchFieldOnPage = driver.findElement(this.searchFieldOnPageLocator);
        return searchFieldOnPage.getText();
    }

    public String getSearchURL() {
        return driver.getCurrentUrl();
    }

    public String getTitleFirstSearchedItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchedItemLocator));
        WebElement firstSearchedItem = driver.findElement(this.firstSearchedItemLocator);
        return firstSearchedItem.getText().toLowerCase();
    }
}