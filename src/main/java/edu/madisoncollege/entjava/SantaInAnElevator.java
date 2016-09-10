package edu.madisoncollege.entjava;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.*;

/**
 * Created by paulawaite on 9/7/16.
 *
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 *
 * Here is the problem to solve:
 *
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3.
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 *
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 *
 * Do NOT create a main method in your application, you will use only unit tests to find the answer.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 *
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 *
 */

public class SantaInAnElevator {

    private int currentFloor = 0;
    private final Logger logger = Logger.getLogger(this.getClass());

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Method to read each char from the input file and start processing each
     * individual token
     */

    public void readFile(String filePath) {

        BufferedReader input = null;
        try {
            //String filePath = "/home/student/Documents/EnterpriseRepos/santa-in-an-elevator-week-2-exercise-1-SSAJJALA/src/main/resources/SantaUpDown.txt";
            input = new BufferedReader(new FileReader(filePath));

            int c = 0;
            while((c = input.read()) != -1) {
                char character = (char) c;
                logger.info("character:" + character);
                this.handleDirection(character);
            }

            this.printFinalFloor();



        } catch (FileNotFoundException fnfe) {
            //System.out.println("Could not find the file");
            logger.info("Could not find the file");
            fnfe.printStackTrace();
        } catch (IOException io) {
            //System.out.println("Could not write the file");
            logger.info("Could not write the file");
            io.printStackTrace();
        } catch (Exception ex) {
            //System.out.println("Something bad happened");
            logger.info("Something bad happened");
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException io2){
                    //System.out.println("Could not close the file");
                    logger.info("Something bad happened");
                    io2.printStackTrace();
                }
            }
        }

    }

    public void handleDirection(char dir) {
        if (dir == '(') {
            this.handleGoingUp();
        } else if (dir == ')') {
            this.handleGoingDown();
        } else {
            logger.info("character:" + dir + "no direction for this character and skipping");
        }
    }


    public void handleGoingUp() {

        currentFloor++;
    }

    public void handleGoingDown() {
        currentFloor--;

    }

    public void printFinalFloor() {

        logger.info("At the end, Santa is at" + currentFloor + "finally");
    }
}