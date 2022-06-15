import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveCalculatorTest {

    @DataProvider
    public Object[][] positiveData(){
        return new Object[][]{
                {"+","1","2",3},
                {"-","1","1",0},
                {"*","5","5",25},
                {"/","12","2",6},
                {"-",Integer.toString(Integer.MAX_VALUE),"123",Integer.MAX_VALUE-123},
                {"+",Integer.toString(Integer.MIN_VALUE),"123",Integer.MIN_VALUE+123},
                {"+","0.2","0.3",0.5},
                {"/","1.25","5",0.25},
                {"-", "2.0","1.1",0.8999999999999999}
        };
    }

    @Test(dataProvider="positiveData")
    public void positiveTest(String operator,String arg1, String arg2, double result){
        try {
            Double resultWrap=(Double)result;
            Assert.assertEquals(resultWrap.toString(), Calculator.execute(new String[]{operator,arg1,arg2}),"not equals");

        }catch (CalculatorException e){
            e.printStackTrace();
        }


    }
}