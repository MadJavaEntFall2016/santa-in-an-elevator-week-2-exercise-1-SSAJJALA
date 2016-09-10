package edu.madisoncollege.entjava;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Created by Siva Sajjala on 9/10/16.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SantaInAnElevatorTest {
    SantaInAnElevator santa = new SantaInAnElevator();

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testAhandleDirection() throws Exception {
        String directions = "(())";
        for(int i = 0; i < directions.length(); i++) {
            santa.handleDirection(directions.charAt(i));
        }
        assertEquals("Test failed for method handleDirection",0,santa.getCurrentFloor());

    }

    @Test
    public void testBhandleGoingUp() throws Exception {
        santa.handleGoingUp();
        assertEquals("Test failed for method handleGoingUp",1,santa.getCurrentFloor());

    }


    @Test
    public void testChandleGoingDown() throws Exception {
        santa.handleGoingDown();
        assertEquals("Test failed for method handleGoingDown",-1,santa.getCurrentFloor());
    }

    @Test (expected = java.io.IOException.class)
    public void testDreadFileNotFound() throws Exception {
        String filePath = "SantaUpDown.txt";
        santa.readFile(filePath);

    }

    @Test
    public void testEreadFile() throws Exception {
        String filePath = "/home/student/Documents/EnterpriseRepos/santa-in-an-elevator-week-2-exercise-1-SSAJJALA/src/main/resources/SantaUpDown.txt";
        santa.readFile(filePath);
        assertNotNull("Santa's final floor can not be null", santa.getCurrentFloor());
    }

    @Test
    public void testFgetFinalFloor() throws Exception {

        assertNotNull("Santa's final floor can not be null", santa.getFinalFloor());

    }

}