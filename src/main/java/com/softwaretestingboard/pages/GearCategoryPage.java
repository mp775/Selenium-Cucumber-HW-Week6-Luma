package com.softwaretestingboard.pages;

import com.softwaretestingboard.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearCategoryPage extends Utility {
    private static final Logger log = LogManager.getLogger(GearCategoryPage.class.getName());

    public GearCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Overnight Duffle']")
    WebElement productOvernightDuffleWebElement;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Overnight Duffle')]")
    WebElement productNameWebElement;
    @CacheLookup
    @FindBy(xpath = "//input[@id='qty']")
    WebElement quantityBoxWebElement;
    @CacheLookup
    @FindBy(css = "button[id='product-addtocart-button'] span")
    WebElement addToCartBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement productAddedNotificationWebElement;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Overnight Duffle']")
    WebElement productNameInShoppingCartWebElement;
    @CacheLookup
    @FindBy(xpath = "//td[@data-th='Qty']/div/div/label/input")
    WebElement productQuantityInShoppingCartWebElement;
    @CacheLookup
    @FindBy(xpath = "//td[@data-th='Subtotal']")
    WebElement productPriceInShoppingCartWebElement;
    @CacheLookup
    @FindBy(xpath = "//td[@data-th='Qty']/div/div/label/input")
    WebElement quantityBoxInCartWebElement;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Update Shopping Cart')]")
    WebElement updateShoppingCartBtn;
    @CacheLookup
    @FindBy(xpath = "//td[@data-th='Subtotal']")
    WebElement updatedPriceWebElement;

    public void clickOnSpecificProduct() {
        clickOnElement(productOvernightDuffleWebElement);
        log.info("Click on specific product" + productOvernightDuffleWebElement.toString());
    }

    public String verifyProductText() {
        return getTextFromElement(productNameWebElement);
    }


    public void changeProductQuantity(String quantity) {
        clearTextFromField(quantityBoxWebElement);
        sendTextToElement(quantityBoxWebElement, quantity);

    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartBtn);

    }

    public String verifyProductAddedToShoppingCartNotificationText() {
        String ProductAdded =getTextFromElement(productAddedNotificationWebElement);
        log.info("verify product added to shopping cart notification " + productAddedNotificationWebElement.toString());
        return ProductAdded;
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartLink);
        log.info("click on shopping cart link" + shoppingCartLink.toString());

    }

    public String verifyProductNameInShoppingCart() {
        return getTextFromElement(productNameInShoppingCartWebElement);
    }

    public String verifyProductQuantityInShoppingCart() {
        String attributeText = getAttributeValueOfElement(productQuantityInShoppingCartWebElement,"value");
        log.info("verify product qty in shopping cart : " + productQuantityInShoppingCartWebElement.toString());
        return attributeText;
    }

    public String verifyProductPriceInShoppingCart() {
        String productPrice = getTextFromElement(productPriceInShoppingCartWebElement);
        log.info("Product price is correct" + productPriceInShoppingCartWebElement.toString());
        return productPrice;
    }

    public void changeProductQuantityInShoppingCart(String changeQty) {
        clearTextFromField(quantityBoxInCartWebElement);
        sendTextToElement(quantityBoxInCartWebElement, changeQty);
    }

    public void clickOnUpdateShoppingCartButton() {
        clickOnElement(updateShoppingCartBtn);
        log.info("Clicking on update button : " +updateShoppingCartBtn.toString());

    }

    public String verifyUpdatedPriceInShoppingCart() {
        String updatedPrice =getTextFromElement(updatedPriceWebElement);
        log.info("verify update price : " + updatedPriceWebElement.toString());
        return  updatedPrice;
    }

}




