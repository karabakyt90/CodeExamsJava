package pages.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemo_page_UI {
    public SauceDemo_page_UI() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(className = "btn_action")
    public WebElement loginBtn;

    @FindBy(className = "product_sort_container")
    public WebElement dropdown;

    @FindBy(xpath="(//*[@class='btn_primary btn_inventory'])[1]")
    public WebElement item1;

    @FindBy(xpath="(//*[@class='btn_primary btn_inventory'])[2]")
    public WebElement item2;

    @FindBy(xpath="//*[@class='shopping_cart_link fa-layers fa-fw']")
    public WebElement shopping_cart;

    @FindBy(id="item_2_title_link")
    public WebElement productsTitle1;

    @FindBy(id="item_1_title_link")
    public WebElement productsTitle2;

    @FindBy(xpath="(//*[@class='btn_secondary cart_button'])[1]")
    public WebElement removebutton;

    @FindBy(xpath="(//*[@class='btn_secondary'])[1]")
    public WebElement continueShopping;

    @FindBy(xpath="//*[text()='CHECKOUT']")
    public WebElement checkout;

    @FindBy(id="first-name")
    public WebElement first_name;

    @FindBy(id="last-name")
    public WebElement last_name;

    @FindBy(id="postal-code")
    public WebElement postalcode;

    @FindBy(xpath="//*[@class='btn_primary cart_button']")
    public WebElement continue1;

    @FindBy(id="item_1_title_link")
    public WebElement getItem1;

    @FindBy(id="item_4_title_link")
    public WebElement getItem2;

    @FindBy(className="summary_total_label")
    public WebElement totalprice;

    @FindBy(linkText="FINISH")
    public WebElement finish;



}

