/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Program.Osoba;
import Program.Podaci;
import Program.PodesavanjeBaze;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Zoran
 */
public class TelefonskiImenik extends JFrame{
private DodajOsobuDugme dodaj = new DodajOsobuDugme(this);
    public TelefonskiImenik() {
        setTitle("Telefonski Imenik");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(4,4));
        addComponents();
    }

    private void addComponents() {
        PodesavanjeBaze baza = Podaci.getPodaci().getPodesavanjeOsoba();
        for(int i = 1; i<=baza.sve().size(); i++) {
            Osoba osoba = (Osoba) baza.nadji(i);
            OsobaDugme dugme = new OsobaDugme(this, osoba);
            add(dugme);
        }
        add(dodaj);
    }
private static class DodajOsobuDugme extends JButton {
    private TelefonskiImenik prozor;
    public DodajOsobuDugme(TelefonskiImenik prozor) {
        super("Dodaj osobu");
        this.prozor = prozor;
        addActionListener((ActionEvent e) -> {
        int broj =342 ;
        new Osoba("Osoba", "","",broj);
        Podaci.getPodaci().sacuvaj();
        prozor.dispose();
        new TelefonskiImenik();
        });   
    }
}
public class OsobaDugme extends JButton {
    public OsobaDugme(TelefonskiImenik prozor, Osoba osoba) {
        super(osoba.getIme() + " " + osoba.getPrezime());
        addActionListener((e) -> {
        prozor.dispose();
        new Imenik(osoba);
        });
    } 
}
}
