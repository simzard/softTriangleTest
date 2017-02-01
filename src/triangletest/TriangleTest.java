/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangletest;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author simon
 */
public class TriangleTest {

    public static void testCases() {
        // my test strategy: pick one representative from each return case
        System.out.println(getTriangleType(1, 1, 1));
        System.out.println(getTriangleType(4, 5, 6));
        System.out.println(getTriangleType(5, 5, 4));
        System.out.println(getTriangleType(7, -1, 5));
        System.out.println(getTriangleType(1, 2, 3));

    }

    /**
     * Method that reports the type of a triangle
     *
     * @param a length of first side of the triangle
     * @param b length of second side of the triangle
     * @param c length of third side of the triangle
     */
    public static String getTriangleType(double a, double b, double c) {
        /*
        // check if valid input lengths are provided
        if (a <= 0 || b <= 0 || c <= 0) {
            return "not a triangle - lengths must be positive";
        }
        */

        // check that it is actually a triangle by using the triangle inequality
        // it states that the sum of 2 chosen sides must be larger than the third
        // test for each pair
        if (!(a + b > c && a + c > b && b + c > a)) {
            return "not a triangle - the sum of two sides should always be larger than the third.";
        }

        if (a == b && b == c) {
            return "equilateral";
        }

        if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            // if it is not equilateral and not isosceles it must be scalene
            return "scalene";
        }
    }

    /**
     *  Wrap around method to prevent faulty input
     */
    public static double getRobustInput(String number) {
        Scanner scanner = new Scanner(System.in);
        double input = 0;
        while (input < 1) {
            try {
                System.out.print(number + ": ");
                input = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Not valid side - please try again...");
                // skip the input
                scanner.next();
                continue;
            }
        }
        return input;
    }
    
    /**
     * Program that asks for three numbers, that each represents the three sides
     * of a triangle and outputs if it is a triangle and also its type
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Enter the length of 3 sides of a triangle...");

        double a = getRobustInput("a");
        double b = getRobustInput("b");
        double c = getRobustInput("c");

        System.out.print("These 3 lengths means that the triangle is " + getTriangleType(a, b, c) + ".");

        //testCases();
    }

    

}
