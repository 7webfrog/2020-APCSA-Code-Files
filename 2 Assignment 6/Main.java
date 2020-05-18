/* Ryan Lutz
 * 10/22/19
 * M2A6
 */
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Create scanner
        ArrayList<TeamMember> list = new ArrayList<TeamMember>(); // ArrayList for team members

        // Gather input
        System.out.println("Enter the next name:"); // Print to console
        String in = scan.nextLine(); // Get input
        String in2; // Declare var for id input
        while (!in.toUpperCase().equals("STOP")) { // While the user didn't enter stop
            System.out.println("Enter the next ID:"); // Print to console
            in2 = scan.nextLine(); // Get input
            list.add(new TeamMember(in, in2)); // Add the team member to the list
            System.out.println("Enter the next name: "); // Print to console
            in = scan.nextLine(); // Get input
        }
        scan.close(); // Close the scanner

        // Sort
        for (int i=1; i<list.size(); i++) { // For each element in the list
            TeamMember temp = list.remove(i); // Declare temp var for the current element and remove it
            int pos = i; // Initialize var for position to re-insert the temp element at the current position in the ArrayList
            while (pos > 0 && temp.compareTo(list.get(pos - 1)) < 0) { // While not at the beginning of the array and temp should be before the element at pos-1
                pos--; // Decrement pos
            }
            // After the loop has found where temp is supposed to be
            list.add(pos, temp); // Add temp at pos
        }
        System.out.println(list); // Print the list to the console
    }
}