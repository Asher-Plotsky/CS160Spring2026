package Project7;
/*
Program 7 Drawing An Upside Down Triangle
Draw an upside down Triangle using recursion.
CS160-03
4/24/2026
@author Asher Plotsky
*/

import java.util.Scanner;

public class LabProgram {

    /* TODO: Write recursive drawTriangle() method here. */
    public static void drawTriangle(int length){
        if (length <= 0) return;
        int spaces = 0;
        int counter = 19;
        while (counter > length){
            spaces++;
            counter -= 2;
        }
        for (int i = 0; i < spaces; i++){
            System.out.print(" ");
        }
        for (int i = 0; i < length; i++){
            System.out.print("*");
        }
        System.out.println();
        drawTriangle(length - 2);
        return;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int baseLength;

        baseLength = scnr.nextInt();
        drawTriangle(baseLength);
    }
}
