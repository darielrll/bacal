
package drll.problems.solveMeFirst;

import java.util.Scanner;

public class SolveMeFirst {

    public static int solveMeFirst(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;

        sum = SolveMeFirst.solveMeFirst(a, b);
        System.out.println(sum);
    }
}