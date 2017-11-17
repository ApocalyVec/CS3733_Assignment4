package converter;

public class utility {


    public utility() {
    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public boolean isValidLetter(char c) {
        return (c == 'M' || c == 'C' || c == 'X' || c == 'I' || c == 'D' || c == 'L' || c == 'e' || c == 'm' || c == 'V' || c == 'w');
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
}
