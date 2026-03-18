/*
Program 4 Ciphers
Changes letter from the encoding or decoding methods in Ciphers.java
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

    /**
     * While encoding changes what letter the letter is up by the value of the key letter
     * @param c
     * @param k
     * @return
     */
    public static char shiftUpByK(char c, int k){
        int characterValue = c + k;
        while (characterValue > ALPHABET.charAt(ALPHABET.length() - 1)) {
            characterValue -= NUM_LETTERS;
        }
        return (char) characterValue;
    }

    /**
     * While decoding changes what letter the letter is down by the value of the key letter
     * @param c
     * @param k
     * @return
     */
    public static char shiftDownByK(char c, int k){
        int characterValue = c - k;
        while (characterValue < ALPHABET.charAt(0)) {
            characterValue += NUM_LETTERS;
        }
        return (char) characterValue;
    }

}
