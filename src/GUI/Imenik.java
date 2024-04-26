/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Program.Obavestenje;
import Program.Osoba;
import Program.Podaci;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Zoran
 */
public class Imenik extends JFrame {
    private Osoba osoba;
    private JLabel imel=new JLabel("Ime");
    private JLabel prezimel=new JLabel("Prezime");
    private JLabel adresal=new JLabel("Adresa");
    private JLabel brojl=new JLabel("Broj Telefona");
    private JTextField imet;
    private JTextField prezimet;
    private JTextField adresat;
    private JTextField brojt;
    private SacuvajDugme sacuvaj = new SacuvajDugme(this);
    private NazadDugme nazad = new NazadDugme(this);

    public Imenik(Osoba osoba) {
        super("Izmeni informacije");
        this.osoba = osoba;
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(5,4));
        setupComponents();
        addComponents();
    }
    
    private void setupComponents() {
        imet = new JTextField(osoba.getIme());
        prezimet = new JTextField(osoba.getPrezime());
        adresat = new JTextField(osoba.getAdresa());
        brojt= new JTextField(Integer.toString(osoba.getBrojTelefona()));   
    }
    private void addComponents() {
        add(imel);
        add(imet);
        add(prezimel);
        add(prezimet);
        add(adresal);
        add(adresat);
        add(brojl);
        add(brojt);
        add(nazad);
        add(sacuvaj);
    }
    public Osoba getOsoba() {
        return osoba;
    }
    public String getIme() {
        return imet.getText();
    }
    public String getPrezime() {
        return prezimet.getText();
    }
    public String getAdresa() {
        return adresat.getText();
    }
    public int getBroj() throws NumberFormatException {
        return Integer.parseInt(brojt.getText());
    }
    public class NazadDugme extends JButton{
    private Imenik prozor;
    public NazadDugme(Imenik prozor) {
        super("Nazad");
        this.prozor = prozor;
        addActionListener((e) -> {
        prozor.dispose();
        new TelefonskiImenik();
        });
    }
}
public class SacuvajDugme extends JButton {
    public SacuvajDugme(Imenik forma) {
        super("Sacuvaj");
        addActionListener((ActionEvent e) -> {
        int brojTelefona;        
        try {
        brojTelefona = forma.getBroj();
        } catch (NumberFormatException ae) {
        new Obavestenje("Broj telefona mora biti broj");
        return;
        }
        Osoba osoba = forma.getOsoba();
        osoba.setIme(forma.getIme());
            osoba.setPrezime(forma.getPrezime());
            osoba.setAdresa(forma.getAdresa());
            osoba.setBrojTelefona(brojTelefona);
            forma.dispose();
            new TelefonskiImenik();
            Podaci.getPodaci().sacuvaj();
        });
    }   
} 
}

