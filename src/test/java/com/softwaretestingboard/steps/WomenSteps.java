package com.softwaretestingboard.steps;

import com.softwaretestingboard.pages.WomenCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class WomenSteps {

    List<String> productListBeforeFilter;
    List<String> productListAfterFilter;
    List<Double> priceListBeforeFilter;
    List<Double> priceListAfterFilter;

    @And("I sort jacket by product name")
    public void iSortProductByProductName() throws InterruptedException {
        Thread.sleep(1000);
        productListBeforeFilter = new WomenCategoryPage().getProductListBeforeFilter();
        new WomenCategoryPage().selectSortByFilterProductName();

    }

    @Then("I verify that the product is displayed in alphabetical order")
    public void iVerifyThatTheProductIsDisplayedInAlphabeticalOrder() throws InterruptedException {
        Thread.sleep(1000);
        productListAfterFilter = new WomenCategoryPage().getProductListAfterFilter();
        Assert.assertEquals(productListAfterFilter, productListBeforeFilter, "Product is not displayed in alphabetical order");
    }

    @And("I sort jacket by price")
    public void iSortJacketByPrice() throws InterruptedException {
        Thread.sleep(2000);
        priceListBeforeFilter = new WomenCategoryPage().getPriceListBeforeFilter();
        new WomenCategoryPage().selectSortByFilterPrice();
    }

    @Then("I verify that the product is displayed by price in low to high order")
    public void iVerifyThatTheProductIsDisplayedByPriceInLowToHighOrder() throws InterruptedException {
        Thread.sleep(1000);
        priceListAfterFilter = new WomenCategoryPage().getPriceListAfterFilter();
        Assert.assertEquals(priceListAfterFilter, priceListBeforeFilter, "Price is not displayed in Low to High order");
    }
}
