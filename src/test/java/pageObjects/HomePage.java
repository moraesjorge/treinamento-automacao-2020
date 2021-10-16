package pageObjects;

import elementMapper.HomePageElementMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends HomePageElementMapper {

    //construtor da classe
    public HomePage() {
        //elementos desta página (HomePage) são iniciados
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    public void clickButtonLogin() {
        login.click();
    }

}
