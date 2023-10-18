import java.util.Arrays;
import java.util.Scanner;

public class ArrayKnowledge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //gui for stringToArray
        System.out.println("Enter string to be broken down into chars for stringToArray: ");
        String string = s.nextLine();

        //returns an array of char from method, then makes it a string to be read by individual components
        String arrayPrint = Arrays.toString(stringToArray(string));
        System.out.println(arrayPrint);

        //gui for generateArrayWithBounds
        System.out.println("Enter start, end, and step length for generateArrayWithBounds: ");
        System.out.print("Start: ");
        int start = s.nextInt();
        System.out.print("End: ");
        int end = s.nextInt();
        System.out.print("Step: ");
        int step = s.nextInt();

        //returns int array value from generateArrayWithBounds in a similar fashion
        String arrayWithBounds = Arrays.toString(generateArrayWithBounds(start, end, step));
        System.out.println(arrayWithBounds);
    }

    public static char[] stringToArray(String string) {
        //constructs char array
        char[] Array = new char[string.length()];

        //puts every part of String in char array
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            Array[i] = c;
        }

        return Array;
    }

    public static int[] generateArrayWithBounds(int start, int end, int step) {

        //calculate how many steps it will take to get to the end from start from a step
        //to inclusively use the first (as in first example) but through int cast, not go over end
        int[] Array = new int[(end - start + step - 1) / step];

        //for the length of the array, make the index the start value plus the amount of steps
        //done for each index of array (step*i)

        for (int i = 0; i < Array.length; i++) {
            Array[i] = start + (step * i);
        }

        return Array;
    }
}
