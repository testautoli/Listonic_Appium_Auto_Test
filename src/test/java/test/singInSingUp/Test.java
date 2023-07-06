package test.singInSingUp;

import org.testng.annotations.AfterTest;
import utils.DriverFactory;

public class Test {

    @org.testng.annotations.Test
    public void testtest(){

    }

    @AfterTest
    public void threadDown(){
        DriverFactory.resetDriver();
    }
}
