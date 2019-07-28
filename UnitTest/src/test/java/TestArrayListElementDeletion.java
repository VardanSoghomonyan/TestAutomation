import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayListElementDeletion {
    static ArrayList<Integer> a;

    @BeforeMethod
    public static void createArray() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(45, 8, 15, 99, 4, 81, 18, 28, 78, 20));
        a = array1;
    }

    @Test
    public static void checkArrayList() {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(45, 8, 15, 99, 4, 18, 28, 78, 20));
        Assert.assertEquals(DeleteElementFromArrayList.insertNumber(a, 5), result);
    }

    @Test
    public static void checkArrayListNegative() {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(45, 8, 15, 99, 4, 18, 28, 78, 20));
        Assert.assertNotEquals(DeleteElementFromArrayList.insertNumber(a, 6), result);
    }
}
