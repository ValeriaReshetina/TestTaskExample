package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StoreMainPage {
    private final SelenideElement storeNavigationPanel = $x("//div[@class='store_nav']"),
            storeSidebarSection = $x("//div[@class='home_page_gutter']"),
            searchInputField = $x("//input[@id='store_nav_search_term']");

    public StoreMainPage openMainStorePage() {
        open("https://store.steampowered.com/");
        return this;
    }

    public StoreMainPage checkNavigationPanelElement(String searchPanelElement) {
        storeNavigationPanel.find(byText(searchPanelElement)).shouldBe(visible);
        return this;
    }

    public StoreMainPage checkSidebarSections(String sidebarElement) {
        storeSidebarSection.shouldHave(text(sidebarElement));
        return this;
    }

    public StoreMainPage searchInput(String input) {
        searchInputField.setValue(input).pressEnter();
        return this;
    }
}
