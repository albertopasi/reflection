package it.unipd.dei.eis.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AssertExamplesTest {


    @Test
    void testAssert() {

//        assertEquals(4.322d,4.32d,0.001);
        assertEquals(4.322d, 4.32d, 0.01);

        assertTrue('a' < 'b', "optional failure message");

        assertFalse('a' > 'b', "optional failure message");

        String s = "pippo";

        assertNotNull(s, "optional failure message");

        s = null;

        assertNull(s, "optional failure message");

//        assertNotNull(s, "The string is null!");

    }

    @Test
    void groupedAssertions() {

        User user = new User("pluto", 17);

        assertAll("user data",
                () -> assertEquals("pluto", user.getName()),
                () -> assertEquals(17, user.getAge())
        );

//        assertAll("user data",
//                () -> assertEquals("pluto", user.getName()),
//                () -> assertEquals(19, user.getAge())
//        );

    }


}
