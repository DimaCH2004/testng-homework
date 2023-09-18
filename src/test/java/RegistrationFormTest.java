import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationFormTest extends ConfigTests{
    @Test
    @Parameters({"firstName", "lastName", "gender", "mobileNumber"})
    public void testFormSubmission(String firstName, String lastName, String gender, String mobileNumber) {
        // Fill in the form
        Selenide.$("#firstName").setValue(firstName);
        Selenide.$("#lastName").setValue(lastName);
        String jsCommand = "arguments[0].checked = true;";
        Selenide.executeJavaScript(jsCommand, Selenide.$("input[value='" + gender + "']"));
        Selenide.$("#userNumber").setValue(mobileNumber);
        // Validate
        String actualFirstName = Selenide.$("#firstName").getValue();
        String actualLastName = Selenide.$("#lastName").getValue();
        Assert.assertEquals(actualFirstName, firstName);
        Assert.assertEquals(actualLastName, lastName);
    }
}
