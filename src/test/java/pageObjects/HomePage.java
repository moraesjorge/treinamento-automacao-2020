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

    public void clickSearch_query_top() {
        search_query_top.click();
    }

    public void sendKeysSearch_query_top(String keys) {
        search_query_top.sendKeys(keys);
    }

    public void clickSubmit_search() {
        submit_search.click();
    }

    public void doSearch(String quest) {
        clickSearch_query_top();
        sendKeysSearch_query_top(quest);
        clickSubmit_search();
    }

    public void clickCategoryTShirts() {
        Browser.getCurrentDriver().findElement(By.linkText("T-SHIRTS")).click();
        //menuTshirts.click();
    }

}
