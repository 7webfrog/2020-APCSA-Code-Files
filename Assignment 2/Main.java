import java.util.Scanner;
import java.lang.Math;

/* 
 * Ryan Lutz
 * 9/9/19
 * M1A2
 */
class Main {
    public static void main(String[] args) {
        System.out.println("Seconds Since Unix Epoch:");
        Scanner scan = new Scanner(System.in); // Create scanner
        int num = scan.nextInt(); // Get int value from user
        int temp = num % 31104000; // Find the remainder seconds to be used for later calcs
        int year = ((num - temp) / 31104000) + 1970; // Calculate the year
        num = temp % 2592000; // Set num = to the remainder of seconds to be used later
        int month = (temp - num) / 2592000; // Calculate the month
        temp = num % 86400; // Set temp = to the remainder of seconds to be used later
        int day = (num - temp) / 86400; // Calculate the month
        num = temp % 3600; // Set num = to the remainder of seconds to be used later
        int hour = (temp - num) / 3600; // Calculate the hour
        temp = num % 60; // Set temp = the remainder of seconds to be displayed
        int min = (num - temp) / 60; // Calculate the min
        int sec = temp; // Set sec = to the number of seconds found earlier
        System.out.println("\nYear: "+year+"\nMonth: "+month+"\nDay: "+day+"\nHour: "+hour+"\nMin: "+min+"\nSec: "+sec); // Print to console
        scan.close(); // Close the scanner
    }
}