package ScooterProject.textFields;

public enum ErrorMessages {
    NAME_ERROR_MESSAGE("Введите корректное имя"),
    LAST_ERROR_MESSAGE("Введите корректную фамилию"),
    STATION_ERROR_MESSAGE("Выберите станцию"),
    PHONE_ERROR_MESSAGE("Введите корректный номер");

    private final String text;

    ErrorMessages(String text) {
        this.text = text;
    }

    public String getError() {
        return text;
    }
}
