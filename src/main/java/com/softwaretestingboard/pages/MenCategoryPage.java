package com.softwaretestingboard.pages;

import com.softwaretestingboard.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenCategoryPage extends Utility {
    private static final Logger log = LogManager.getLogger(MenCategoryPage.class.getName());

    public MenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='option-label-size-143-item-175']")
    WebElement size32WebElement;

    @FindBy(xpath = "(//div[@id='option-label-color-93-item-49'])[1]")
    WebElement colourWebElement;
    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[1]")
    WebElement addToCartBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")
    WebElement message;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartWebElement;
    @CacheLookup
    @FindBy(xpath = "//a[@class='product-item-link'][normalize-space()='Cronus Yoga Pant']")
    WebElement yogaPantWebElement;


    public void selectProductColour(String colour) {
        mouseHoverToElement(yogaPantWebElement);
        clickOnElement(colourWebElement);
    }

    public String verifyProductAddedNotification() {
        String actualNotification = getTextFromElement(message);
        return actualNotification;
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartWebElement);
    }

    public void mouseHoverOnProductName() {
        mouseHoverToElement(yogaPantWebElement);
    }

    public void selectProductSize(String size) {
        mouseHoverToElement(yogaPantWebElement);
        clickOnElement(size32WebElement);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartBtn);
    }
}


