package tests;

import data.Locale;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.StoreMainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Owner("Valeria Reshetina")
@Epic(value = "Testing of Steam website")
@Story("Availability and functionality of sections and headers, correct display depending on the selected language")
public class MainStoreTests extends TestBase {

    StoreMainPage storeMainPage = new StoreMainPage();

    String firstNameOnTopSearchPanelSection = "Магазин";
    String secondNameOnTopSearchPanelSection = "Новое и интересное";
    String thirdNameOnTopSearchPanelSection = "Категории";
    String fourthNameOnTopSearchPanelSection = "Предметы за очки";
    String fifthNameOnTopSearchPanelSection = "Новости";
    String sixthNameOnTopSearchPanelSection = "Лаборатории";

    String firstNameOnSidebarSection = "ПОДАРОЧНЫЕ КАРТЫ";
    String secondNameOnSidebarSection = "РЕКОМЕНДУЕТСЯ";
    String thirdNameOnSidebarSection = "КАТЕГОРИИ";
    String fourthNameOnSidebarSection = "ПОИСК ПО ЖАНРУ";

    static Stream<Arguments> steamLocaleTest() {
        return Stream.of(
                Arguments.of(Locale.ENGLISH, List.of("STORE", "COMMUNITY", "ABOUT", "SUPPORT")),
                Arguments.of(Locale.CZECH, List.of("OBCHOD", "KOMUNITA", "INFORMACE", "PODPORA")),
                Arguments.of(Locale.DEUTSCH, List.of("SHOP", "COMMUNITY", "INFO", "SUPPORT"))
        );
    }

    @MethodSource
    @DisplayName("Parameterized test to check that menu items are displayed " +
            "correctly depending on the selected language with using a MethodSource data provider")
    @ParameterizedTest
    @Severity(SeverityLevel.CRITICAL)
    public void steamLocaleTest(Locale locale, List<String> expectedButtons) {
        step("Open main Steam store page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Choose language " + locale, () -> {
            storeMainPage.changeLanguage(locale);
        });
        step("Check if the language has changed in menu items" + locale, () -> {
            storeMainPage.checkMainPageMenuItems(expectedButtons);
        });
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check displaying of TOP sections on main store page for availability and congruence")
    void topSectionDisplayOnStorePageTest() {
        step("Open main Steam store page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Check top sections for availability and congruence", () -> {
            storeMainPage.checkNavigationPanelElement(firstNameOnTopSearchPanelSection)
                    .checkNavigationPanelElement(secondNameOnTopSearchPanelSection)
                    .checkNavigationPanelElement(thirdNameOnTopSearchPanelSection)
                    .checkNavigationPanelElement(fourthNameOnTopSearchPanelSection)
                    .checkNavigationPanelElement(fifthNameOnTopSearchPanelSection)
                    .checkNavigationPanelElement(sixthNameOnTopSearchPanelSection);
        });
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check displaying of SIDEBAR sections on main store page for availability and congruence")
    void sidebarSectionDisplayOnStorePageTest() {
        step("Open main Steam store page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Check sidebar sections for availability and congruence", () -> {
            storeMainPage.checkSidebarSections(firstNameOnSidebarSection)
                    .checkSidebarSections(secondNameOnSidebarSection)
                    .checkSidebarSections(thirdNameOnSidebarSection)
                    .checkSidebarSections(fourthNameOnSidebarSection);
        });
    }

    @ParameterizedTest(name = "Check if header name {1} in locale {0}")
    @Severity(SeverityLevel.CRITICAL)
    @CsvSource(value = {
            "Deutsch (немецкий), Steam installieren",
            "English (английский), Install Steam",
            "Čeština (чешский), Nainstalovat Steam"
    })
    void languageChangeTest(String language, String expectedHeader) {
        step("Open main Steam store page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Choose language " + language, () -> {
            storeMainPage.changeLanguage(language);
        });
        step("Check presence of header " + expectedHeader, () -> {
            storeMainPage.checkInstallSteamHeader(expectedHeader);
        });
    }
}
