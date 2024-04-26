/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

/**
 *
 * @author Zoran
 */
class Model {
    protected int ID;
    
    public Model(int ID, PodesavanjeBaze baza) {
    this.ID = ID;
    baza.dodaj(ID, this);
    }
    public Model(PodesavanjeBaze baza) {
    this.ID = baza.dodaj(this);
    }  
    public int getID() {
        return ID;
    }
}
