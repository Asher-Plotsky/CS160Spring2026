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
import java.io.File;

public class Ciphers {
    /**
     * Encodes a message based on the key provided
     * @param in
     * @param out
     * @param key
     */
    public static void encrypt(Scanner in, PrintWriter out, String key) {
        int keyLength = key.length();
        int keyPosition = 0;
        int keyInt;
        String nextLine = "";
        while (in.hasNextLine()) {
            String cipherText = "";
            nextLine = in.nextLine();
            for (int i = 0; i < nextLine.length(); i++) {
                char ch =  nextLine.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    keyInt = Character.toLowerCase(key.charAt(keyPosition)) - 'a';
                    cipherText += Util4.shiftUpByK(ch, keyInt);
                    keyPosition = (keyPosition + 1) % keyLength;
                }
                else {
                    cipherText += ch;
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
    public static void decrypt(Scanner in, PrintWriter out, String key) {
        int keyLength = key.length();
        int keyPosition = 0;
        int keyInt;
        String nextLine = "";
        while (in.hasNextLine()) {
            String decipherText = "";
            nextLine = in.nextLine();
            for (int i = 0; i < nextLine.length(); i++) {
                char ch =  nextLine.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    if (keyPosition == keyLength) {
                        keyPosition = 0;
                    }
                    keyInt = Character.toLowerCase(key.charAt(keyPosition)) - 'a';
                    decipherText += Util4.shiftDownByK(ch, keyInt);
                    keyPosition = (keyPosition + 1) % keyLength;
                }
                else {
                    decipherText += ch;
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
        if (args.length != 3){
            System.out.println("Wrong number of arguments");
            return;
        }
        if (!args[0].equals("encrypt") && !args[0].equals("decrypt")) {
            System.out.println("Wrong arguments");
            return;
        }
        File file = new File(args[2]);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        Scanner in;
        PrintWriter out;
        if (args[0].equals("encrypt")) {
            String fileName = file.getName();
            int split = fileName.lastIndexOf('.');
            String returnFile =  fileName.substring(0, split + 1) + "crypt";
            in = new Scanner(new FileInputStream(args[2]));
            out = new PrintWriter(new FileOutputStream(returnFile));
            Ciphers.encrypt(in, out, args[1]);
        } else if (args[0].equals("decrypt")) {
            String fileName = file.getName();
            int split = fileName.lastIndexOf('.');
            String returnFile =  fileName.substring(0, split + 1) + "decrypt";
            in = new Scanner(new FileInputStream(args[2]));
            out = new PrintWriter(new FileOutputStream(returnFile));
            Ciphers.decrypt(in, out, args[1]);
        } else {
            throw new IllegalArgumentException("Wrong arguments");
        }
        in.close();
        out.close();
        System.out.println("Finished");

    }
}