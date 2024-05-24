import ScooterProject.BaseTest;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static ScooterProject.textFields.ErrorMessages.*;
import static ScooterProject.textFields.OrderFormEnterValue.*;

public class FormOrderScooterTest extends BaseTest {

    @Test
    @Owner("Naruto")
    @DisplayName("Заполнение формы заказа")
    public void shouldSubmitFormWithValidData() throws ParseException {
        formPage.clickOrderScooter()
                .enterFirstAndLastName(FIRST_NAME.getText(), LAST_NAME.getText())
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

        orderPage.checkingOrderFields(1, FIRST_NAME.getText())
                 .checkingOrderFields(2, LAST_NAME.getText())
                 .checkingOrderFields(3, ENTER_ADDRESS.getText())
                 .checkingOrderFields(5, ENTER_PHONE_NUMBER.getText());
    }

    @Test
    @Owner("Naruto")
    @DisplayName("Негативный сценарий заполнения формы")
    public void shouldShowErrorMessagesForEmptyFields() {
        formPage.clickOrderScooter()
                .clickNextFollowingForm()
                .errorWarningMessages(NAME_ERROR_MESSAGE.getError())
                .errorWarningMessages(LAST_ERROR_MESSAGE.getError())
                .errorWarningMessages(STATION_ERROR_MESSAGE.getError())
                .errorWarningMessages(PHONE_ERROR_MESSAGE.getError());
    }

    @Test
    @Owner("Naruto")
    @DisplayName("Переход на главную страницу, при нажатии на логотип")
    public void shouldNavigateToHomePageWhenClickOnLogo() {
        formPage.clickOrderScooter()
                .clickToHomePageLogo();
    }

}
