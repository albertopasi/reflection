package it.unipd.dei.eis.testing;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectClasses({
        AssertExamplesTest.class,
        OrderedTestsTest.class,
        TimeoutTest.class
})
public class SuiteTest {

}
