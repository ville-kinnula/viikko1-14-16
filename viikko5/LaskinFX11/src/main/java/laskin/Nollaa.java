/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo=Integer.parseInt(this.tuloskentta.getText());
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("" + 0);
        nollaa.disableProperty().set(true);
        undo.disableProperty().set(false);
    }
    
    @Override
    public void peru() {
        sovellus.plus(this.arvo);
        syotekentta.setText("");
        tuloskentta.setText("" + this.arvo);
        if ( sovellus.tulos()==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    }
    
    
}