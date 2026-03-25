/*
Program 4.5 RSAEncryption
Encodes and decodes messages using an RSA encryption.
CS160-03
3/19/2026
@author Asher Plotsky
*/
package Program4_5;

import java.math.BigInteger;

public class RSAEncryption {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

    /**
     * Assigns values to variables.
     * @param p
     * @param q
     * @param e
     */
    public RSAEncryption(int p, int q, int e) {
        this.p = BigInteger.valueOf(p);
        this.q = BigInteger.valueOf(q);
        this.e = BigInteger.valueOf(e);
        n = BigInteger.valueOf(p * q);
        d = this.calculatePrivateKey();
    }

    /**
     * Calculates value of int d based on ints p, q, and e
     * @return
     */
    private BigInteger calculatePrivateKey(){
        BigInteger phi = BigInteger.valueOf((p.intValue() - 1) * (q.intValue() - 1));
        d = e.modInverse(phi);
        return d;

    }

    /**
     * Encrypts message per character
     * @param message
     * @return
     */
    public String encrypt(String message){
        BigInteger M = BigInteger.valueOf((int)message.charAt(0));
        BigInteger C = M.modPow(e, n);
        String encrypted = C.toString();
        for(int i = 1; i < message.length(); i++){
            M = BigInteger.valueOf((int)message.charAt(i));
            C = M.modPow(e, n);
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
            BigInteger M = C.modPow(d, n);
            decrypted = decrypted + (char) M.intValue();
        }
        return decrypted;
    }

    /**
     * Returns value of BigInteger n
     * @return
     */
    public int getN(){
        return n.intValue();
    }

    /**
     * Returns value of BigInteger e
     * @return
     */
    public int getE(){
        return e.intValue();
    }

    /**
     * Returns value of BigInteger d
     * @return
     */
    public int getD(){
        return d.intValue();
    }

    /**
     * Sets value of BigInteger p
     * @param p
     */
    public void setP(int p){
        this.p = BigInteger.valueOf(p);
    }

    /**
     * Sets value of BigInteger q
     * @param q
     */
    public void setQ(int q){
        this.q = BigInteger.valueOf(q);
    }
}
