import ScooterProject.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ScooterProject.textFields.ErrorMessages.*;
import static ScooterProject.textFields.OrderFormEnterValue.*;
import static com.codeborne.selenide.Selenide.open;

public class FormOrderScooter extends BaseTest {

    @Test
    @DisplayName("Тест на заполнение формы заказа")
    public void shouldSubmitFormWithValidData() {
        formPage.clickOrderScooter()
                .enterFirstAndLastName(FIRST_NAME.getText(),LAST_NAME.getText())
                .enterAddress(ENTER_ADDRESS.getText())
                .enterMetroStation()
                .enterPhoneNumber(ENTER_PHONE_NUMBER.getText())
                .clickNextFollowingForm()
                .enterBringScooterDate(BRING_SCOOTER_DATE.getText())
                .enterRentalPeriod()
                .choosingScooterColor()
                .enterCourierComment(COMMENT_COURIER.getText())
                .clickOrderAndConfirmButton()
                .getOrderNumber()
                .checkOrderNumber();
    }

    @Test
    @DisplayName("Тест на негативный сценарий заполнения формы")
    public void shouldShowErrorMessagesForEmptyFields() {
        formPage.clickOrderScooter()
                .clickNextFollowingForm()
                .errorWarningMessages(NAME_ERROR_MESSAGE.getError())
                .errorWarningMessages(LAST_ERROR_MESSAGE.getError())
                .errorWarningMessages(STATION_ERROR_MESSAGE.getError())
                .errorWarningMessages(PHONE_ERROR_MESSAGE.getError());
    }

    @Test
    @DisplayName("Тест на переход на главную страницу, при нажатии на логотип")
    public void shouldNavigateToHomePageWhenClickOnLogo() {
        formPage.clickOrderScooter()
                .clickToHomePageLogo();

    }
}
