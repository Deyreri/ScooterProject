import ScooterProject.BaseTest;
import org.junit.jupiter.api.Test;

import static ScooterProject.textFields.AccordionText.*;

public class testAcc extends BaseTest {
    @Test
    public void checkDropdownText() {
        mainPage.clickSection(0)
                .checkTextSection(0, FIRST.getText())
                .clickSection(1)
                .checkTextSection(1, SECOND.getText())
                .clickSection(2)
                .checkTextSection(2, THIRD.getText())
                .clickSection(3)
                .checkTextSection(3, FOURTH.getText())
                .clickSection(4)
                .checkTextSection(4, FIFTH.getText())
                .clickSection(5)
                .checkTextSection(5, SIXTH.getText())
                .clickSection(6)
                .checkTextSection(6, SEVENTH.getText());
    }
}
