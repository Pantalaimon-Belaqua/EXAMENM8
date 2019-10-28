/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9pta1solucio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Jordi Selga
 * Possible solució a la Pta1 M9 Xifrat Simètric
 * Receptor
 */
public class receptor {
    
    /**
     * Gets an encrypted file and an AES key and prints the data in plain text.
     * @param args 
     */
    public static void main(String[] args) {
        final String FILE_KEY = "clauXifrat.aes";
        final String FILE_MSG = "dadesXifrades.aes";
       
        File fclau = new File(FILE_KEY); 
        File fmsg = new File(FILE_MSG);
        
        byte [] msgXif = llegirFitxer(fmsg);
       
        SecretKey sKey = new SecretKeySpec(llegirFitxer(fclau), "AES");
        
      
        byte [] msg = CryptTools.decryptData(sKey, msgXif);
       
        String dadesClar = new String(msg);
        System.out.println(dadesClar);
    }
 
    /**
     * Reads a given file from the current working directory.   
     * @param fitxer
     * @return 
     */
    public static byte[] llegirFitxer(File fitxer){       
        try {
            byte[] d = Files.readAllBytes(fitxer.toPath());
            return d;
            } catch (Exception io) {
            System.out.println("Error" + io);
        }
        return null;
    }
}
