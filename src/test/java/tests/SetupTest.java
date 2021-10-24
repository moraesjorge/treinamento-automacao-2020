package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import javax.rmi.CORBA.Util;

import static org.junit.Assert.assertTrue;

public class SetupTest extends BaseTests {

    @Test
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    public void testLogin() {


        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();


        home.clickButtonLogin();
        System.out.println("Clicked in Sign In and go to login page");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        login.fillEmail();
        System.out.println("Inserted e-mail");
        login.fillPassword();
        System.out.println("Inserted password");
        login.clickButtonSubmitLogin();
        System.out.println("Clicked Sign in");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("My account's URL validated");
        assertTrue(Browser.getCurrentDriver().findElement(By.cssSelector(".page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validated my account in site");

        //Browser.getCurrentDriver().findElement(By.cssSelector(".login")).click();
        //System.out.println("Click login");
        //assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        //Browser.getCurrentDriver().findElement(By.cssSelector("#email")).sendKeys("moraes.jorge.s@gmail.com");
        //System.out.println("Insert e-mail");

        //Browser.getCurrentDriver().findElement(By.cssSelector("#passwd")).sendKeys("Bulga60@");
        //System.out.println("Insert password");

        //Browser.getCurrentDriver().findElement(By.cssSelector("#SubmitLogin")).click();
        //System.out.println("Click Sign in");

        //assertTrue(Browser.getCurrentDriver().getCurrentUrl().equals(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        //System.out.println("My account's URL validated");

        //assertTrue(Browser.getCurrentDriver().findElement(By.cssSelector(".page-heading")).getText().contains("MY ACCOUNT"));
        //System.out.println("Validated my account in site");

        /*
        Browser.getCurrentDriver().findElement(By.cssSelector("#contact-link")).click();
        System.out.println("Click contact us");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=contact")));

        Browser.getCurrentDriver().findElement(By.cssSelector("a[title='Best sellers']")).click();
        System.out.println("Click best sellers");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().equals(Utils.getBaseUrl().concat("index.php?controller=best-sales")));

        Browser.getCurrentDriver().findElement(By.cssSelector("a[title='View my shopping cart']")).click();
        System.out.println("Click cart");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().equals(Utils.getBaseUrl().concat("index.php?controller=order")));
        */
    }

    @Test
    public void testSearch() {

        String quest = "DRESS";
        String questResultQtd = "7";

        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a pesquisa
        home.doSearch(quest);

        //Validar a pesquisa
        Assert.assertTrue(search.isSearchPage());
        Assert.assertEquals(search.getTextLighter().replace("\"", ""), quest);
        Assert.assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
    }

    @Test
    public void testAcessarCategoriaTshirts() {

        //Iniciar as páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //Clicar na categoria T-SHIRTS
        home.clickCategoryTShirts();

        //Validar se ao clicar na categoria T-SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTshirts());
    }

    @Test
    public void testAddProductToProductPage() {
        //Acessar a categoria T-Shirts
        testAcessarCategoriaTshirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em MORE e direcionar à página de produto
        category.clickProductAddToProductPage();

        //Verificar se o produto está na página de detalhes
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));
    }

    @Test
    public void testAddProductToCartPage() {
        //Acessar a página de produto
        testAddProductToProductPage();
        System.out.println("Acessou a página de produto");

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();
        System.out.println("Iniciou as páginas");

        //Salvar o nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();
        System.out.println("Salvou o nome do produto na página de PDP");

        //Clicar no botão de Adicionar ao carrinho
        pdp.clickButtonAddToCart();
        System.out.println("Clicou no botão de adicionar ao carrinho");


        //Clicar no botão Proceed To Checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        //validação do nome do produto no carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));
    }
}
