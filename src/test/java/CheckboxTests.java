import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxTests extends ConfigTests {
    List<SelenideElement> checkboxes = $$("#checkboxes input");
    SoftAssert softAssert = new SoftAssert();
    @Test(groups = {"FrontEnd"})
    public void uncheckCheckbox() {
        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
                softAssert.assertTrue(checkbox.isSelected(), "Checkbox should be unchecked");
            }
        }
        softAssert.assertAll();// რატომღაც AfterMethod-ში არ იმუშავა ამიტომ არის აქ
    }
    @Test(groups = {"BackEnd"})
    public void checkCheckbox() {
        for (SelenideElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
                softAssert.assertFalse(checkbox.isSelected(), "Checkbox should be checked");
            }
        }
        softAssert.assertAll(); // რატომღაც AfterMethod-ში არ იმუშავა ამიტომ არის აქ
    }
}
