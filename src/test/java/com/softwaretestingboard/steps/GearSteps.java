package com.softwaretestingboard.steps;

import com.softwaretestingboard.pages.GearCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GearSteps {
    String actualProductQuantity;
    String actualProductPrice;
    String actualUpdatedProductPrice;
    String productNameText;

    @When("I click on product name {string}")
    public void iClickOnProductName(String productName) {
        new GearCategoryPage().clickOnSpecificProduct();
    }

    @And("I change the product quantity to {string}")
    public void iChangeTheProductQuantityTo(String quantity) {
        new GearCategoryPage().changeProductQuantity(quantity);
    }

    @And("I verify the product quantity is {string}")
    public void iVerifyTheProductQuantity(String productQuantity) {
        actualProductQuantity = new GearCategoryPage().verifyProductQuantityInShoppingCart();
        Assert.assertEquals(actualProductQuantity, productQuantity, "Product quantity is not displayed correctly");
    }

    @And("I verify the product price is {string}")
    public void iVerifyTheProductPrice(String productPrice) {
        actualProductPrice = new GearCategoryPage().verifyProductPriceInShoppingCart();
        Assert.assertEquals(actualProductPrice, productPrice, "Product price is not displayed correctly");
    }

    @When("I change the product quantity to {string} in shopping cart page")
    public void iChangeTheProductQuantityInShoppingCartPage(String changeQuantity) {
        new GearCategoryPage().changeProductQuantityInShoppingCart(changeQuantity);
    }

    @And("I click on update shopping cart")
    public void iClickOnUpdateShoppingCart() {
        new GearCategoryPage().clickOnUpdateShoppingCartButton();
    }

    @Then("I verify the product price is updated to {string}")
    public void iVerifyTheProductPriceIsUpdatedTo(String updatedPrice) throws InterruptedException {
        Thread.sleep(2000);
        actualUpdatedProductPrice = new GearCategoryPage().verifyUpdatedPriceInShoppingCart();
        Assert.assertEquals(actualUpdatedProductPrice, updatedPrice, "Update Product Price is not displayed correctly");
    }

    @Then("I verify the product name {string} in shopping cart page")
    public void iVerifyTheProductNameInShoppingCartPage(String productName) {
        productNameText = new GearCategoryPage().verifyProductNameInShoppingCart();
        Assert.assertEquals(productNameText,productName,"Product name is not displayed");
    }
}
