/* Ryan Lutz
 * 9/5/19
 * M1 Assignment 1 - Movie Ratings
 */
import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Create scanner
        System.out.println("Please enter ratings from the movie review website."); // Print to console
        int web1 = scan.nextInt(); // Get the three movie ratings from website
        int web2 = scan.nextInt();
        int web3 = scan.nextInt();
        System.out.println("Please enter ratings from the focus group."); // Print to console
        double foc1 = scan.nextDouble(); // Get the movie ratings from the focus group
        double foc2 = scan.nextDouble();
        System.out.println("Please enter the average movie critic rating."); // Print to console
        double crt = scan.nextDouble(); // Get the movie rating from the critics
        double web = ((double)web1 + web2 + web3)/3; // Find the average for the web ratings
        double foc = (foc1 + foc2)/2; // Find the average for the focus group ratings
        System.out.println("Average website rating: " + web); // Display avg web rating
        System.out.println("Average focus group rating: " + foc); // Display avg foc grp rating
        System.out.println("Average movie critic rating: " + crt); // Display critic rating
        System.out.println("Overall movie rating: " + ((web*.2) + (foc*.3) + (crt*.5))); // Find and display overall movie rating
    }
}