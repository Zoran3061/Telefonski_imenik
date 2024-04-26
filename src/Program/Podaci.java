/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zoran
 */
public class Podaci {
    private static Podaci podaci;    
    private PodesavanjeOsoba podesavanjeOsoba = new PodesavanjeOsoba();
  
    public static Podaci getPodaci() {
        if(podaci == null) {
        return podaci = new Podaci();
        }
        return podaci;
    }
    public PodesavanjeOsoba getPodesavanjeOsoba() {
    return podesavanjeOsoba;
    }
    public void sacuvaj() {
        podesavanjeOsoba.sacuvaj();
    }
    public void ucitaj() {
        try {
            podesavanjeOsoba.ucitaj();
        } catch (IOException ex) {
            Logger.getLogger(Podaci.class.getName()).log(Level.SEVERE, null, ex);
            new Obavestenje("Nije uspelo ucitavanje.Probajte opet!"+ex);
        }
    }
}
