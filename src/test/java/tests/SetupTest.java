package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
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

}
