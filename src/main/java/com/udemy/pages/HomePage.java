package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
        actions = new Actions(driver);
    }

    @FindAll({
            @FindBy(xpath = "//a[contains(.,'Sign ')]"),
            @FindBy(xpath = "//*[@data-purpose='header-signup']")
    })
    private WebElement signupPopupButton;

    @FindBy(xpath = "//span[@class='user-avatar__inner fx-c']")
    private WebElement userLabel;

    @FindBy(xpath = "//*[@placeholder='What do you want to learn?']")
    private WebElement bannerSearchField;

    @FindBy(xpath = "//*[@data-purpose='browse-courses-link' or text()='Categories']")
    private WebElement homePageCategoryButton;

    @FindAll({
            @FindBy(xpath = "//*[contains(@class,'dropdown-menu__list--level-one')]"),
            @FindBy(xpath = "//*[contains(@class,'js-browse-nav-level-one')]")
    })
    private WebElement homePageCategoryMainList;

    public void openHomePage() {
        driver.get("https://www.udemy.com/");
    }


    By signupPopupButtonLocator = By.xpath("(//*[@data-purpose='header' or @role='navigation']//*[starts-with(text()), 'Sign']");
    By userAvatarLocator = By.xpath("//div[@class='udlite-avatar udlite-heading-xl']");
    By userLabelLocator = By.xpath("(//*[class='user-initials] or contains(@class, 'dropdown-button-avatar')])[1]");
    By userEmailInProfileDropdownLocator = By.xpath("//*[contains(@class, 'user-profile-dropdown--email') or @class='a11 text-midnight-lighter ellipsis']");
    By searchFieldLocator = By.xpath("//*[contains(@id, 'search-form-autocomplete') or @id='header-search-field']");
    By searchFieldCoursesLocator = By.xpath("//form[@action='/courses/search/']//input");
    By categoryButtonLocator = By.xpath("//*[@class='c_header__inner' or @data-purpose='header']//span[text(),'Categories']");
    By categoryMainListLocator = By.xpath("//ul[contains(@class,'dropdown-meni__list--level-one') or contains(@class, 'list-menu--section')])[1]");

    public void openSignupForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupButtonLocator));
        WebElement signupPopupButton = driver.findElement(signupPopupButtonLocator);
        signupPopupButton.click();
    }
    public String getUserEmailFromProfileDropdown() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        WebElement userLabel = driver.findElement(userAvatarLocator);
        actions.moveToElement(userLabel).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailInProfileDropdownLocator));
        WebElement userEmailInProfileDropdown = driver.findElement(userEmailInProfileDropdownLocator);
        return userEmailInProfileDropdown.getText();
    }

    public String getUserInitial() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        return userAvatar.getText();
    }

    public Boolean checkISSearchFieldEmpty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        return searchField.getText().isEmpty();
    }

    public String getSearchedStringFromHeaderSearchField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldCoursesLocator));
        WebElement searchFieldInHeader = driver.findElement(this.searchFieldCoursesLocator);
        return searchFieldInHeader.getAttribute("value");
    }

    public void openListOfCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(categoryButtonLocator));
        WebElement categoryButton = driver.findElement(categoryButtonLocator);
        categoryButton.click();
    }

    public List<String> getTitlesListOfCategories() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryMainListLocator));
        List<WebElement> listOfCategories = driver.findElements(categoryMainListLocator);
        List<String> titlesListOfCategories = new ArrayList<>();
        for (int i = 0; i < listOfCategories.size(); i++) {
            titlesListOfCategories.add(listOfCategories.get(i).getText());
        }
        return titlesListOfCategories;
    }

    public String getUserLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        return userLabel.getText();
    }

    public void setSessionCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
    public HomePage fillSearchField(String string) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(string);
        return this;
    }

    public void submitSearchField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.submit();
    }
}