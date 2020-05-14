package L05_17.features.search;

import L05_17.pages.MainPage;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.*;

import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import L05_17.steps.serenity.EndUserSteps;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/data2.csv")
public class DoMuchStuff {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.okazii.ro/login")
    public Pages pages;
    public MainPage mainPage;
    public LoginPageManager pageManager;

    @Steps
    public EndUserSteps user;

    public String nume;
    public String parola;
    public String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Test
    public void test_scenariu() {
        user.is_the_home_page();

        pageManager.login(nume, parola);
        assertEquals(webdriver.getCurrentUrl(), "https://www.okazii.ro/");

        pageManager.search(search);
        assertEquals(webdriver.getCurrentUrl(), "https://www.okazii.ro/cautare/glob.html");

        pageManager.clickFirstItem();
        assertTrue(pageManager.getItemTitle().toLowerCase().contains(search.toLowerCase()));

        pageManager.addToCart();
        assertTrue(pageManager.getFirstItemTitle().toLowerCase().contains(search.toLowerCase()));
    }

}