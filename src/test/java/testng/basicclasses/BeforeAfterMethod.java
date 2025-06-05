package testng.basicclasses;

import org.testng.annotations.*;

public class BeforeAfterMethod {


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BEFOREMETHOD");
    }

    @Test
    public void testCase1() {
        System.out.println("TESTCASE1");
        System.out.println("Hello World");
        System.out.println("Hi Friends..................");

    }

    @Test(groups = {"smoke"})
    public void testCase2() {
        System.out.println("TESTCASE2");
    }

    @Test
    public void testCase3() {
        System.out.println("TESTCASE3");
    }

    @Test
    public void testCase4() {
        System.out.println("TESTCASE4");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AFTERMETHOD");
    }

//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("BEFORECLASS");
//    }
//
//    @AfterClass
//    public void afterClass(){
//        System.out.println("AFTERCLASS");
//    }
}
