package pageObjects;

import elementMapper.LoginPageElementMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void fillEmail() {
        email.sendKeys("moraes.jorge.s@gmail.com");
    }

    public void fillPassword() {
        passwd.sendKeys("Bulga60@");
    }

    public void clickButtonSubmitLogin() {
        SubmitLogin.click();
    }



}
