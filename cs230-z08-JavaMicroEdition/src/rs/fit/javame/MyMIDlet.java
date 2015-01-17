/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.javame;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

public class MyMIDlet extends MIDlet implements CommandListener{

    protected boolean  started = false; /* on/off */
    private Display    display;         /* glavni display */
    private Command    cmdExit,         /* izlazak iz aplikacije */
                       cmdGoToList,     /* prelazak na displej sa listom */ 
                       cmdSave,         /* snimanje podataka u listu */
                       cmdDelete,       /* brisanje podataka iz litse */
                       cmdBack;         /* vracanje na glavni displej */
    
    private Form       forma;           /* glavna forma za unos podataka u listu */
    private TextField  formaKnjiga, formaOsoba; /* komponente forme */
    private StringItem formaOutput;             /* form response */
    private List       list = new List("Black list", List.MULTIPLE); 
      
    /**
     * Metoda koja se poziva prilikom pokretanja aplikacije.
     * U njoj se setuju pocetne komande, scene odnosno ekrani i inicijalizuje se 
     * pocetni ekran koji predstavlja formu za unos.
     */
    public void startApp() {
        if(!started) {
            started = true;
            
            //Kreiranje komandi
            createCommands();
            //Kreiranje displeja
            createScenes();
            //Inicijalizacija pocetnog ekrana
             display.getDisplay(this).setCurrent(forma);
        }
    }
    
    /**
     * Metoda koja se poziva u trenutku kada je potrebno pauzirati aplikaciju 
     * sto za ovaj domaci nije potrebno.
     */
    public void pauseApp() {
    }
    
    /**
     * Metoda koja se poziva ukoliko je potrebno izaci iz aplikacije. Metoda
     * se poziva prilikom pritiska na dugme cmdExit
     * @param unconditional 
     */
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    /**
     * Metoda kojoj se prosledjuju dva parametra
     * @param c - komanda koja je trenutno pritisnuta
     * @param d - displej na kome se trenutno nalazimo
     * Na osnovu displeja na kome se trenutno nalazimo ondosno komandnih dugmati
     * koji se pritiskaju mogu se odrediti specificne akcije za te slucajeve kao
     * sto se moze videti u ovoj metodi.
     */
    public void commandAction(Command c, Displayable d) {
        /* dugmati na prvom ekranu, na prvoj formi */
        if(d == forma) {
            if (c == cmdExit) { //izadji iz aplikacije
                destroyApp(true);
            }
            if (c == cmdSave) { //dodaj u listu
                listAdd(formaKnjiga.getString(), formaOsoba.getString());
            }
            if (c== cmdGoToList) {//predji na drugu scenu
                display.getDisplay(this).setCurrent(list);
            }
        }
        
        /* dugmadi na drugom ekranu, na ekranu sa listom */
        if (d == list) {
            if (c == cmdDelete) {//obrisi stavku iz liste
                listDelete();
            }
            if (c == cmdBack) {//vrati se na pocetni ekran
                display.getDisplay(this).setCurrent(forma);
            }
        }
    }
    
    /**
     * Metoda u kojoj se kreiraju komandna dugmad
     */
    private void createCommands() {
        cmdExit = new Command("Exit", Command.OK, 2);
        cmdGoToList = new Command("Black List", Command.OK, 2);
        cmdSave = new Command("Save", Command.OK, 2);
        cmdDelete = new Command("Delete", Command.OK, 2);
        cmdBack = new Command("Back", Command.OK, 2);
    }
    
    /**
     * Metoda u kojoj se kreiraju scene/ekrani/displeji za svaku od stranica.
     * Ova metoda poziva se u startApp metodi 
     */
    private void createScenes() {
        firstScene();
        secondScene();
    }
    
    /**
     * Metoda u kojoj se inicijalizuje prvi, pocetni displej
     */
    private void firstScene() {
        forma = new Form("Welcome to Miksi's first MIDlet");
        forma.append(formaKnjiga = new TextField("Book: ", "", 32, TextField.ANY));
        forma.append(formaOsoba  = new TextField("Person: ", "", 32, TextField.ANY));
        forma.append(formaOutput = new StringItem("", "", StringItem.PLAIN));
        formaOutput.setLayout(ImageItem.LAYOUT_CENTER | Item.LAYOUT_TOP | Item.LAYOUT_BOTTOM | Item.LAYOUT_VCENTER | Item.LAYOUT_SHRINK);
        forma.addCommand(cmdSave = new Command("Save", Command.OK, 2));
        forma.addCommand(cmdGoToList = new Command("Black List", Command.OK, 2));
        forma.addCommand(cmdExit = new Command("Exit", Command.OK, 2));
        forma.setCommandListener(this);
        list.append("primer knjiga (primer osoba)", null);
    }
    
    /**
     * Metoda u kojoj se inicijalizuje druga scena, drugi displej koji 
     * prikazuje listu duznika
     */
    private void secondScene() {
        list.addCommand(cmdDelete = new Command("Delete", Command.OK, 2));
        list.addCommand(cmdBack = new Command("Back", Command.OK, 2));
        list.setCommandListener(this);
        
        display.getDisplay(this).setCurrent(list);
    }
    
    /**
     * Metoda koja dodaje item (Knjiga + Osoba) u listu
     * @param knjiga
     * @param osoba 
     */
    private void listAdd(String knjiga, String osoba) {
        if(!knjiga.equals("") && !knjiga.equals("")) {
            
            list.append(knjiga + "(" + osoba + ")", null);
            formaKnjiga.setString("");
            formaOsoba.setString("");
            formaOutput.setText("Successfully added to list.");
        } else {
            formaOutput.setText("Fill in all fields!");
        }
    }
    
    /**
     * Metoda koja brise item iz liste
     */
    private void listDelete() {
        boolean selected[] = new boolean[list.size()];
     
        //Fill array indicating whether each element is checked 
        list.getSelectedFlags(selected);

        for (int i = 0; i < list.size(); i++)
            if(selected[i]) {
                list.delete(i);
                System.out.println("Deleting item from list..");
                //System.out.println("Item " + list.getString(i).toUpperCase() + " deleting from list..");
            }
    }
    
}
