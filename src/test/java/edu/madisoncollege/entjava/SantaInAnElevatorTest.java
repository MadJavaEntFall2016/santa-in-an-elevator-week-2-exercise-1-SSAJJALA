package edu.madisoncollege.entjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Siva Sajjala on 9/10/16.
 */
public class SantaInAnElevatorTest {
    SantaInAnElevator santa = new SantaInAnElevator();

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void handleDirection() throws Exception {
        String directions = "(())";
        for(int i = 0; i < directions.length(); i++) {
            santa.handleDirection(directions.charAt(i));
        }
        assertEquals("Test failed for method handleDirection",0,santa.getCurrentFloor());

    }

    @Test
    public void handleGoingUp() throws Exception {
        santa.handleGoingUp();
        assertEquals("Test failed for method handleGoingUp",1,santa.getCurrentFloor());

    }


    @Test
    public void handleGoingDown() throws Exception {
        santa.handleGoingDown();
        assertEquals("Test failed for method handleGoingDown",0,santa.getCurrentFloor());
    }

    @Test
    public void readFile() throws Exception {

    }

    @Test
    public void printFinalFloor() throws Exception {

    }

}