package elementMapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Browser;

public class HomePageElementMapper {

    //a class
    @FindBy(className = "login")
    public WebElement login;

    /*
    @FindBy(css = "#id_value)
    public WebElement foobar;
    ou
    @FindBy(id = "id_value")
    public WebElement foobar;
    ou simplesmente
    public WebElement foobar;
    sem um findby
     */

    //@FindBy(id = "search_query_top")
    public WebElement search_query_top;

    @FindBy(css = "button.btn.btn-default.button-search")
    public WebElement submit_search;

    @FindBy(css = "#block_top_menu .sf-menu li:nth-child(3) a[title=T-shirts]")
    public WebElement menuTshirts;

}
