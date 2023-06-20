package it.unipd.dei.eis.testing;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestsTest {

//    private static int processedTestCount = 0;
    private int processedTestCount = 0;

    @Test
    @Order(1)
    void firstOne() {
        processedTestCount++;
        assertEquals(1, processedTestCount);
    }

    @Test
    @Order(2)
    void secondOne() {
        processedTestCount++;
        assertEquals(2, processedTestCount);

    }

}
