package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.List;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;
    private final boolean isArabic;

    //default constructor
    public ElbonianArabicConverter() {
        number = "";
        isArabic = true;
    }

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        utility u = new utility();

        if(u.isNumeric(number)) {
            isArabic = true;
        }
        else isArabic = false;

        this.number = number;

        try{
            for(int i=0; i<number.length(); i++){
                char currChar = number.charAt(i);
                if(!u.isValidLetter(currChar)){
                    throw new MalformedNumberException("Invalid Letter: "+ number.charAt(i));
                }

                if(u.isMultipleof10(currChar)) {
                    if(u.XInARow(3, i, number)) {
                        throw new MalformedNumberException("More than 4 of 10's multiples in a row starting at " + i + ", The letter is " + currChar);
                    }
                }
                else { //not a multiple of 10
//                    if(u.XInARow(2,i,number)) {
//                        throw new MalformedNumberException("More than 2 of non-10's multiples in a row starting at " + i + ", The letter is " + currChar);
//                    }
                    if(u.isTwice(i, currChar, number)) {
                        throw new MalformedNumberException("More than 2 of non-10's multiples found, the character is " + currChar);
                    }
                }


            }

        } catch (MalformedNumberException e){}


    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body

        return 1;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

}
