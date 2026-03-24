/*
Program 4.5 RSAEncryption
Encodes and decodes messages using an RSA encryption.
CS160-03
3/19/2026
@author Asher Plotsky
*/
package Program4_2;

import java.math.BigInteger;

public class RSAEncryption {
    private int p;
    private int q;
    private int n;
    private int e;
    private int d;

    /**
     * Assigns values to variables.
     * @param p
     * @param q
     * @param e
     */
    public RSAEncryption(int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.e = e;
        n = p * q;
        d = this.calculatePrivateKey();
    }

    /**
     * Calculates value of int d based on ints p, q, and e
     * @return
     */
    private int calculatePrivateKey(){
        BigInteger phi = BigInteger.valueOf((p - 1)*(q-1));
        BigInteger bigE = BigInteger.valueOf(e);
        BigInteger bigD = BigInteger.valueOf(d);
        bigD = bigE.modInverse(phi);
        return bigD.intValue();

    }

    /**
     * Encrypts message per character
     * @param message
     * @return
     */
    public String encrypt(String message){
        BigInteger M = BigInteger.valueOf((int)message.charAt(0));
        BigInteger C = M.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
        String encrypted = C.toString();
        for(int i = 1; i < message.length(); i++){
            M = BigInteger.valueOf((int)message.charAt(i));
            C = M.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
            encrypted = encrypted + " " + C.toString();
        }
        return encrypted;
    }

    /**
     * Decrypts encrypted message based on integer value
     * @param ciphertext
     * @return
     */
    public String decrypt(String ciphertext){
        String decrypted = "";
        String[] ciphertexts = ciphertext.trim().split(" ");
        for(String c : ciphertexts){
            BigInteger C = BigInteger.valueOf(Integer.parseInt(c));
            BigInteger M = C.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
            decrypted = decrypted + (char) M.intValue();
        }
        return decrypted;
    }

    /**
     * Returns value of int n
     * @return
     */
    public int getN(){
        return this.n;
    }

    /**
     * Returns value of int e
     * @return
     */
    public int getE(){
        return this.e;
    }

    /**
     * Returns value of int d
     * @return
     */
    public int getD(){
        return this.d;
    }

    /**
     * Sets value of int p
     * @param p
     */
    public void setP(int p){
        this.p = p;
    }

    /**
     * Sets value of int q
     * @param q
     */
    public void setQ(int q){
        this.q = q;
    }
}
