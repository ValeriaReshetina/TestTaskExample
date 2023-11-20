package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$x;

public class StoreGamesPage {

    private final SelenideElement game = $x("//*[@class='responsive_search_name_combined']"),
            addToCartBtn = $x("//div[@class='btn_addtocart']");

    public StoreGamesPage clickOnGame(String gameName) {
        game.find(byTextCaseInsensitive(gameName)).click();
        return this;
    }

    public StoreGamesPage addToCart() {
        addToCartBtn.click();
        return this;
    }
}
