import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryRegistrationFormTest extends ConfigTests {
        private String firstName;
        private String lastName;
        private String gender;
        private String mobileNumber;

        @Factory(dataProvider = "formDataProvider", dataProviderClass = DataProviderClass.class)
        public FactoryRegistrationFormTest(String firstName, String lastName, String gender, String mobileNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.mobileNumber = mobileNumber;
        }

        @Test
        public void testFormSubmission() {
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

