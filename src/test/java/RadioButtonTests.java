import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class RadioButtonTests extends ConfigTests {
    @Test(groups = {"FrontEnd"}, priority = 2)
    public void selectYesOption() {
        SelenideElement yesRadioButton = $(".custom-control-label");
        yesRadioButton.click();
        softAssert.assertTrue(false);
        softAssert.assertAll();// რატომღაც AfterMethod-ში არ იმუშავა ამიტომ არის აქ
    }
    @Test(groups = {"BackEnd"}, priority = 1)
    public void checkNoOptionAvailability() {
        SelenideElement noRadioButton = $("#noRadio");
        softAssert.assertTrue(noRadioButton.isEnabled());
        softAssert.assertAll();// რატომღაც AfterMethod-ში არ იმუშავა ამიტომ არის აქ
    }
}
