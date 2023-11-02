package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$x;

public class StoreGamesPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement game = $x("//*[@class='responsive_search_name_combined']"),
            addToCartBtn = $x("//div[@class='btn_addtocart']");

    public StoreGamesPage clickOnGame(String gameName) {
        game.find(byTextCaseInsensitive(gameName)).click();
        return this;
    }

    public StoreGamesPage chooseBirthDateForAdultGames() {
        calendarComponent.setBirthDate("12", "August", "1996");
        return this;
    }

    public StoreGamesPage addToCart() {
        addToCartBtn.click();
        return this;
    }
}
