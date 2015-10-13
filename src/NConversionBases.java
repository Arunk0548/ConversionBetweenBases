import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author arun.k
 */
public class NConversionBases {

    public static String convertDecimaltoBases(int number, int base) {

        if (base <= 1 || base > 16) {
            return "Invalid number base, it must be [2-16]";
        }

        char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
            'B', 'C', 'D', 'E', 'F'};
        String convertedNum = "";

        do {
            convertedNum += array[number % base];
            number = number / base;
        } while (number != 0);

        convertedNum = new StringBuilder(convertedNum).reverse().toString();

        return convertedNum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Enter number in base 10:");
            int number = input.nextInt();
            if(!(number >=0 && number <=256))
            {
                System.out.println("Input must be a non-negative number from 0 to 256 inclusive.");
                return ;
            }
            System.out.println("Enter base:");
            int base = input.nextInt(16);

            input.close();

            System.out.println("Output:" + convertDecimaltoBases(number, base));
        } catch (InputMismatchException ex) {
            System.out.println("Input must be a non-negative number from 0 to 256 inclusive.");
        }
    }

}
