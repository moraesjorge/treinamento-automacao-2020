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


}
