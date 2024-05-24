package ScooterProject.textFields;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public enum OrderFormEnterValue {
    FIRST_NAME("Иван"),
    LAST_NAME("Иванов"),
    ENTER_ADDRESS("Ул Пушкина дом Калотушкина"),
    ENTER_PHONE_NUMBER("123123123123"),
    BRING_SCOOTER_DATE("10.10.2002"),
    COMMENT_COURIER("asd");

    private final String text;

    OrderFormEnterValue(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getSimpleDateFormat() throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM");
        SimpleDateFormat outputFormat = new SimpleDateFormat("d MMMM", new DateFormatSymbols(new Locale("ru")));
        Date date = inputFormat.parse(BRING_SCOOTER_DATE.getText());
        return outputFormat.format(date);
    }
}
