import java.util.Scanner;

public class LogicKnowledge {
    public static void main(String[] args) {
        //declare Scanner for user input
        Scanner s = new Scanner(System.in);

        //gui for greenTicket
        System.out.println("-> Input 3 ints (lottery numbers) for greenTicket: ");
        System.out.print(" Int 1: ");
        int a = s.nextInt();
        System.out.print(" Int 2: ");
        int b = s.nextInt();
        System.out.print(" Int 3: ");
        int c = s.nextInt();

        //returns int value of greenTicket
        int returnValue = greenTicket(a, b, c);
        System.out.println("Returning: " + returnValue);


        //gui for makeChocolate
        System.out.println("-> Provide small bars (1lbs), large bars (5lbs), and goal (in lbs): ");
        System.out.print(" Small bars: ");
        int small = s.nextInt();
        System.out.print(" Large bars: ");
        int large = s.nextInt();
        System.out.print(" Goal: ");
        int goal = s.nextInt();

        //returns int value of makeChocolate
        int numToUse = makeChocolate(small, large, goal);
        System.out.println("Lbs required: " + numToUse);
    }

    public static int greenTicket(int a, int b, int c) {
        //uses conditional logic to narrow which, if any, values match
        if (a == b && b == c) {
            return 20;
        } else if (a == b || b == c || c == a) {
            return 10;
        } else {
            return 0;
        }
    }

    public static int makeChocolate(int small, int large, int goal) {
        int remainingLbs = -1;
        //intentional cast to an int to round down, seeing how many times 5lbs goes into the goal
        int withoutExcess = Math.abs(goal / 5);

        //will check for if large has an excess from goal, and only use required if it does
        //as long as it doesn't reach the amount of times 5 could go into the goal,
        //it will see if the goal - large is enough for the small to cover
        //if it is, it will print that goal - large which is all that is required from small

        if (large * 5 > goal) {
            if (large >= withoutExcess) {
                return goal - withoutExcess * 5;
            } else if (small >= goal - large * 5) {
                return goal - large * 5;
            }
        } else {
            remainingLbs = goal - large * 5;
        }

        if (remainingLbs > 0 && small >= remainingLbs) {
            return remainingLbs;
        }
        return -1;
    }
}
