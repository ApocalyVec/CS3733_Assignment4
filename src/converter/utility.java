package converter;

import java.util.ArrayList;
import java.util.HashMap;

public class utility {


    String EString = "MDeCLmXVwI";

    public utility() {}

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public boolean isValidLetter(char c) {
        return EString.contains(String.valueOf(c));
    }
    public boolean isMultipleof10(char c) {
        return (c == 'M' || c == 'C' || c == 'X' || c =='I');
    }

    public boolean isTwice(int selfIndex, char c, String number) {
        for(int i = 0; i < number.length(); i++) {
            if(c == number.charAt(i) && i != selfIndex) {
                return true;
            }
        }
        return false;
    }

    public boolean XInARow(int X, int index, String number) {//don't use 1 for X
        if(number.length() < X + index) {
            return false;
        }

        char key = number.charAt(index);
        for (int i = index + 1; i < index + (X-1); i++) {
            if (number.charAt(i) != key) {
                return true;
            }
        }
        if (key == number.charAt(index + X)) {
            return false;
        }
        else return true;
    }

    public boolean inOrder(char c, char next_c) {
        switch(c) {
            case 'D':
                if(EString.substring(0, 0).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'e':
                if(EString.substring(0, 1).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'C':
                if(EString.substring(0, 2).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'L':
                if(EString.substring(0, 3).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'm':
                if(EString.substring(0, 4).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'X':
                if(EString.substring(0,5).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'V':
                if(EString.substring(0, 6).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'w':
                if(EString.substring(0, 7).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            case 'I':
                if(EString.substring(0, 8).contains(String.valueOf(next_c))) {
                    return false;
                }
                break;
            default: // in case of 'M'
                return true;
        }
        return true;
    }

    public int CharToNumber(char c) {
        switch (c) {
            case 'I':  return 1;
            case 'w':  return 4;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'm':  return 40;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'e':  return 400;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:
                System.out.println("This should never happen");
                return -1;
        }
    }
}
