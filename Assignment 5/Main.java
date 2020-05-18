/*
 * Ryan Lutz
 * 9/19/19
 * M1A5
 */
import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Create the scanner
        System.out.println("How long do you want the array?"); // Print to console
        int lng = scan.nextInt(); // Get the length input
        if (lng <= 0) { // If length is invalid
            System.out.println("Not a valid length!"); // Print to console
            scan.close(); // Close the scanner
            return; // Exit the program
        }
        double[] array = new double[lng]; // Create a new array
        for (int i = 0; i < array.length; i++) { // For each container in the array
            System.out.println("Enter a number"); // Print to console/Ask for input
            array[i] = scan.nextDouble(); // Store input in the array
        }
        scan.close(); // Close the scanner
        System.out.print("Your array is {"); // Print to console
        for (int j = 0; j < array.length-1; j++) { // For each element in the array
            System.out.print(array[j]+", "); // Print the element to the same line of the console
        }
        System.out.print(array[array.length-1]+"}\n"); // On the last element, close the brace
        double average = 0; // Declare double for average
        for (int k = 0; k < array.length; k++) { // For each element in the array
            average += array[k]; // Add the value to average to find the sum
        }
        average /= array.length; // Divide by the length of the array
        System.out.println("The average is "+average); // Print to console
        double min = array[0]; // Declare double for min and set it to the first element
        double max = array[0]; // Declare double for max and set it to the first element
        for (int l = 0; l < array.length; l++) { // For each element of the array
            if (array[l] > max) { // If value is greater than the max
                max = array[l]; // Set max to that value
            }
            if (array[l] < min) { // If value is greater than the min
                min = array[l]; // Set min to that value
            }
        }
        System.out.println("The range is "+(max-min)); // Print to console
        int minf = 0, maxf = 0; // Declare ints for flags
        for (int m = 0; m < array.length-1; m++) { // For each element in the array
            if (!(array[m] <= array[m+1]) && minf != 1) { // If first element is not less than second element and flag has not been set
                minf = 1; // Set the flag
            } else if (!(array[m] >= array[m+1]) && maxf != 1) { // If first element is not greater than the second element and flag has not been set
                maxf = 1; // Set the flag
            }
        }
        if (minf != 1) { // If increasing flag has not been set
            System.out.println("The array is sorted in increasing order"); // Print to console
        } else if (maxf != 1) { // If decreasing flag has not been set
            System.out.println("The array is sorted in decreasing order"); // Print to console
        } else {
            System.out.println("The array is unsorted"); // Print to console
        }
    }
}