import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveCalculatorTest {

    @DataProvider
    public Object[][] positiveData(){
        return new Object[][]{
                {"+","0.2","0.3",0.5},
                {"/","1.25","5",0.25},
                {"-", "2.0","1.1",0.8999999999999999},
                {"+","1","2",3},
                {"-","1","1",0},
                {"*","5","5",25},
                {"/","12","2",6},
                {"-",String.valueOf(Integer.MAX_VALUE),"123",Integer.MAX_VALUE-123},
                {"+",String.valueOf(Integer.MAX_VALUE-123),"122.99",Integer.MAX_VALUE-0.01},
                {"+",String.valueOf(Integer.MIN_VALUE+1),"123",Integer.MIN_VALUE+124}

        };
    }

    @Test(dataProvider="positiveData")
    public void positiveTest(String operator,String arg1, String arg2, double result){
        try {

            Assert.assertEquals(Calculator.execute(new String[]{operator, arg1, arg2}),String.format("%.3f", result));

        }catch (CalculatorException e){
            e.printStackTrace();
        }


    }
}