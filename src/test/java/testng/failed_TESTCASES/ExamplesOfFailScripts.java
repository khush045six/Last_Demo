package testng.failed_TESTCASES;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExamplesOfFailScripts {
    @Test(retryAnalyzer = RetryScriptMechanism.class)
    public void failScriptA(){
        Assert.assertFalse(true);

    }
    @Test
    public void failScriptB(){
        Assert.assertFalse(true);

    }
    @Test
    public void failScriptC(){
        System.out.println("failScriptC");

    }
    @Test
    public void failScriptD(){
        System.out.println("failScriptD");

    }
    @Test
    public void failScriptE(){
        System.out.println("failScriptE");

    }

}
