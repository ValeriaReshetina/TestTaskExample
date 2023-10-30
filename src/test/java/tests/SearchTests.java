package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class SearchTests {
    @Test
    void cartTest() {
        $x("//input[contains(@placeholder, 'поиск')]").shouldHave(Condition.visible).click();
        $x("//input[contains(@placeholder, 'поиск')]").setValue("Elden Ring").pressEnter();


    }
}
