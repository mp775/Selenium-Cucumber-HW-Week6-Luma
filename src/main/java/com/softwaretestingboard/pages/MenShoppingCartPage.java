package com.softwaretestingboard.pages;

import com.softwaretestingboard.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(MenShoppingCartPage.class.getName());

    public MenShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='base']")
    WebElement soppingCartText;
    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")
    WebElement pantNameText;
    @CacheLookup
    @FindBy(xpath = "//dl[@class='item-options']")
    WebElement productDetailWebEle;

    public String verifyShoppingCartText() {
        String shoppingCartText = getTextFromElement(soppingCartText);
        log.info("Shopping cart text is displayed" + shoppingCartText.toString());
        return shoppingCartText;
    }

    public String verifyProductName() {
        String productName = getTextFromElement(pantNameText);
        log.info("Visible product Name" + pantNameText.toString());
        return productName;
    }

    public String verifyProductDetails(){
        String productDetails = getTextFromElement(productDetailWebEle);
        log.info("Visible product Detail" +productDetailWebEle.toString() );
        return productDetails;
    }
}



