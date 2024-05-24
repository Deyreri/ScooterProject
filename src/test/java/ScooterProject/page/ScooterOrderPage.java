package ScooterProject.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ScooterOrderPage {

    private final SelenideElement
            nameInput = $("input[placeholder='* Имя']"),
            lastNameInput = $("input[placeholder='* Фамилия']"),
            addressInput = $("input[placeholder='* Адрес: куда привезти заказ']"),
            numberInput = $("input[placeholder='* Телефон: на него позвонит курьер']"),
            submitButton = $x("//button[text()='Далее']"),
            orderButton = $x("(//button[text()='Заказать'])[1]"),
            metroStationSection = $x("//input[@placeholder='* Станция метро']"),
            metroStation = $x("//div[text()='Бульвар Рокоссовского']"),
            bringScooterDate = $x("//input[@placeholder='* Когда привезти самокат']"),
            rentalPeriodSection = $x("//div[text()='* Срок аренды']"),
            rentalPeriodOneDay = $x("//div[text()='сутки']"),
            scooterColorSection = $x("//input[@id='black']"),
            courierCommentSection = $x("//input[@placeholder='Комментарий для курьера']"),
            secondOrderButton = $x("(//button[text()='Заказать'])[2]"),
            orderConfirmButton= $x("//button[text()='Да']"),
            homePageLogo = $(".Header_LogoScooter__3lsAR"),
            homePage = $(".Home_HomePage__ZXKIX"),
            orderNumberSelector = $(".Order_Text__2broi"),
            clickNextButtonSelector = $x("//button[contains(text(), 'Посмотреть статус')]"),
            InputOrderNumber = $x("//input[contains(@class, 'Input_Input__1iN_Z') and contains(@class, 'Track_Input__1g7lq') and contains(@class, 'Input_Filled__1rDxs') and contains(@class, 'Input_Responsible__1jDKN')]");

    @Step("нажатиекнопку заказать, и преход в форму")
    public ScooterOrderPage clickOrderScooter() {
        orderButton.click();
        return this;
    }

    @Step("Заполнение поля 'Имя', и 'Фамилия'")
    public ScooterOrderPage enterFirstAndLastName(String firstName, String lastName) {
        nameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Заполнение поля 'Адрес: куда привезти заказ'")
    public ScooterOrderPage enterAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    @Step("Нажатие поля с выбором метро, и выбор 'Бульвар Рокоссовского'")
    public ScooterOrderPage enterMetroStation() {
        metroStationSection.click();
        metroStation.click();
        return this;
    }

    @Step("Заполнение поле с номером телефона")
    public ScooterOrderPage enterPhoneNumber(String phone) {
        numberInput.setValue(phone);
        return this;
    }

    @Step("Нажатие кнопки далее, и переход на следующую форму")
    public ScooterOrderPage clickNextFollowingForm() {
        submitButton.click();
        return this;
    }

    @Step("Выбор даты, когда должны привези самокат")
    public ScooterOrderPage enterBringScooterDate(String date) {
        bringScooterDate.click();
        bringScooterDate.setValue(date).pressEnter();
        return this;
    }

    @Step("Указывание срока аренды скутера")
    public ScooterOrderPage enterRentalPeriod() {
        rentalPeriodSection.click();
        rentalPeriodOneDay.click();
        return this;
    }

    @Step("Выбор цвета скутера")
    public ScooterOrderPage choosingScooterColor() {
        scooterColorSection.click();
        return this;
    }

    @Step("Указывание комментария курьеру")
    public ScooterOrderPage enterCourierComment(String comment) {
        courierCommentSection.setValue(comment);
        return this;
    }

    @Step("Нажатие кнопки заказать, и подтверждение заказа")
    public ScooterOrderPage clickOrderAndConfirmButton() {
        secondOrderButton.click();
        orderConfirmButton.click();
        return this;
    }

    public ScooterOrderPage getOrderNumber() {
        String orderText = orderNumberSelector.getText();
        String orderNumber = orderText.split(": ")[1].split("\\.")[0];
        clickNextButtonSelector.click();
        this.orderNumber = orderNumber;
        return this;
    }
    private String orderNumber;

    public ScooterOrderPage checkOrderNumber() {
        InputOrderNumber.shouldHave(Condition.value(orderNumber));
        return this;
    }

    @Step("Проверка на негативное заполнение полей формы")
    public ScooterOrderPage errorWarningMessages(String message) {
        String errorMessageSelector = String.format("//div[contains(text(),'%s')]", message);
        $(byXpath(errorMessageSelector)).shouldBe(Condition.visible);
        return this;
    }

    public ScooterOrderPage clickToHomePageLogo() {
        homePageLogo.click();
        homePage.shouldBe(visible);
        return this;
    }
}
