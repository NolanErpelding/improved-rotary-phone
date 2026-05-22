import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Lets go andrew.");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a phone number: ");
        long number = input.nextLong();
        PhoneNumber phone = new PhoneNumber(number);
        for (char[] options : phone.getOptions2DArray()) {
            System.out.print("[");
            for (char option : options) {
                System.out.print(option + " ");
            }
            System.out.println("]");
        }
    }
}