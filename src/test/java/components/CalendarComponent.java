package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    SelenideElement birthDate = $x(
            "//div[contains(text(), 'Пожалуйста, укажите дату своего рождения:')]");

    public void setDate(String day, String month, String year) {
        $x("//*[(@name='ageMonth')]").selectOption(month);
        $x("//*[(@name='ageYear')]").selectOption(year);
        $x("//*[(@name='ageDay')] //*[12]").selectOption(day);
    }

    public void setBirthDate(String day, String month, String year) {
        birthDate.click();
        setDate(day, month, year);
    }
}
