import model.Calculator;
import model.CalculatorException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {

    @DataProvider
    public Object[][] negativeData() {

        return new Object[][]{
                {"plus", "1", "2"},
                {"-", null, "1"},
                {null, "5", "five"},
                {"/", "12", "0"}
        };
    }

    @Test(dataProvider = "negativeData", expectedExceptions = CalculatorException.class)
    public void negativeTest(String operator, String arg1, String arg2) {
        /*try {
            Calculator.execute(new String[]{operator, arg1, arg2});
        } catch (CalculatorException e) {
            e.printStackTrace();
        }*/
        Calculator.execute(new String[]{operator,arg1,arg2});

    }
}
