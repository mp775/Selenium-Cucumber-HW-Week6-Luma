package com.softwaretestingboard.pages;

import com.softwaretestingboard.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenCategoryPage extends Utility {
    private static final Logger log = LogManager.getLogger(WomenCategoryPage.class.getName());

    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(css = "#sorter")
    WebElement filterDropDown;
    @CacheLookup
    @FindBy(id = "sorter")
    WebElement sortBy;

    List<WebElement> beforeFilterProduct;
    List<WebElement> afterFilterProduct;
    List<WebElement> beforeFilterPrice;
    List<WebElement> afterFilterPrice;



    public List<String> getProductListBeforeFilter() {
        for (int retry = 0; retry < 2; retry++) {
            try {
                beforeFilterProduct = driver.findElements(By.xpath("//a[@class='product-item-link']"));
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.toString());
            }
        }
        List<String> beforeFilterProductList = new ArrayList<>();
        for (WebElement product : beforeFilterProduct) {
            beforeFilterProductList.add(String.valueOf(product.getText()));
        }
        System.out.println("Product before filter apply: " + beforeFilterProductList);
        Collections.sort(beforeFilterProductList);
        System.out.println("Product list in alphabetical order : " + beforeFilterProductList);
        log.info("Before sort product list : " + beforeFilterProductList.toString());
        return beforeFilterProductList;
    }

    public void selectSortByFilterProductName() {
        for (int retry = 0; retry < 2; retry++) {
            try {
                selectByVisibleTextFromDropDown(filterDropDown, "Product Name ");
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public List<String> getProductListAfterFilter() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        for (int retry = 0; retry < 2; retry++) {
            try {
                afterFilterProduct = driver.findElements(By.xpath("//a[@class='product-item-link']"));
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.toString());
            }
        }
        List<String> afterFilterProductList = new ArrayList<>();
        for (WebElement product : afterFilterProduct) {
            afterFilterProductList.add(String.valueOf(product.getText()));
        }
        System.out.println("Product list after filter apply: " + afterFilterProductList);
        log.info("after sort product list : " + afterFilterProductList.toString());
        return afterFilterProductList;
    }

    public List<Double> getPriceListBeforeFilter() {
        for (int retry = 0; retry < 2; retry++) {
            try {
                beforeFilterPrice = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']/span"));
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.toString());
            }
        }
        List<Double> beforeFilterPriceList = new ArrayList<>();
        for (WebElement price : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }
        System.out.println("Price before filter apply: " + beforeFilterPriceList);
        Collections.sort(beforeFilterPriceList);
        System.out.println("Price order Low to High : " + beforeFilterPriceList);
        log.info("before filter price list: " + beforeFilterPriceList.toString());
        return beforeFilterPriceList;
    }

    public void selectSortByFilterPrice() {
        for (int retry = 0; retry < 2; retry++) {
            try {
                selectByVisibleTextFromDropDown(sortBy, "Price");
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public List<Double> getPriceListAfterFilter() {
        driver.navigate().refresh();
        for (int retry = 0; retry < 2; retry++) {
            try {
                afterFilterPrice = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']/span"));
            } catch (StaleElementReferenceException ex) {
                System.out.println(ex.toString());
            }
        }
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement price : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }
        System.out.println("Price list after applying filter: " + afterFilterPriceList);
        log.info("after sort price list : " + afterFilterPriceList.toString());
        return afterFilterPriceList;
    }
}






