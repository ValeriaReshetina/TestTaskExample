package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class PlayersSearchPage {
    private static final String SEARCH_FRIENDS_PAGE_TITLE = "Найти друзей";

    private final SelenideElement
            mainSearchPlayersHeader = $x("//div[@class='community_search_container']"),
            resultPlayersRows = $x("//div[@class='search_row']");

    public PlayersSearchPage checkSearchPlayersPageHeader() {
        mainSearchPlayersHeader.shouldHave(text(SEARCH_FRIENDS_PAGE_TITLE));
        return this;
    }

    public PlayersSearchPage checkPlayerResultPresence(String playerName) {
        resultPlayersRows.shouldHave(text(playerName));
        return this;
    }
}
