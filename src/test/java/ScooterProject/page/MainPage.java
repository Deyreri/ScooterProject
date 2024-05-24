package ScooterProject.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage clickSection(int index) {
        String clickHeadingSelector = String.format("#accordion__heading-%d", index);
        $(clickHeadingSelector).click();
        return this;
    }

    public MainPage checkTextSection(int index, String text) {
        String clickHeadingSelector = String.format("#accordion__panel-%d", index);
        $(clickHeadingSelector).shouldHave(text(text));
        return this;
    }
}
