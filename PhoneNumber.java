import java.lang.reflect.Array;
import java.util.ArrayList;

public class PhoneNumber {
    private long number;
    private String[] options;

    public PhoneNumber() {
    }

    public PhoneNumber(long number) {
        this.number = number;
        System.out.println(getOptions2DArray());
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public char[][] getOptions2DArray() {
        String stringNum = "" + number;
        char[][] TwodOptions = new char[stringNum.length()][];
        for (int i = 0; i < stringNum.length(); i++) {
            char digit = stringNum.charAt(i);
            if (digit == '0' || digit == '1') {
                TwodOptions[i] = new char[] { ' ' };
            } else if (digit == '2') {
                TwodOptions[i] = new char[] { 'a', 'b', 'c' };
            } else if (digit == '3') {
                TwodOptions[i] = new char[] { 'd', 'e', 'f' };
            } else if (digit == '4') {
                TwodOptions[i] = new char[] { 'g', 'h', 'i' };
            } else if (digit == '5') {
                TwodOptions[i] = new char[] { 'j', 'k', 'l' };
            } else if (digit == '6') {
                TwodOptions[i] = new char[] { 'm', 'n', 'o' };
            } else if (digit == '7') {
                TwodOptions[i] = new char[] { 'p', 'q', 'r', 's' };
            } else if (digit == '8') {
                TwodOptions[i] = new char[] { 't', 'u', 'v' };
            } else if (digit == '9') {
                TwodOptions[i] = new char[] { 'w', 'x', 'y', 'z' };
            }
        }
        return TwodOptions;
    }
    
    public ArrayList<String> getOptions(int start) {
        //loops through every posibility of options and adds them to an arraylist
        if (start == 0) {
            ArrayList<String> options = new ArrayList<String>();
        }
        return 
    }
}
