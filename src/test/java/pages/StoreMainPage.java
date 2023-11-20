package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Locale;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StoreMainPage {
    private final SelenideElement storeNavigationPanel = $x("//div[@class='store_nav']"),
            storeSidebarSection = $x("//div[@class='home_page_gutter']"),
            searchInputField = $x("//input[@id='store_nav_search_term']"),
            changingLanguageButton = $x("//*[@id='language_pulldown']"),
            installSteamHeader = $x("//a[contains(@class, 'header_installsteam')]");

    private final ElementsCollection collectionOfLanguagesOnChoiceTriggeredByChangeLanguageButton = $$x(
                    "//a[@class='popup_menu_item tight']"),
            subMenuItemsOnMainPage = $$x("//div[@class='supernav_container']//a");


    public StoreMainPage openMainStorePage() {
        open("https://store.steampowered.com/");
        return this;
    }

    public StoreMainPage changeLanguage(Locale locale) {
        changingLanguageButton.click();
        collectionOfLanguagesOnChoiceTriggeredByChangeLanguageButton.
                find(text(locale.getLanguage())).click();
        return this;
    }

        public StoreMainPage changeLanguage(String language) {
        changingLanguageButton.click();
            collectionOfLanguagesOnChoiceTriggeredByChangeLanguageButton.
                    find(text(language)).click();
        return this;
    }

    public StoreMainPage checkMainPageMenuItems(List<String> expectedButtons) {
        subMenuItemsOnMainPage.filter(visible).should(CollectionCondition.texts(expectedButtons));
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

    public StoreMainPage checkInstallSteamHeader(String expectedHeader) {
        installSteamHeader.shouldHave(text(expectedHeader));
        return this;
    }
}
