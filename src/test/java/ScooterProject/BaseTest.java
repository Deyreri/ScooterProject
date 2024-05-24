package ScooterProject;

import ScooterProject.page.MainPage;
import ScooterProject.page.OrderStatusPage;
import ScooterProject.page.ScooterOrderPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected MainPage mainPage = new MainPage();
    protected ScooterOrderPage formPage = new ScooterOrderPage();
    protected OrderStatusPage orderPage = new OrderStatusPage();

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "firefox";
        baseUrl = "https://qa-scooter.praktikum-services.ru/";
        browserSize = "1920x1080";
        open(baseUrl);
        acceptCookie();
    }

    public static void acceptCookie() {
        $("#rcc-confirm-button").click();
    }
}
