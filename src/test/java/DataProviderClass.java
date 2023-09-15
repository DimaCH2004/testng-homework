import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "formDataProvider")
    public static Object[][] formDataProvider() {
        return new Object[][] {
                {"John", "Doe", "Male", "1234567890"},
                {"Jane", "Doe", "Female", "0987654321"},
                {"Sam", "Smith", "Male", "1122334455"}
        };
    }
}
