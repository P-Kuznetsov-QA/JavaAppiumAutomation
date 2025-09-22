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

}

