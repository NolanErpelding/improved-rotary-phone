import java.util.ArrayList;

public class PhoneNumber {
    private long number;
    private ArrayList<String> options;

    public PhoneNumber() {
    }

    public PhoneNumber(long number) {
        initialize(number);
    }

    public PhoneNumber(String number) {
        long num = 0;
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
        }
        initialize(num);
    }

    private void initialize(long number) {
        this.number = number;
        ArrayList<String> blank = new ArrayList<String>();
        this.options = getOptions(blank, getOptions2DArray(), 0);

        System.out.println("Options before sifting: " + options.size());
        this.siftOptions();
        System.out.println("Options after sifting: " + options.size());

        for (char[] arr : getOptions2DArray()) {
            System.out.print("[");
            for (char c : arr) {
                System.out.print(c + ",");
            }
            System.out.println("]");
        }
        System.out.println("Options: ");
        System.out.println(options);
    }

    public long getNumber() {
        return number;
    }

    public ArrayList<String> getOptions() {
        return options;
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
    
    public ArrayList<String> getOptions(ArrayList<String> options, char[][] TwodOptions, int start) {
        if (start >= TwodOptions.length) {
            return options;
        }
        if (start == 0) {
            for (char c : TwodOptions[0]) {
                options.add("" + c);
            }
        } else {
            for (int i = options.size() - 1; i >= 0; i--) {
                String option = options.remove(i);
                for (char c : TwodOptions[start]) {
                    options.add(option + c);
                }
            }
        }
        return getOptions(options, TwodOptions, start + 1);
    }

    public void siftOptions() {
        for (int i = options.size() - 1; i >= 0; i--) {
            String option = options.get(i);
            if (!Words.containsWord(option)) {
                options.remove(i);
            }
        }
    }

    public ArrayList<Integer> vedant(String largeString, String smallString) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0, j = smallString.length(); j <= largeString.length(); i++, j++) {
            if (largeString.substring(i, j).equals(smallString)) {
                indices.add(i);
            }
        }
        return indices;
    }
}
