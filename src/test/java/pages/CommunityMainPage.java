package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CommunityMainPage {

    private final SelenideElement searchPlayersInputField =
            $x("//input[@id='SearchPlayers']");

    public CommunityMainPage openMainCommunityPage() {
        open("https://steamcommunity.com/");
        return this;
    }

    public CommunityMainPage searchPlayersInput(String inputPlayer) {
        searchPlayersInputField.setValue(inputPlayer).pressEnter();
        return this;
    }
}
