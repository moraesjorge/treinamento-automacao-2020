package pageObjects;

import elementMapper.CartPageElementMapper;
import elementMapper.CategoryPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CartPage extends CartPageElementMapper {

    public CartPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);

    }

    public String getNameProductCart() {
        return productNameCart.getText();
    }
}
