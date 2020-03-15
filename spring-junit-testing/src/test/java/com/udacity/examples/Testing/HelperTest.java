package com.udacity.examples.Testing;


import org.junit.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HelperTest {

    @Ignore
    @Test
	public void test() {
        assertEquals("","");
    }

    @Test
    public void verify_getCount() {
        List<String> empNames = Arrays.asList("sareeta", "piyush");
        final long actual = Helper.getCount(empNames);
        assertEquals(2, actual);
    }

    @Test
    public void verify_getStats() {
        List<Integer> yrsOfExperience = Arrays.asList(13, 4, 15, 6, 17, 8, 19, 1, 2, 3);
        List<Integer> expectedList = Arrays.asList(13, 4, 15, 6, 17, 8, 19, 1, 2, 3);
        IntSummaryStatistics stats = Helper.getStats(yrsOfExperience);
        assertEquals(19, stats.getMax());
        assertEquals(expectedList, yrsOfExperience);
    }

    @Test
    public void compare_arrays() {
        int[] yrs = {10, 14, 2};
        int[] expectedYrs = {10, 14, 2};
        assertArrayEquals(expectedYrs, yrs);
    }

    // Executed before each test
    @Before
    public void init() {
        // setup before each test
        System.out.println("runs before each test method");
    }

    // Executed before each test class
    // This method must be static
    @BeforeClass
    public static void setup() {
        System.out.println("runs before each class");
    }

    @After
    public void initEnd() {
        System.out.println("runs before each test method");
    }

    @AfterClass
    public static void teardown() {
        System.out.println("runs before each class");
    }
}
