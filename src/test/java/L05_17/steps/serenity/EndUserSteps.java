package L05_17.steps.serenity;

import L05_17.pages.MainPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    MainPage mainPage;

    @Step
    public void enters(String keyword) {
        mainPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        mainPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(mainPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        mainPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}