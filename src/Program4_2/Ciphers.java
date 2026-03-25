/*
Program 4.5 RSAEncryption
Encodes and decodes messages using an RSA encryption.
CS160-03
3/19/2026
@author Asher Plotsky
*/
package Program4_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ciphers {
    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: encrypt/decrypt fileName");
            System.exit(1);
        }
        if (!args[0].equals("encrypt/decrypt")) {
            System.err.println("Usage: encrypt/decrypt fileName");
            System.exit(1);
        }
        if (readFile(args[1]) == null){
            System.err.println("File not found");
            System.exit(1);
        }
        try {
            RSAEncryption rsa = new RSAEncryption(61, 53, 7);
            String plainText = readFile(args[1]);
            String encrypted = rsa.encrypt(plainText);
            writeFile("encrypted.txt", encrypted);
            System.out.println("Text encrypted, Key values: " + rsa.getN() + " " + rsa.getE() + " " + rsa.getD());
            System.out.println("Decrypted text: \n" + rsa.decrypt(encrypted));
        }
        catch (IOException ex) {
            System.out.println("File error: " + ex.getMessage());
        }
    }
    public static String readFile(String fileName)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br ==  null){
            return null;
        }
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
