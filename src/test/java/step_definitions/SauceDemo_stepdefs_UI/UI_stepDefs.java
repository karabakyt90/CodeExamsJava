package step_definitions.SauceDemo_stepdefs_UI;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.SauceDemo.SauceDemo_page_UI;
import utilities.Config;
import utilities.Driver;

public class UI_stepDefs {
    SauceDemo_page_UI sauceDemo = new SauceDemo_page_UI();

    @Given("User is on SauceDemo home page")
    public void user_is_on_SauceDemo_home_page() {
    Driver.getDriver().get(Config.getProperty("url"));
    }

    @When("User logs in to the site")
    public void user_logs_to_the_site()  {
        sauceDemo.username.sendKeys(Config.getProperty("SaucedemoUsername"));
        sauceDemo.password.sendKeys(Config.getProperty("SaucedemoPassword"));
        sauceDemo.loginBtn.click();
    }

    @When("User sorts the items")
    public void user_sorts_the_items() {
        Select Dropdown = new Select(sauceDemo.dropdown);
        Dropdown.selectByValue("lohi");
    }

    @When("User adds two or more items to the shopping cart")
    public void user_adds_two_or_more_items_to_the_shopping_cart() {
        sauceDemo.item1.click();
        sauceDemo.item2.click();
    }

    @Then("User visits the shopping cart")
    public void user_visits_the_shopping_cart()  {
        sauceDemo.shopping_cart.click();
    }

    @Then("User verifies items that were added to the cart")
    public void user_verifies_items_that_were_added_to_the_cart() {
        String item1 = "Sauce Labs Onesie";
        String item2 = "Sauce Labs Bolt T-Shirt";
        String actualText1 = sauceDemo.productsTitle1.getText();
        String actualText2 = sauceDemo.productsTitle2.getText();

        Assert.assertEquals("title is different", actualText1, item1);
        Assert.assertEquals("title is different", actualText2, item2);
    }

    @When("User removes an item and then continues shopping")
    public void user_removes_an_item_and_then_continues_shopping() {
        sauceDemo.removebutton.click();
        sauceDemo.continueShopping.click();
    }

    @When("User adds another item")
    public void user_adds_another_item() {
        sauceDemo.item1.click();
    }

    @Then("User verifies that he is purchasing the correct items")
    public void user_verifies_that_he_is_purchasing_the_correct_items_and_total_price() {
        String item1 = "Sauce Labs Bolt T-Shirt";
        String item2 = "Sauce Labs Backpack";

        String actualText1 = sauceDemo.getItem1.getText();
        String actualText2 = sauceDemo.getItem2.getText();

        Assert.assertEquals("title is different", actualText1, item1);
        Assert.assertEquals("title is different", actualText2, item2);
    }

    @And("User clicks on checkout button and enters first {string}, last {string} and postal code {string}")
    public void user_clicks_on_checkout_button_and_enters_first_last_and_postal_code(String name, String lastName, String postalCode) throws InterruptedException {
        Thread.sleep(3000);
        sauceDemo.checkout.click();
        sauceDemo.first_name.sendKeys(Config.getProperty("firstName"));
        sauceDemo.last_name.sendKeys(Config.getProperty("lastName"));
        sauceDemo.postalcode.sendKeys(Config.getProperty("postalCode"));
        sauceDemo.continue1.click();

    }

    @Then("User verifies the total price and finishes the checkout")
    public void user_verifies_the_total_price_and_finishes_the_checkout(){
        String total_price = "Total: $49.66";
        String actualText = sauceDemo.totalprice.getText();
        Assert.assertEquals("title is different", actualText, total_price);
        sauceDemo.finish.click();
    }

    }


