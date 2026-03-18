/*
Program 4 Ciphers
Encodes and decodes messages using the Caesar Cipher.
CS160-03
3/14/2026
@author Asher Plotsky
*/
package Program4;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class Ciphers {
    /**
     * Encodes a message based on the key provided
     * @param in
     * @param out
     * @param key
     */
    public static void encode(Scanner in, PrintWriter out, String key) {
        int keyLength = key.length();
        int keyPosition = 0;
        int keyInt;
        String cipherText = "";
        String nextLine = "";
        if (in.hasNextLine()) {
            nextLine = in.nextLine();
            for (int i = 0; i < nextLine.length(); i++, keyPosition++) {
                if (Character.isAlphabetic(nextLine.charAt(i))) {
                    if (keyPosition == keyLength) {
                        keyPosition = 0;
                    }
                    keyInt = key.charAt(keyPosition) - 'a';
                    cipherText += Util4.shiftUpByK(nextLine.charAt(i), keyInt);
                }
                else {
                    cipherText += " ";
                }
            }
            out.println(cipherText);
        }
    }

    /**
     * Decodes a message based on the key provided
     * @param in
     * @param out
     * @param key
     */
    public static void decode(Scanner in, PrintWriter out, String key) {
        int keyLength = key.length();
        int keyPosition = 0;
        int keyInt;
        String decipherText = "";
        String nextLine = "";
        if (in.hasNextLine()) {
            nextLine = in.nextLine();
            for (int i = 0; i < nextLine.length(); i++, keyPosition++) {
                if (Character.isAlphabetic(nextLine.charAt(i))) {
                    if (keyPosition == keyLength) {
                        keyPosition = 0;
                    }
                    keyInt = key.charAt(keyPosition) - 'a';
                    decipherText += Util4.shiftDownByK(nextLine.charAt(i), keyInt);
                }
                else {
                    decipherText += " ";
                }
            }
            out.println(decipherText);
        }
    }

    /**
     * Calls encode or decode based on the command line arguments
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {
        Scanner in;
        PrintWriter out;
        if (args[0].equals("encode")) {
            in = new Scanner(new FileInputStream(args[2]));
            out = new PrintWriter(new FileOutputStream("message.crypt"));
            Ciphers.encode(in, out, args[1]);
        }
        else if (args[0].equals("decode")) {
            in = new Scanner(new FileInputStream(args[2]));
            out = new PrintWriter(new FileOutputStream("message.decrypt"));
            Ciphers.decode(in, out, args[1]);
        }
        else {
            throw new IllegalArgumentException("Wrong arguments");
        }
        in.close();
        out.close();
        System.out.println("Finished");
    }
}
