/*
 * Ryan Lutz
 * 10/18/19
 * M2A5
 */

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        GameWheel g = new GameWheel(); // Declare new game wheel
        int winnings, h = 0; // Declare ints for winnings and a flag
        Slice d = g.spinWheel(); // Get the slice from spinning the wheel and store it in d
        Slice e = g.spinWheel(); // Get the slice from spinning the wheel and store it in e
        Slice f = g.spinWheel(); // Get the slice from spinning the wheel and store it in f
        if (d.getColor().equals(e.getColor()) && e.getColor().equals(f.getColor())) { // If all the colors are the same
            h = 1; // Set the flag
            winnings = 2*(d.getPrizeAmount() + e.getPrizeAmount() + f.getPrizeAmount()); // Double the winnings
        } else {
            winnings = d.getPrizeAmount() + e.getPrizeAmount() + f.getPrizeAmount(); // Total the winnings
        }
        System.out.println("Total prize money: $"+winnings); // Print the total winnings and each spin to the console
        System.out.println("Spin 1 - Color: "+d.getColor()+", Prize Amount: $"+d.getPrizeAmount());
        System.out.println("Spin 2 - Color: "+e.getColor()+", Prize Amount: $"+e.getPrizeAmount());
        System.out.println("Spin 3 - Color: "+f.getColor()+", Prize Amount: $"+f.getPrizeAmount());
        if (h == 1) { // If flag has been set
            System.out.println("Three "+d.getColor()+"s = double your money!"); // Print that the money is doubled
        }
    }
}