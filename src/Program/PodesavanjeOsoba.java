/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Zoran
 */
public class PodesavanjeOsoba extends PodesavanjeBaze<Osoba> {
    private static String folder = "Osobe";
    public String getFolder() {
        return folder;
    }
    public void ucitaj() throws FileNotFoundException, IOException{
        ArrayList<ArrayList<String>> linijeOsoba = super.ucitajLinije();
        for(ArrayList<String> linije: linijeOsoba) {
            int id,brojTelefona;
            try {
            id = Integer.parseInt(linije.get(0));
            brojTelefona = Integer.parseInt(linije.get(4));
            } catch(NumberFormatException ex) {
            new Obavestenje("Los ID" + linije.get(0));
            new Obavestenje("Nemoze slovo mora da bude broj" + linije.get(4));
            return;
            }
            Osoba osoba = Osoba.ucitaj(id, linije.get(1), linije.get(2), linije.get(3), brojTelefona);
        }
    }
    public void sacuvaj() {
        HashMap<String, String[]> sveLinije = new HashMap();
        HashMap<Integer, Osoba> sveOsobe = sve();
        for(Osoba osoba: sveOsobe.values()) {
            String[] linije = {
            Integer.toString(osoba.getId()),
            osoba.getIme(),
            osoba.getPrezime(),
            osoba.getAdresa(),
            Integer.toString(osoba.getBrojTelefona())
            };
            sveLinije.put(Integer.toString(osoba.getId()), linije);
        }
        super.sacuvaj(sveLinije);
    }
}
