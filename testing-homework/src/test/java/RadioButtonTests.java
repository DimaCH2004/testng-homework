import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTests extends ConfigTests {
    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://demoqa.com/radio-button";
        open(Configuration.baseUrl);
    }
    @Test
    public void selectYesOption() {
        SelenideElement yesRadioButton = $(".custom-control-label");
        yesRadioButton.click();
        softAssert.assertTrue(false);
        softAssert.assertAll();// რატომღაც AfterMethod-ში არ იმუშავა ამიტომ არის აქ
    }
    @Test
    public void checkNoOptionAvailability() {
        SelenideElement noRadioButton = $("#noRadio");
        softAssert.assertTrue(noRadioButton.isEnabled());
        softAssert.assertAll();// რატომღაც AfterMethod-ში არ იმუშავა ამიტომ არის აქ
    }
}
