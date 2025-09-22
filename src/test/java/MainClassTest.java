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
    }

