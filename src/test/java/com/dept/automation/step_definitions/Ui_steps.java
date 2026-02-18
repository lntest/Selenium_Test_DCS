package com.dept.automation.step_definitions;

import com.dept.automation.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;


public class Ui_steps {

    private WebDriver driver() {
        return Hooks.driver;
    }

    final WaitUtils myWait = new WaitUtils(driver(), 10);

    @Given("I am on the motor vehicle stamp duty page")
    public void i_am_on_the_login_page() {
        driver().get("https://www.service.nsw.gov.au/transaction/check-motor-vehicle-stamp-duty");

        myWait.visible(By.cssSelector(".cta__action > a.button"));
    }

    @When("I click on the check online button and go to vehicle registration duty calculator page")
    public void i_click_on_the_check_online_button() {
        driver().findElement(By.cssSelector(".cta__action > a.button")).click();
        myWait.visible(By.cssSelector("#calcForm"));
        Assert.assertTrue(driver().findElement(By.cssSelector("#calcForm")).isDisplayed());
    }

    @When("^I select the passenger vehicle as (Yes|No)$")
    public void i_select_the_passenger_vehicle(String isPassengerVehicle) {
        if (isPassengerVehicle.equals("Yes")) {
            myWait.clickable(By.cssSelector("label[for='passenger_Y']"));
            driver().findElement(By.cssSelector("label[for='passenger_Y']")).click();
        } else {
            driver().findElement(By.id("passenger_N")).click();
        }
        myWait.visible(By.cssSelector("#calcForm"));
    }
    @When("^I enter the purchase price as (\\d+)$")
    public void i_enter_the_purchase_price_as(int purchasePrice) {
        driver().findElement(By.cssSelector("#purchasePrice")).sendKeys(String.valueOf(purchasePrice));
    }
    @When("I click on submit")
    public void i_click_on_submit() {
        driver().findElement(By.cssSelector("button.btn.btn-primary")).click();
        myWait.visible(By.cssSelector(".modal-dialog .modal-body"));
        Assert.assertTrue(driver().findElement(By.cssSelector(".modal-dialog .modal-body")).isDisplayed());
    }

    @Then("I should see the calculated duty payable value succesfully")
    public void i_should_see_the_calculated_duty_payable_value_succesfully() throws Exception {
        try {
            myWait.visible(By.cssSelector(".TableApp"));
        } catch (Exception e) {
            throw new Exception("Error loading the car registration calculation", e);
        }

        By closeBtn = By.xpath("//button[@data-dismiss='modal' and text()='Close']");
        driver().findElement(closeBtn).click();
        try {
            myWait.invisible(By.cssSelector(".modal"));
        } catch (Exception e){
            throw new Exception("Error modal dialog has not closed", e);
        }
    }



}


