package com.softwaretestingboard.pages;

import com.softwaretestingboard.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-6']//span[contains(text(),'Gear')]")
    WebElement gearTab;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Bags')]")
    WebElement bagsWebElement;
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-5']//span[contains(text(),'Men')]")
    WebElement menTab;
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-18']")
    WebElement bottomWebElement;
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-23']")
    WebElement pantsWebElement;
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-4']//span[contains(text(),'Women')]")
    WebElement womenTab;
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-9']")
    WebElement topWebElement;
    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Jackets')])[1]")
    WebElement jacketWebElement;


    public void navigateToBagsSection() {
        mouseHoverToElement(gearTab);
        //waitUntilVisibilityOfElementLocated(bagsWebElement, 60);
        mouseHoverToElementAndClick(bagsWebElement);

    }

    public void navigateToPantsSection() {
        mouseHoverToElement(menTab);
        waitUntilVisibilityOfElementLocated(bottomWebElement, 60);
        mouseHoverToElement(bottomWebElement);
        waitUntilVisibilityOfElementLocated(pantsWebElement, 60);
        mouseHoverToElementAndClick(pantsWebElement);

    }

    public void navigateToJacketSection() {
        mouseHoverToElement(womenTab);
        waitUntilVisibilityOfElementLocated(topWebElement, 60);
        mouseHoverToElement(topWebElement);
        waitUntilVisibilityOfElementLocated(jacketWebElement, 60);
        mouseHoverToElementAndClick(jacketWebElement);

    }
}




