package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CommunityMainPage;
import pages.PlayersSearchPage;

import static io.qameta.allure.Allure.step;

@Owner("Valeria Reshetina")
public class CommunityMainTests extends TestBase {

    CommunityMainPage communityMainPage = new CommunityMainPage();
    PlayersSearchPage playersSearchPage = new PlayersSearchPage();

    String playerName = "TianoX";

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking that players in Steam Community are searched and displayed correctly")
    void playersSearchTest() {
        step("Open main Steam community page", () -> {
            communityMainPage.openMainCommunityPage();
        });
        step("Enter player name " + playerName + "in search players field", () -> {
            communityMainPage.searchPlayersInput(playerName);
        });
        step("Verify that results have player with name " + playerName, () -> {
            playersSearchPage.checkSearchPlayersPageHeader()
                    .checkPlayerResultPresence(playerName);
        });
    }
}
