/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Zoran
 */
public class GlavniProzor extends JFrame{
    private DugmeTelefonskiImenik tImenik = new DugmeTelefonskiImenik(this);
 
    public GlavniProzor() {
        setTitle("Dobrodosli u telefeonski imenik");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(1,1));
        addComponents();
    }

    private void addComponents() {
        add(tImenik);
        
    }

    private static class DugmeTelefonskiImenik extends JButton{
    private GlavniProzor prozor;

    public DugmeTelefonskiImenik(GlavniProzor prozor) {
    super("Klik ovde");
    this.prozor = prozor;
    addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
    prozor.dispose();
    new TelefonskiImenik();
    }
    });
    }
}
}