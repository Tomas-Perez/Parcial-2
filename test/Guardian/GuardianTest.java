package Guardian;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class GuardianTest {

    @Test
    public void removeFilter() throws Exception {
        Guardian<Integer> integerGuardian = new Guardian<Integer>();
        assertTrue(integerGuardian.goThrough(1));
        Predicate<Integer> lessThan5 = integer -> integer < 5;
        integerGuardian.addFilter(lessThan5);
        assertTrue(integerGuardian.goThrough(1));
        assertFalse(integerGuardian.goThrough(6));
        integerGuardian.removeFilter(lessThan5);
        assertTrue(integerGuardian.goThrough(6));
    }

    @Test
    public void getElementsAllowed() throws Exception {
        Guardian<Integer> integerGuardian = new Guardian<Integer>();
        assertTrue(integerGuardian.goThrough(1));
        Predicate<Integer> lessThan5 = integer -> integer < 5;
        integerGuardian.addFilter(lessThan5);
        assertTrue(integerGuardian.goThrough(1));
        assertFalse(integerGuardian.goThrough(6));
        assertEquals(2, integerGuardian.getElementsAllowed().size());
        assertEquals(new Integer(1), integerGuardian.getElementsAllowed().get(0));
        assertEquals(new Integer(1), integerGuardian.getElementsAllowed().get(1));
    }

    @Test
    public void goThrough() throws Exception {
        Guardian<Integer> integerGuardian = new Guardian<Integer>();
        assertTrue(integerGuardian.goThrough(1));
        integerGuardian.addFilter(e -> e < 5);
        assertTrue(integerGuardian.goThrough(1));
        assertFalse(integerGuardian.goThrough(6));
    }

}