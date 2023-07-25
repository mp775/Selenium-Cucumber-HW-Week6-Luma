package com.softwaretestingboard.steps;

import com.softwaretestingboard.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps {

    @Given("I am on home page")
    public void iAmOnHomePage() {
    }
    @When("I navigate to women jacket section")
    public void iNavigateToWomenJacketSection() {
       new HomePage().navigateToJacketSection();
    }

    @When("I navigate to men pants section")
    public void iNavigateToMenPantsSection() {
        new HomePage().navigateToPantsSection();
    }

    @And("I mouse hover on gear menu tab and navigate to bag section")
    public void iMouseHoverOnGearMenuTabAndNavigateToBagSection() {
        new HomePage().navigateToBagsSection();
    }
}
