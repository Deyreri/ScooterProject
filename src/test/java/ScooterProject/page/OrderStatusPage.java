package ScooterProject.page;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class OrderStatusPage {

    @Step("Проверка полей заказа")
    public OrderStatusPage checkingOrderFields(int index, String text) {
        ElementsCollection elements = $$("div.Track_Value__15eEX");
        elements.get(index - 1).shouldHave(text(text));
        return this;
    }
}
