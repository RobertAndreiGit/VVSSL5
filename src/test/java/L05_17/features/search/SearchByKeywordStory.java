package L05_17.features.search;

import L05_17.pages.MainPage;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.*;

import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import L05_17.steps.serenity.EndUserSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/data.csv")
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.okazii.ro/login")
    public Pages pages;
    public MainPage mainPage;
    public LoginPageManager loginPageManager;

    @Steps
    public EndUserSteps user;

    public String nume;
    public String parola;

    @Qualifier
    public String getQualifier(){
        return parola;
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
    public void login() {
        user.is_the_home_page();
        loginPageManager.login(nume, parola);

        if(parola.equals("Test123")){
            assertEquals(webdriver.getCurrentUrl(), "https://www.okazii.ro/");
        } else if(parola.equals("test12333")) {
            assertNotEquals(webdriver.getCurrentUrl(), "https://www.okazii.ro/");
        } else {
            assert false;
        }
    }
} 