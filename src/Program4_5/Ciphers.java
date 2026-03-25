/*
Program 4.5 RSAEncryption
Encodes and decodes messages using an RSA encryption.
CS160-03
3/19/2026
@author Asher Plotsky
*/
package Program4_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ciphers {
    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: encrypt/decrypt fileName");
            return;
        }
        if (args[0].equals("encrypt")) {
            try {
                RSAEncryption rsa = new RSAEncryption(61, 53, 7);
                String plainText = readFile(args[1]);
                String encrypted = rsa.encrypt(plainText);
                writeFile("encrypted.txt", encrypted);
                System.out.println("Text encrypted, Key values: " + rsa.getN() + " " + rsa.getE() + " " + rsa.getD());
            } catch (IOException ex) {
                System.out.println("File not found");
            }
        }
        else if (args[0].equals("decrypt")) {
            try {
                RSAEncryption rsa = new RSAEncryption(61, 53, 7);
                String plainText = readFile(args[1]);
                String decrypted = rsa.decrypt(plainText);
                writeFile("decrypted.txt", decrypted);
                System.out.println("Text decrypted, Key values: " + rsa.getN() + " " + rsa.getE() + " " + rsa.getD());
            } catch (IOException ex) {
                System.out.println("File not found");
            }
        }
        else {
            System.err.println("Usage: encrypt/decrypt fileName");
            return;
        }
    }
    public static String readFile(String fileName)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null){
            content.append(line);
            content.append("\n");
        }
        br.close();
        return content.toString();
    }
    public static void writeFile(String fileName, String text)throws IOException{
        Files.write(Paths.get(fileName), text.getBytes());
    }
}
