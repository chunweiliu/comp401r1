package example;

import java.util.Scanner;

public class SandwichMaker {


    static int peanutButter = 0;
    static int jelly = 0;
    static int breadSlices = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int desiredAmt;
        System.out.println("How many sandwiches would you like made?");
        desiredAmt = s.nextInt();
        while (desiredAmt > 0) {
            makeSandwiches(desiredAmt);
            System.out.println("Do you want more sandwiches? (specify amount, or any number less than or equal to zero to end):");
            desiredAmt = s.nextInt();  
        }
        System.out.println("Thank you for dining at Cafe 401!");
        s.close();
    }

    public static void makeSandwiches(int sandwichCount) {
        //sandwichCount is the number of sandwiches you want to make

        for (int i = 0; i < sandwichCount; i++) {
            if (breadSlices < 2) {
                buyBread();
            }
            if (peanutButter == 0) {
                buyPeanutButter();
            }
            if (jelly == 0) {
                buyJelly();
            }
            assembleSandwich();
            System.out.println("Made sandwich number " + (i+1));
        }
    }

    public static void assembleSandwich() {
        breadSlices -= 2;
        peanutButter--;
        jelly--;
    }

    public static void buyBread() {
        System.out.println("Went out and bought bread");
        breadSlices += 12;
    }

    public static void buyJelly() {
        System.out.println("Went out and bought jelly");
        jelly += 7;
    }

    public static void buyPeanutButter() {
        System.out.println("Went out and bought peanut butter");
        peanutButter += 9;
    }
}