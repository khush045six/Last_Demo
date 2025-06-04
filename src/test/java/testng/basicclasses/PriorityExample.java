package testng.basicclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityExample {

    @BeforeMethod(groups = {"smoke"})
    public void testCaseZ(){
        System.out.println("TESTCASEz");
    }

    @Test
    public void testCaseL(){
        System.out.println("TESTCASEl");
    }
    @Test(priority = 'Z',groups = {"smoke"})
    public void testCaseP(){
        System.out.println("TESTCASEp");
    }

    @Test(priority = 2, groups = {"smoke"})
    public void testCaseD(){
        System.out.println("TESTCASEd");
    }
}
