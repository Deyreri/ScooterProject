package ScooterProject.textFields;

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
}
