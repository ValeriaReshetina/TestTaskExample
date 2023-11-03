package tests;

import data.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.StoreMainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class StoreMainPageTests extends TestBase {

    StoreMainPage storeMainPage = new StoreMainPage();

    static Stream<Arguments> steamLocaleTest() {
        return Stream.of(
                Arguments.of(Locale.ENGLISH, List.of("STORE", "COMMUNITY", "ABOUT", "SUPPORT")),
                Arguments.of(Locale.CZECH, List.of("OBCHOD", "KOMUNITA", "INFORMACE", "PODPORA")),
                Arguments.of(Locale.DEUTSCH, List.of("SHOP", "COMMUNITY", "INFO", "SUPPORT"))
        );
    }

    @MethodSource
    @DisplayName("Parameterized test with using a MethodSource data provider")
    @ParameterizedTest
    public void steamLocaleTest(Locale locale, List<String> expectedButtons) {
        step("Open main Steam community page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Choose language " + locale, () -> {
            storeMainPage.changeLanguage(locale);
        });
        step("check if the language has changed in menu items" + locale, () -> {
            storeMainPage.checkMainPageMenuItems(expectedButtons);
        });

//        $x("//*[@id='language_pulldown']").click();
//        $$x("//a[@class='popup_menu_item tight']").find(text(locale.getLanguage())).click();
//        $$x("//div[@class='supernav_container']//a")
//                .filter(visible).should(CollectionCondition.texts(expectedButtons));
    }
}
