package edu.madisoncollege.entjava;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Practice working with JUnit by writing some test cases for the Interface List<E>:
 * 1.1 void add(int index, E e)
 * 1.2 void remove(int index)
 * 1.3 void get(int index)
 *
 * Add at least one test for an exception.
 */
public class ListTest {

    private static List<String> myList;

    @BeforeClass
    public static void setup() {
        myList = new ArrayList<String>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");
    }

    @Test
    public void testAddSuccess() {
        String elementToInsert = "Item 4";

        myList.add(elementToInsert);
        assertEquals("List size is incorrect", 4, myList.size());
        assertTrue("List missing inserted element", myList.contains(elementToInsert));
    }

    @Test
    public void testRemoveSuccess() {
        myList.remove(3);
        assertEquals("List size is incorrect", 3, myList.size());
        assertFalse("List shouldn't contain the element Item 4", myList.contains("Item 4"));
    }

    @Test
    public void testGetSuccess() {
        assertEquals("List item at index 2 is incorrect", "Item 3", myList.get(2));
    }

    @Test
    public void testOutOfBoundExcp() {
        try {
            String item4 = myList.get(3);

        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            String exception = anIndexOutOfBoundsException.getMessage();
            assertEquals("Exception message doesn't match", "Index: 3, Size: 3", exception);

        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testOutOfBoundExcp1() throws IndexOutOfBoundsException {

        thrown.expect(IndexOutOfBoundsException.class);
        //thrown.expectMessage("Index: 3, Size: 3");
        String item5 = myList.get(4); // execution will never get past this line
    }


}