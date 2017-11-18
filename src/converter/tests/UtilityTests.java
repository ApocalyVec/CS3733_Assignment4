package converter.tests;

import com.sun.javafx.scene.layout.region.Margins;
import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import converter.utility;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class  UtilityTests{

    @Test
    public void isNumericTest() {
        utility u = new utility();
        assertTrue(u.isNumeric("123"));
        assertTrue(!u.isNumeric("abc"));
    }

    @Test
    public void isValidLetterTest() {
        utility u = new utility();
        assertTrue(u.isValidLetter('M'));
        assertTrue(!u.isValidLetter('n'));
    }

    @Test
    public void XInARowTest() {
        utility u = new utility();
        assertTrue(!u.XInARow(3,0, "I"));
        assertTrue(u.XInARow(3,0, "XXXCC"));
        assertTrue(!u.XInARow(3,1, "MCCCCI"));
        assertTrue(u.XInARow(3, 2, "MMSSSIIIIIIIIIII"));
        assertTrue(u.XInARow(3,0, "MCCM"));
        assertTrue(u.XInARow(2,0, "MMCI"));
    }

    @Test
    public void isMultipleof10Test() {
        utility u = new utility();
        assertTrue(u.isMultipleof10('M'));
        assertTrue(u.isMultipleof10('C'));
        assertTrue(u.isMultipleof10('X'));
        assertTrue(u.isMultipleof10('I'));
        assertTrue(!u.isMultipleof10('m'));
        assertTrue(!u.isMultipleof10('e'));
    }

    @Test
    public void isTwiceTest() {
        utility u = new utility();
        assertTrue(u.isTwice(1, 'c', "ccaabb"));
        assertTrue(u.isTwice(0, 'c', "ccaabb"));
        assertTrue(!u.isTwice(0,'e', "ebapdj"));
    }

    @Test
    public void inOrderTest() {
        utility u = new utility();
        assertTrue(u.inOrder('M', 'D'));
        assertTrue(u.inOrder('I', 'I'));
        assertTrue(u.inOrder('M', 'M'));
        assertTrue(u.inOrder('M', 'I'));
        assertTrue(u.inOrder('C', 'm'));
        assertTrue(!u.inOrder('I', 'M'));
        assertTrue(!u.inOrder('w', 'X'));
    }
}
