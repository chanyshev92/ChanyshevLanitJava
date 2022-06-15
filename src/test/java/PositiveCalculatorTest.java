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
                {"/","12","2",6}
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