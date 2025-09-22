import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber () {
        int expectedNumber = 14;
        int actualNumber = this.getLocalNumber();
        Assert.assertEquals("Число " + actualNumber + ", не равно " + expectedNumber , actualNumber, expectedNumber);
    }

    @Test
    public void testGetClassNumber() {
        int expectedNumber = 45;
        int actualNumber = this.getClassNumber();
        Assert.assertTrue("Число " + actualNumber + ", меньше " + expectedNumber , actualNumber > expectedNumber);
    }

    @Test
    public void testGetClassString () {
        String expectedText1 = "hello";
        String expectedText2 = "Hello";
        String actualText = this.getClassString();
        Assert.assertTrue("Строка «" + actualText + "» должна содержать подстроку " + expectedText1 + " или " + expectedText2 , actualText.contains(expectedText1) || actualText.contains(expectedText2));
    }
}

