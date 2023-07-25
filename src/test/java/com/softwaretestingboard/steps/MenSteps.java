package com.softwaretestingboard.steps;

import com.softwaretestingboard.pages.MenCategoryPage;
import com.softwaretestingboard.pages.MenShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MenSteps {
    String actualNotification;
    String shoppingCartText;
    String productNameText;
    String productDetails;

    @And("I mouse hover on product {string}")
    public void iMouseHoverOnProduct(String productName) throws InterruptedException {
        Thread.sleep(1000);
        new MenCategoryPage().mouseHoverOnProductName();
    }

    @And("I select product size as {string}")
    public void iSelectProductSizeAs(String size) throws InterruptedException {
        Thread.sleep(1000);
        new MenCategoryPage().selectProductSize(size);
    }

    @And("I select product colour as {string}")
    public void iSelectProductColourAs(String colour) throws InterruptedException {
        Thread.sleep(1000);
        new MenCategoryPage().selectProductColour(colour);
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        new MenCategoryPage().clickOnAddToCartButton();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String notification) {
        actualNotification = new MenCategoryPage().verifyProductAddedNotification();
        Assert.assertEquals(actualNotification,notification,"Product added notification is not displayed");
    }

    @When("I click on shopping cart link")
    public void iClickOnShoppingCartLink() {
        new MenCategoryPage().clickOnShoppingCartLink();
    }

    @Then("I verify the text {string} in the shopping cart page")
    public void iVerifyTheTextShoppingCartInShoppingCartPage(String text) {
        shoppingCartText = new MenShoppingCartPage().verifyShoppingCartText();
        Assert.assertEquals(shoppingCartText,text,"Shopping Cart Text is not displayed");
    }

    @And("I verify the product name {string} in the shopping cart page")
    public void iVerifyTheProductNameInShoppingCartPage(String productName) {
        productNameText = new MenShoppingCartPage().verifyProductName();
        Assert.assertEquals(productNameText,productName,"Product name is not displayed");
    }

    @And("I verify the product size {string} and colour {string} in the shopping cart page")
    public void iVerifyTheProductSizeAndColourInTheShoppingCartPage(String size, String colour) {
        productDetails = new MenShoppingCartPage().verifyProductDetails();
        Assert.assertTrue(productDetails.contains(size));
        Assert.assertTrue(productDetails.contains(colour));
    }
}
