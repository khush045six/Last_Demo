package testng.basicclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InnvocationCount {
    @BeforeMethod
    public void testCaseZ(){
        System.out.println("TESTCASEz");
    }

    @Test//(invocationCount = 2,invocationTimeOut = 1)
    public void testCaseL(){
        System.out.println("TESTCASEl");
    }
    @Test(priority = 'Z')
    public void testCaseP(){
        System.out.println("TESTCASEp");
    }

    @Test(priority = 2)
    public void testCaseD(){
        System.out.println("TESTCASEd");
    }
}

