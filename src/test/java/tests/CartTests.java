package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.StoreGamesPage;
import pages.StoreMainPage;

import static io.qameta.allure.Allure.step;

public class CartTests extends TestBase {

    StoreMainPage storeMainPage = new StoreMainPage();
    StoreGamesPage storeGamesPage = new StoreGamesPage();
    CartPage cartPage = new CartPage();

    String nameOfGame = "Chess Ultra";

    @Test
    @DisplayName("Check for deleting selected game from the cart")
    void deletingGameFromCartTest() {
        step("Open main Steam community page", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Find game by search field", () -> {
            storeMainPage.searchInput(nameOfGame);
        });
        step("Click on game with name" + nameOfGame, () -> {
            storeGamesPage.clickOnGame(nameOfGame);
        });
        step("Add to cart", () -> {
            storeGamesPage.addToCart();
        });
        step("Check that game " + nameOfGame + " was added to cart", () -> {
            cartPage.checkGameInCart(nameOfGame);
        });
        step("Delete game from Cart", () -> {
            cartPage.deleteGameFromCart();
        });
        step("Check the game was deleted", () -> {
            cartPage.checkDeletedGameMessage();
        });
    }

    @Test
    @DisplayName("Check for successfully adding game to the cart")
    void addingGameToCartTest() {
        step("Open main page of Steam community", () -> {
            storeMainPage.openMainStorePage();
        });
        step("Find game by search field", () -> {
            storeMainPage.searchInput(nameOfGame);
        });
        step("Click on game with name" + nameOfGame, () -> {
            storeGamesPage.clickOnGame(nameOfGame);
        });
        step("Add to cart", () -> {
            storeGamesPage.addToCart();
        });
        step("Check that game " + nameOfGame + " was added to cart", () -> {
            cartPage.checkGameInCart(nameOfGame);
        });
    }
}
