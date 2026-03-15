/*
Program 4 Ciphers
Rolls dice until desired roll is achieved.
CS160-03
3/14/2026
@author Asher Plotsky
*/
package Program4;

public class Util4 {
    public String getID(){
        return "Program 4, Asher Plotsky";
    }
    public static final int NUM_LETTERS = 26;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static char shiftUpByK(char c, int k){
        int characterValue = c + k;
        while (characterValue > ALPHABET.charAt(ALPHABET.length() - 1)) {
            characterValue -= NUM_LETTERS;
        }
        return (char) characterValue;
    }
    public static char shiftDownByK(char c, int k){
        int characterValue = c - k;
        while (characterValue < ALPHABET.charAt(0)) {
            characterValue += NUM_LETTERS;
        }
        return (char) characterValue;
    }

}
