/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9pta1solucio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

/**
 *
 * @author Jordi Selga
 * Possible solució a la Pta1 M9 Xifrat Simètric
 * Emissor
 */
public class emissor {
    
    /**
     * Main function to encrypt input text on a file. It also saves the key for later use.
     * @param args 
     */
    public static void main(String[] args) {
        final String FILE_KEY = "clauXifrat.aes";
        final String FILE_MSG = "dadesXifrades.aes";
        // agafem les dades de teclat amb el mètode getText() i creem l'array msg
        byte [] msg = getText();
        //Creem els objectes File dels fitxes de sortida (Clau i Missatge Xifrat)
        File fclau = new File(FILE_KEY); 
        File fmsg = new File(FILE_MSG);
        //Creem un objecte SecretKey amb l'ajuda del mètode KeyGenerator
        SecretKey sk = CryptTools.KeyGenerator(128);
        //Xifrem el missatge amb el mètode encryptData a partir d'una clau i un missatge
        byte [] msgXif = CryptTools.encryptData(sk, msg);
       
        escriuFitxer(fclau,sk.getEncoded());
       
        escriuFitxer(fmsg,msgXif);
        
    }
    /**
     * Mètode que agafa text introduït per teclat i el treu en forma de byte[]
     * @return byte [] text
     */
    public static byte [] getText(){
        System.out.println("Introdueix missatge:");
        Scanner sc = new Scanner(System.in);
        byte [] text;
        text = sc.nextLine().getBytes();
        return text;
    }
    
    /**
     * Writes a file to the current working directory
     * @param fitxer
     * @param dades 
     */
    public static void escriuFitxer(File fitxer, byte[] dades){
        
        
        try {
            FileOutputStream fos = new FileOutputStream(fitxer);
            fos.write(dades);
            fos.close();
                    } catch (IOException ex) {
            Logger.getLogger(emissor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
