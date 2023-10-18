import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class StringKnowledge {

    public static void main(String[] args) {
        //declare scanner for user input
        Scanner s = new Scanner(System.in);

        //gui for endOther
        System.out.println("-> Two strings to check endOther: ");
        System.out.print(" String 1: ");
        String a = s.nextLine();
        System.out.print(" String 2: ");
        String b = s.nextLine();

        //returns bool value of endOther
        boolean stringConnect = endOther(a, b);
        System.out.println("checkOther: " + stringConnect);

        //gui for findRepeats
        System.out.println("-> String to check findRepeats: ");
        System.out.print(" String: ");
        String toTest = s.nextLine();

        //returns bool value of findRepeats
        boolean repeats = findRepeats(toTest);
        System.out.println(repeats);
    }

    public static boolean endOther(String a, String b) {
        //checks ending by using a method in the string library "endsWith(String suffix)", as per oracle
        //returns boolean comparison value if either end with the other
        return a.toLowerCase().endsWith(b.toLowerCase()) || b.toLowerCase().endsWith(a.toLowerCase());
    }

    public static boolean findRepeats(String toTest) {

        ///Remove comment below to check repeats without including spaces
        //toTest = toTest.replaceAll("\\s", "");

        //makes an array for the substrings, breaks the string into chars, then defines vars for the for loop
        String[] substrings = new String[toTest.length()];
        char[] charTest = toTest.toCharArray();
        char c1;
        char c2;
        String addChar;

        //adds every char group of 2 in the string together to substrings[]
        for (int i = 0; i < toTest.length() - 1; i++) {
            c1 = toTest.charAt(i);
            c2 = toTest.charAt(i + 1);
            addChar = Character.toString(c1) + Character.toString(c2);
            substrings[i] = addChar;
        }

        ///Remove comment below to see the individual substrings checked
        //System.out.println(Arrays.toString(substrings));

        //checks each substring in the group against every other substring in group
        for (int i = 0; i < substrings.length - 1; i++) {
            for (int j = i + 1; j < substrings.length; j++) {
                if (substrings[i].equals(substrings[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
