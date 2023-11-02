package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private static final String CART_PAGE_TITLE = "ВАША КОРЗИНА";
    private static final String SUCCESS_MESSAGE = "Ваш товар был добавлен!";
    private static final String DELETE_MESSAGE = "Ваш товар был удалён!";

    private final SelenideElement cartPageHeader = $x("//h2[@class='pageheader']"),
            statusMessage = $x("//div[@class='cart_status_message']"),
            cartItem = $x("//div[@class='cart_item']"),
            removeFromCartBtn = $x("//*[@class='remove_link' and text()='Удалить']"),
            removeAllGameItems = $x("//*[contains(text(), 'Удалить все товары')]"),
            consentToDeletion = $x("//*[@class='newmodal_content']//*[contains(text(), 'Да')]"),
            totalSumIsNullAfterDeletingAllGames = $x(
                    "//*[@class='cart_total_row']//*[contains(text(), '0 pуб')]");

    public CartPage checkGameInCart(String gameName) {
        cartPageHeader.shouldHave(text(CART_PAGE_TITLE));
        statusMessage.shouldHave(text(SUCCESS_MESSAGE));
        cartItem.shouldHave(text(gameName));
        return this;
    }

    public CartPage deleteGameFromCart() {
        removeFromCartBtn.click();
        return this;
    }

    public CartPage deleteAllGameItemsFromCart() {
        removeAllGameItems.click();
        consentToDeletion.click();
        return this;
    }

    public CartPage checkDeletedGameMessage() {
        statusMessage.shouldHave(text(DELETE_MESSAGE));
        return this;
    }

    public CartPage checkThatCartIsEmptyAndGameWasActuallyDeleted() {
        totalSumIsNullAfterDeletingAllGames.shouldBe(visible);
        return this;
    }
}
