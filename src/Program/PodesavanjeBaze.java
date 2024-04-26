/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zoran
 */
public abstract class PodesavanjeBaze <E> {
    private int zadnjiID = 0;
    
    private HashMap<Integer, E> primer = new HashMap();
    public PodesavanjeBaze() {
    }
    public int dodaj(E element){
        zadnjiID++;
        primer.put(zadnjiID, element);
        return zadnjiID;
    } 
    public void dodaj(int id, E element){
        if(id > zadnjiID) {
            zadnjiID = id;
        }
        primer.put(id, element);
    }
    public HashMap<Integer, E> sve() {
        return primer;
    }    
    public E nadji(int id) {
        return primer.get(id);
    }  
    abstract public void ucitaj() throws FileNotFoundException, IOException; 
    protected ArrayList<ArrayList<String>> ucitajLinije() throws FileNotFoundException, IOException {
        ArrayList<ArrayList<String>> linije = new ArrayList<>();
        File folder = new File(getFolder());
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            String imeFajla = getFolder()+"/"+listOfFiles[i].getName();
            FileReader filer = new FileReader(imeFajla);
            BufferedReader bufer = new BufferedReader(filer);
            ArrayList<String> linijazaBazu = new ArrayList();
            String line;
            while ((line = bufer.readLine()) != null) {
            linijazaBazu.add(line);
            }
            linije.add(linijazaBazu);
            filer.close();
          }
        }
        return linije;
    }
    abstract public void sacuvaj();
    abstract String getFolder();    
    protected void sacuvaj(HashMap<String, String[]> sveLinije) {
        try {
            novFolder(getFolder());
        } catch (Izuzetak ex) {
            Logger.getLogger(PodesavanjeOsoba.class.getName()).log(Level.SEVERE, null, ex);
            new Obavestenje("Pravljenje foldera nije uspelo "+getFolder()+".");
            return;
    }   
        for(Map.Entry<String, String[]> linije: sveLinije.entrySet()) {
            PrintWriter print;
            FileWriter file;
            try {
                file = new FileWriter(getFolder()+"/"+linije.getKey()+".txt", false);
            } catch (IOException ex) {
                Logger.getLogger(PodesavanjeOsoba.class.getName()).log(Level.SEVERE, null, ex);
                new Obavestenje("Cuvanje nije uspelo");
                return;
            }
            print = new PrintWriter(file);
            for(String linija: linije.getValue()) {
            print.println(linija);
            }
            print.close();
        }       
    }
    protected void novFolder(String imeFoldera) throws Izuzetak {
        File folder = new File(imeFoldera);
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (SecurityException ex) {
                new Obavestenje("Pravljenje foldera nije uspelo");
                throw new Izuzetak();
            }
        }
    }
}

