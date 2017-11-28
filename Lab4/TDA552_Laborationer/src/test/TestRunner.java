package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * Created by phiwar on 2017-11-02.
 */
public class TestRunner {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(CarTest.class, Saab95Test.class, Volvo240Test.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }

}
