/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.GlavniProzor;
import Program.Podaci;

/**
 *
 * @author Zoran
 */
public class Main {

    public static void main(String[] args) {
        Podaci podaci = new Podaci();
        podaci.ucitaj();
        new GlavniProzor();
    }
    
}
