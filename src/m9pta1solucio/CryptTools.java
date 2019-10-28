/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9pta1solucio;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author jordi
 */
/**
 * 
 * Classe que conté les eines criptografiques necessàries pel xifrat simètric
 */
public class CryptTools {

    /**
     * Returns a crypotographic key
     * @param keySize
     * @return 
     */
     public static SecretKey KeyGenerator(int keySize) {
        SecretKey sKey = null;
        if ((keySize == 128) || (keySize == 192) || (keySize == 256)) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(keySize);
                sKey = kgen.generateKey();
            } catch (NoSuchAlgorithmException ex) {
                System.err.println("Generador no disponible.");
            }
        }
        return sKey;
    }

     /**
      * Encrypts and returns the given data with a given key
      * @param sKey
      * @param data
      * @return 
      */
     
    public static byte[] encryptData(SecretKey sKey, byte[] data) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            System.err.println("Error xifrant les dades: " + ex);
        }
        return encryptedData;
    }

    /**
     * Decrypts and returns the given data with a given key
     * @param sKey
     * @param data
     * @return 
     */
    
    public static byte[] decryptData(SecretKey sKey, byte[] data){
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKey);
            encryptedData = cipher.doFinal(data);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            System.err.println("Error xifrant les dades: " + ex);
        }
        return encryptedData;
    }
    
}
