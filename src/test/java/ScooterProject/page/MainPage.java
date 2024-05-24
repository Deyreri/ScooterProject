package ScooterProject.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    @Step("Открывает секцию с '{index}'")
    public MainPage clickSection(int index) {
        String clickHeadingSelector = String.format("#accordion__heading-%d", index);
        $(clickHeadingSelector).click();
        return this;
    }

    @Step("Открывает секцию с '{text}'")
    public MainPage checkTextSection(int index, String text) {
        String clickHeadingSelector = String.format("#accordion__panel-%d", index);
        $(clickHeadingSelector).shouldHave(text(text));
        return this;
    }
}
