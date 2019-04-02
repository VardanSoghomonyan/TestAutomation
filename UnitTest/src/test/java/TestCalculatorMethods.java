import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class TestCalculatorMethods {
//    @BeforeMethod
//    static Scanner enteredInt = new Scanner(System.in);



    @Test
    public void checkAddition(){
//        int a = enteredInt.nextInt(), b = enteredInt.nextInt();
        Assert.assertEquals(Calculator.addition(), 11);
    }
}
